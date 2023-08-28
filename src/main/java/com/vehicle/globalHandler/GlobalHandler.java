package com.vehicle.globalHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vehicle.exception.BrandNotFoundException;
import com.vehicle.exception.IdNotFoundException;
import com.vehicle.exception.InvalidBoardException;

@RestControllerAdvice
public class GlobalHandler {
	@ExceptionHandler(BrandNotFoundException.class)
	public ResponseEntity<Object> brandHandler() {
		return new ResponseEntity<>("Invalid data",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidBoardException.class)
	public ResponseEntity<Object> invalidBoard() {
		return new ResponseEntity<>("Invalid data",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> idNot(){
		return 	new ResponseEntity<Object>("Id Not Found",HttpStatus.BAD_REQUEST);
	}
	

}
