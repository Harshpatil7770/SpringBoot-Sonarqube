package com.cls.ccurrencyonversion.exception;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementNotFoundException extends RuntimeException {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String errorMsg;

	private String errorCode;

}
