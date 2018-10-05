package com.simple.TestDemoProject.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionOccure {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> getException(Exception e, HttpServletRequest request) throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
		exceptionResponse.setErrorMessage(e.getMessage());
		exceptionResponse.setErrorUrl(request.getRequestURI());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserReadyExitException.class)
	public ResponseEntity<ExceptionResponse> getCustomeException(UserReadyExitException urException,
			HttpServletRequest request) throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
		exceptionResponse.setErrorMessage(urException.getMessage());
		exceptionResponse.setErrorUrl(request.getRequestURI());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ExceptionResponse> getThrowable(Throwable t, HttpServletRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		exceptionResponse.setErrorMessage(t.getMessage());
		exceptionResponse.setErrorUrl(request.getRequestURI());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_GATEWAY);

	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> getUserExceptio(UserNotFoundException userException,HttpServletRequest request){
		ExceptionResponse exceptionResponse=new ExceptionResponse();
		exceptionResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
		exceptionResponse.setErrorMessage(userException.getMessage());
		exceptionResponse.setErrorUrl(request.getRequestURI());
		return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
		
	}
}
