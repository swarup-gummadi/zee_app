package com.zee.zee5app.controlleradvice;

//import java.net.http.HttpHeaders;
import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.apierror.ApiError;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {
	//this class is used when any user defined exception is called through all controllers
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> alreadyExistsExceptionHandler(AlreadyExistsException e){
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "record already exists"+e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> ExceptionHandler(Exception e){
//		HashMap<String, String> map = new HashMap<>();
//		map.put("message", "Unknown Exception" + e.getMessage());
//		return ResponseEntity.badRequest().body(map);
//	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> IdNotFoundExceptionHandler(IdNotFoundException e){
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "" + e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage("Validation error");
		apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
		apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
		return buildResponseEntity(apiError);
	}
	
	
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError){
		//to get RE object -> ease of maintenance for existing object changes
		return new ResponseEntity<>(apiError, apiError.getHttpStatus());
	}
}