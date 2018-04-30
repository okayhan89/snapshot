package com.skcc.snapshot.controller;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.snapshot.domain.logic.RedisServiceLogic;
import com.skcc.snapshot.dto.SnapshotDto;
import com.skcc.snapshot.redis.RedisClient;

@RestController
@RequestMapping(value= "/api/v1/snapshot")
public class snapshotCreateController {

	private static final Logger logger = LoggerFactory.getLogger(RedisServiceController.class.getName());
	
	@Autowired
	private RedisServiceLogic redisServiceLogic;
	
	@Autowired
	private RedisClient redisClient;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/generate")
	public Map<String, Object> main1(HttpServletRequest request, HttpServletResponse response/*, @PathVariable String ver*/
			,@RequestHeader(value="auth") String auth)  {
		

		System.out.println("header auth is "+auth);
//		Base64.getDecoder().decode(auth.getBytes());
		
		
//		String originalString = new String(Base64.getDecoder().decode(auth.getBytes()));
//		System.out.println("or is "+originalString);
//		
//		Date d = new Date();
//		SimpleDateFormat date =new SimpleDateFormat("yyyy-MM-dd");
//		String token = date.format(d);
//		byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
//
//		String originalString1 = new String(Base64.getDecoder().decode(encodedBytes));
//
//		System.out.println("decode is " + originalString1);
//		
//		
		
		String key = "snapshot_request_low";
		JSONObject result = new JSONObject();
		result.put("titleMax", request.getParameter("titleMax"));
		result.put("productNo", request.getParameter("productNo"));
		result.put("loadTimeout", request.getParameter("loadTimeout"));
		result.put("tileHeight", request.getParameter("tileHeight"));
		result.put("url", request.getParameter("url"));
		result.put("format", request.getParameter("format"));
		result.put("prefix", request.getParameter("prefix"));
		result.put("imgLoc", request.getParameter("imgLoc"));
		result.put("quality", request.getParameter("quality"));
		
		redisClient.rpush(key, result.toJSONString());
		
		return result;
	}
}
