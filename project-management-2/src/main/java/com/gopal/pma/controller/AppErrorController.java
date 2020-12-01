package com.gopal.pma.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppErrorController implements ErrorController{

	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		Integer errorCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(errorCode != null) {
			if(errorCode == HttpStatus.NOT_FOUND.value()) {
				return "errorpages/error-404";
			} else if(errorCode == HttpStatus.FORBIDDEN.value()) {
				return "errorpages/error-403";
			} else if (errorCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "errorpages/error-500";
			}
		}
		
		return "errorpages/error";
	}
	
	@Override
	public String getErrorPath() {
		return "error";
	}

}
