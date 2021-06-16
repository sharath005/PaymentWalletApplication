package com.trg.boot.exceptionhandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.trg.boot.exceptions.InvalidUserInputException;

@ControllerAdvice
public class UserInputExceptionHandler {
	
	@ExceptionHandler(InvalidUserInputException.class)
	public ResponseEntity<?> WrongInputByUser(InvalidUserInputException ie){
		Map<String,Object> error = new LinkedHashMap<>();
		error.put("errror occured","Not a valid input by user");
		error.put("message", ie.getMessage());
		error.put("Time stamp: ",LocalDate.now());
		return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
	}
}