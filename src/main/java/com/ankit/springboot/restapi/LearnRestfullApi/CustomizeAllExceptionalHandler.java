package com.ankit.springboot.restapi.LearnRestfullApi;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizeAllExceptionalHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleExceptions(Exception ex, WebRequest request) throws Exception{
		ErrorDetails error =new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(error,HttpStatus.INTERNAL_SERVER_ERROR);
				
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		BindingResult br=ex.getBindingResult();
		StringBuffer err=new StringBuffer();
		if(br.hasErrors()) {
			for(ObjectError oe:br.getAllErrors()) {
				err.append(oe.getDefaultMessage().toString()+" || ");
			}
			err.append("Number of Errors :"+br.getErrorCount());
		}
		
		ErrorDetails error=new ErrorDetails(LocalDate.now(), err.toString(),request.getDescription(false));
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
		
	}
	
	
}
