package org.lemonpzl.weixin.processors.impl;

import org.lemonpzl.commons.domain.event.EventInMessage;
import org.lemonpzl.commons.processors.EventMessageProcessor;
import org.springframework.stereotype.Service;

@Service("unsubscribeMessageProcessor")
public class UnsubscribeEventMessageProcessor implements EventMessageProcessor {

	@Override
	public void onMessage(EventInMessage msg) {
		// TODO 自动生成的方法存根
		// 把用户的数据删除，或者标记为已经取消关注即可
		
	}
   
	

}
