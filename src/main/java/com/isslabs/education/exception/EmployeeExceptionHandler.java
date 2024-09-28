/**
 *  Custom Global Exception Handler
 */
package com.isslabs.education.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.isslabs.education.model.ApiError;

/**
 * @author Mab-Wilcox
 *
 */

@ControllerAdvice
public class EmployeeExceptionHandler {

	/**
	 * TODO - Handle 400 Errors
	 **/

	// Status 500 Errors
	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleErrors(final Exception ex, final WebRequest request) {
		
		final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "Error on Employee Service");
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}	
}
