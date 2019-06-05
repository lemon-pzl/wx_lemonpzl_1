package org.lemonpzl.weixin.service;

public interface TokenManager {
    
	/**
	 * 返回有效的令牌，如果在本地缓存已经过期，那么直接自动调用远程方法过去有效的令牌才返回。
	 * 
	 */
	
  public String getToken(String account); 
}
