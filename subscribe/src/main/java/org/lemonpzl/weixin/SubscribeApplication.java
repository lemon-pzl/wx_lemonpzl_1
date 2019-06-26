package org.lemonpzl.weixin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.lemonpzl.commons.config.EventListenerConfig;
import org.lemonpzl.commons.domain.InMessage;
import org.lemonpzl.commons.domain.event.EventInMessage;
import org.lemonpzl.commons.processors.EventMessageProcessor;
import org.lemonpzl.commons.service.JsonRedisSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EntityScan("org.lemonpzl")
@ComponentScan("org.lemonpzl")
@EnableJpaRepositories("org.lemonpzl")
public class SubscribeApplication implements //
  EventListenerConfig,//
   //得到spring的容器
   ApplicationContextAware
{
	private ApplicationContext ctx; //spring容器
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO 自动生成的方法存根
		ctx = applicationContext;
	}
	

	private static final Logger LOG = LoggerFactory.getLogger(SubscribeApplication.class);
	public void handle(EventInMessage msg) {
		// 1.当前类实现ApplicationContextAware接口，用于获得Spring容器
				// 2.把Event全部转换为小写，并且拼接上MessageProcessor作为ID
				String id = msg.getEvent().toLowerCase() + "MessageProcessor";
				// 3.使用ID到Spring容器获取一个Bean
				try {
					EventMessageProcessor mp = (EventMessageProcessor) ctx.getBean(id);
					// 4.强制类型转换以后，调用onMessage方法
					if (mp != null) {
						mp.onMessage(msg);
					} else {
						LOG.warn("Bean的ID {} 无法调用对应的消息处理器: {} 对应的Bean不存在", id, id);
					}
				} catch (Exception e) {
					LOG.warn("Bean的ID {} 无法调用对应的消息处理器: {}", id, e.getMessage());
				//	LOG.trace(e.getMessage(), e);
				}
	}
   
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SubscribeApplication.class, args);
//		System.out.println("Spring Boot应用启动成功");
//		// 让程序进入等待、不要退出
//		CountDownLatch countDownLatch = new CountDownLatch(1);
//		countDownLatch.await();
	}

 
	

}
