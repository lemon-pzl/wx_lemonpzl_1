package org.lemonpzl.commons.domain.link;

import javax.xml.bind.annotation.XmlElement;

import org.lemonpzl.commons.domain.InMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkInMessage extends InMessage{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "Title")
	@JsonProperty("Title")
	private String title;

	@XmlElement(name = "Description")
	@JsonProperty("Description")
	private String description;
	
	@XmlElement(name = "Url")
	@JsonProperty("Url")
	private String url;
	
	
	public LinkInMessage() {
		super.setMsgType("link");
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "LinkInMessage [title=" + title + ", description=" + description + ", url=" + url + ", getToUserName()="
				+ getToUserName() + ", getFromUserName()=" + getFromUserName() + ", getCreateTime()=" + getCreateTime()
				+ ", getMsgType()=" + getMsgType() + ", getMsgId()=" + getMsgId() + "]";
	}
	
	
	
	

}
