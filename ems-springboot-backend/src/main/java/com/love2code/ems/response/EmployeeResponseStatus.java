package com.love2code.ems.response;

public class EmployeeResponseStatus {
	
	private String responseMessage;
	
	public EmployeeResponseStatus() {
	}

	public EmployeeResponseStatus(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	

}
