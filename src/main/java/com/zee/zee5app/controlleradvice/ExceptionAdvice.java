package com.zee.zee5app.controlleradvice;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;

@ControllerAdvice
public class ExceptionAdvice {
	//this class is used when any user defined exception is called through all controllers
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> alreadyExistsExceptionHandler(AlreadyExistsException e){
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "record already exists"+e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> ExceptionHandler(Exception e){
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Unknown Exception" + e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> IdNotFoundExceptionHandler(IdNotFoundException e){
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "" + e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
}