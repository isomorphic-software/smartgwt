package com.smartgwt.client.widgets.layout.events;

public class NavigationClickEvent {

	private String direction;
	NavigationClickEvent(String direction) {
		this.setDirection(direction);
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getDirection() {
		return direction;
	}
	
	
}
