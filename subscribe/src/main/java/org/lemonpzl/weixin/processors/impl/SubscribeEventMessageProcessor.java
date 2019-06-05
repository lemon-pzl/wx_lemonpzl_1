package org.lemonpzl.weixin.processors.impl;

import org.lemonpzl.commons.domain.User;
import org.lemonpzl.commons.domain.event.EventInMessage;
import org.lemonpzl.commons.processors.EventMessageProcessor;
import org.lemonpzl.commons.repository.UserRepository;
import org.lemonpzl.weixin.service.TokenManager;
import org.lemonpzl.weixin.service.WeixinProxy;
import org.springframework.beans.factory.annotation.Autowired;

public class SubscribeEventMessageProcessor implements EventMessageProcessor {
	
	 @Autowired
	 private UserRepository userRepository;
	  
	 @Autowired
	 private WeixinProxy weixinProxy;
	  
	
	@Override
	public void onMessage(EventInMessage msg) {
		if (!msg.getEvent().equals("subscribe")) {
			//非关注事件不处理
			return;
		}
		
		
		String openId = msg.getFromUserName(); //发送操作的用户的openID
		// 1.检查用户是否已经关注
		User user = this.userRepository.findByOpenId(openId);
		
		// 2.如果用户还未关注，则调用远程接口获取用户信息
		if (user == null || user.getStatus() != User.Status.IS_SUBSCRIBE) {
			// 3.调用远程接口
			//TODO 根据TOUSerName找到对应的微信号
			String account = "";
			User wxUser = weixinProxy.getUser(account, openId);
			if(wxUser == null) {
				return;
			}
			// 4.存储到数据库
			if(user !=null) {
				//原来关注过
				wxUser.setId(user.getId());
				wxUser.setSubTime(user.getSubTime());
				wxUser.setUnsubTime(null);
			}
			wxUser.setStatus(User.Status.IS_SUBSCRIBE);
			//如果有id的值，会自动update；没有id的值会insert
			this.userRepository.save(wxUser);
			//通过客服接口，发生一条信息给用户
			weixinProxy.sendText(account,openId,"欢迎关注我的公众号，回复帮助可获得人工智能菜单");
			
			
			
			
		}
		
		
		
	
	}
}