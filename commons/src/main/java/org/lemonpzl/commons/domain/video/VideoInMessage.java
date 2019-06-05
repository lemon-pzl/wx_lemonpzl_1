package org.lemonpzl.commons.domain.video;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.lemonpzl.commons.domain.InMessage;

import com.fasterxml.jackson.annotation.JsonProperty;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class VideoInMessage extends InMessage{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "ThumbMediaId")
	@JsonProperty("ThumbMediaId")
	private String thumb_media_id;

	@XmlElement(name = "MediaId")
	@JsonProperty("MediaId")
	private String media_id;
	
	public VideoInMessage() {
		super.setMsgType("video");
	}

	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "VideoInMessage [thumb_media_id=" + thumb_media_id + ", media_id=" + media_id + ", getToUserName()="
				+ getToUserName() + ", getFromUserName()=" + getFromUserName() + ", getCreateTime()=" + getCreateTime()
				+ ", getMsgType()=" + getMsgType() + ", getMsgId()=" + getMsgId() + "]";
	}

	
	
	
	
	
}
