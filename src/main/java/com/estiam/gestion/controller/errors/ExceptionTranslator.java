package com.estiam.gestion.controller.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estiam.gestion.controller.errors.domain.MontantException;

@ControllerAdvice
public class ExceptionTranslator {
	
	@ExceptionHandler(value = MontantException.class)
	public ResponseEntity<Exception> handleIllegalArgumentException(MontantException montantException){
			return new ResponseEntity<Exception>(new Exception(montantException.getMessage()), HttpStatus.NOT_ACCEPTABLE);
	}

}
