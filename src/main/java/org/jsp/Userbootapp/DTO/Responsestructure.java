package org.jsp.Userbootapp.DTO;

public class Responsestructure <T> {
	
	private String message;
	private int code;
	private T body;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
	
	
	

}
