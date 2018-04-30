package com.skcc.snapshot.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping(value = "/v1")
public class RestServiceController {

	@RequestMapping("/test")
	public  Map<String, Object> aaa(HttpServletRequest request, HttpServletResponse respons){
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		
		String api_if = request.getParameter("if");
		String ver = request.getParameter("ver");
		String ui_name = request.getParameter("ui_name");

		result.put("if", api_if);
		result.put("ver", ver);
		result.put("ui_name", ui_name);

		return result;
	}
	
	// GET
		@RequestMapping(value = "/rest")
		public Map<String, Object> abc(HttpServletRequest request,
			HttpServletResponse response/* , @PathVariable String ver */) {
			
			Map<String, Object> result = new LinkedHashMap<String, Object>();

//			String api_if = request.getParameter("if");
//			String ver = request.getParameter("ver");
//			String ui_name = request.getParameter("ui_name");

				System.out.println("abc");
				result.put("a", "value");
				System.out.println("abc2");
//			result.put("if", 1);
//			result.put("ver", 2);
//			result.put("ui_name", 3);

			return result;
		}
		
		
		@RequestMapping(value = "/key")
		public Map<String, Object> test2(HttpServletRequest request,
			HttpServletResponse response, @RequestHeader(value="Accept") String accept) {
			
			Map<String, Object> result = new LinkedHashMap<String, Object>();

			System.out.println(accept);
			//String api_key = request.getParameter(accept);
			
//			String api_if = request.getParameter("if");
//			String ver = request.getParameter("ver");
//			String ui_name = request.getParameter("ui_name");

				System.out.println("abc");
				result.put("a", "value");
				System.out.println("abc2");
//			result.put("if", 1);
//			result.put("ver", 2);
//			result.put("ui_name", 3);

			return result;
		}
}
