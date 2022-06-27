package com.xoriant.settlement.validation;

//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//@ControllerAdvice
//public class ValidationHandeler extends ResponseEntityExceptionHandler {
//
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//		Map<String, String> map = new HashMap<String, String>();
//		ex.getBindingResult().getAllErrors().forEach((e) -> {
//			String filedName = e.getDefaultMessage();
//			String message = e.getDefaultMessage();
//			map.put(filedName, message);
//		});
//
//		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
//	}
//}
