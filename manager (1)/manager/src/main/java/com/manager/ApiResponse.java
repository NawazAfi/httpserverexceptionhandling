package com.manager;

    


public class ApiResponse<T> {

    private T data;
    private String message;
    private boolean valid;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public ApiResponse(T data, String message, boolean valid) {
		super();
		this.data = data;
		this.message = message;
		this.valid = valid;
	}
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
    
	
    
    
    

