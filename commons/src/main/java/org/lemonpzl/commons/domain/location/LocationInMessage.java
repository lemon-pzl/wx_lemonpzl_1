package org.lemonpzl.commons.domain.location;

import javax.xml.bind.annotation.XmlElement;

import org.lemonpzl.commons.domain.InMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationInMessage extends InMessage{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "Location_X")
	@JsonProperty("Location_X")
	private String location_X;

	@XmlElement(name = "Location_Y")
	@JsonProperty("Location_Y")
	private String location_Y;
	
	@XmlElement(name = "Scale")
	@JsonProperty("Scale")
	private String scale;
	
	
	@XmlElement(name = "Label")
	@JsonProperty("Label")
	private String lable;
	
	
	public LocationInMessage() {
		super.setMsgType("location");
	}


	public String getLocation_X() {
		return location_X;
	}


	public void setLocation_X(String location_X) {
		this.location_X = location_X;
	}


	public String getLocation_Y() {
		return location_Y;
	}


	public void setLocation_Y(String location_Y) {
		this.location_Y = location_Y;
	}


	public String getScale() {
		return scale;
	}


	public void setScale(String scale) {
		this.scale = scale;
	}


	public String getLable() {
		return lable;
	}


	public void setLable(String lable) {
		this.lable = lable;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "LocationInMessage [location_X=" + location_X + ", location_Y=" + location_Y + ", scale=" + scale
				+ ", lable=" + lable + ", getToUserName()=" + getToUserName() + ", getFromUserName()="
				+ getFromUserName() + ", getCreateTime()=" + getCreateTime() + ", getMsgType()=" + getMsgType()
				+ ", getMsgId()=" + getMsgId() + "]";
	}
	
	

}
