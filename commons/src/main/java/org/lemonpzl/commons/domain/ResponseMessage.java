package org.lemonpzl.commons.domain;

public abstract class ResponseMessage {
	/**
	 * 状态1，表示成功，其他数字表示是失败
	 */
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
  
}
