/**
 *  Class used to encapsulate exceptions
 */
package com.isslabs.education.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * @author Mab-Wilcox
 *
 */
public class ApiError implements Serializable {
	
	/**
	 *  TODO - Implement lombok, verify if needed
	 */
	private static final long serialVersionUID = -84504625086778937L;
	
	private HttpStatus status;
	private String message;
	private List<String> errors;
	
	public ApiError(HttpStatus status, String message, List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}
	
	public ApiError(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ApiError [status=" + status + ", message=" + message + ", errors=" + errors + "]";
	}
	
}
