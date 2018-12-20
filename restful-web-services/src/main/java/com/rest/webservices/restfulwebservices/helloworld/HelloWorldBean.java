package com.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
	
	private String message;
	
	public HelloWorldBean(String msg) {
		
		this.message = msg;
		
	}

	public void setMessage(String msg) {
		
		this.message = msg;
		
	}
	
	@Override
	public String toString() {
		
		return String.format("HellowWorldBean [message=%s]", message);
	}

	public String getMessage() {
		return message;
	}
	
}
