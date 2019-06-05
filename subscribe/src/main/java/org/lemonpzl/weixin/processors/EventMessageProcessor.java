package org.lemonpzl.weixin.processors;

import org.lemonpzl.commons.domain.event.EventInMessage;

public interface EventMessageProcessor {
	public void onMessage(EventInMessage msg);

}
