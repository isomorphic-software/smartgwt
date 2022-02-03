package com.smartgwt.sample.showcase.client.basics.interaction;

/**
 * Simple configuration object for a native HTML button.
 */
public class NativeButtonConfig {
	
	private String title;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	NativeButtonConfig(String title) {
		this.setTitle(title);
	}

}
