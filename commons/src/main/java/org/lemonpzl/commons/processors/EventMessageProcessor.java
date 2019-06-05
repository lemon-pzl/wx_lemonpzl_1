package org.lemonpzl.commons.processors;

import org.lemonpzl.commons.domain.event.EventInMessage;

public interface EventMessageProcessor {
	public void onMessage(EventInMessage msg);

}
