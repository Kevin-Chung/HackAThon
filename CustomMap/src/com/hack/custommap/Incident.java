package com.hack.custommap;

public class Incident {

	public Incident(String type, String description, String location,
			String feedId, String googleHangout) {
		super();
		this.type = type;
		this.description = description;
		this.location = location;
		this.feedId = feedId;
		this.googleHangout = googleHangout;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFeedId() {
		return feedId;
	}
	public void setFeedId(String feedId) {
		this.feedId = feedId;
	}
	public String getGoogleHangout() {
		return googleHangout;
	}
	public void setGoogleHangout(String googleHangout) {
		this.googleHangout = googleHangout;
	}
	String type;
	String description;
	String location;
	String feedId;
	String googleHangout;
	
	
}
