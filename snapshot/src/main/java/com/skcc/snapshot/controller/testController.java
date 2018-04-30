package com.skcc.snapshot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

	private static final Logger logger = LoggerFactory.getLogger(RedisServiceController.class.getName());
	
	@RequestMapping("/test")
	public String abcd(){
		
		logger.info("hello");
		logger.info("testController");
		return "hello rest api page";
	}
}
