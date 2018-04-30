package com.skcc.snapshot.controller;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/snapshot")
public class snapshotTokenController {

	private static final Logger logger = LoggerFactory.getLogger(RedisServiceController.class.getName());


	@SuppressWarnings("unchecked")
	@RequestMapping("/token")
	public Map<String, Object> main2(HttpServletRequest request,
			HttpServletResponse response/* , @PathVariable String ver */
	/* ,@RequestHeader(value="auth") String auth */ ) {


		Date d = new Date();
		SimpleDateFormat date =new SimpleDateFormat("yyyy-MM-dd");
		String token = date.format(d);
		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());

		String originalString = new String(Base64.getDecoder().decode(encodedBytes));

		System.out.println("decode is " + originalString);

		JSONObject api_key = new JSONObject();
		api_key.put("auth", encodedBytes);
		
		
		
		System.out.println("token "+ token);
		System.out.println("auth " + encodedBytes);
		
		
		System.out.println(api_key.toJSONString());
		
		return api_key;
	}
}
