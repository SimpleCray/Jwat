package com.jwat.hellospringboot.entity;

public class JsonResponse {
	private String userNameError;
	private String emailError;
	private String otherError;
	private String successMessage;
	
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getUserNameError() {
		return userNameError;
	}
	public void setUserNameError(String userNameError) {
		this.userNameError = userNameError;
	}
	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}
	public String getOtherError() {
		return otherError;
	}
	public void setOtherError(String otherError) {
		this.otherError = otherError;
	}
}
