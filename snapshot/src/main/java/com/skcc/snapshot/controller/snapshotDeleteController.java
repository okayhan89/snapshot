package com.skcc.snapshot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class snapshotDeleteController {

	private static final Logger logger = LoggerFactory.getLogger(RedisServiceController.class.getName());
	
	@Autowired
	private RedisServiceLogic redisServiceLogic;
	
	@Autowired
	private RedisClient redisClient;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	public String main3(HttpServletRequest request, HttpServletResponse response/*, @PathVariable String ver*/
			/*,@RequestHeader(value="test") String test*/)  {
		
		
		String key = "snapshot_request_low";
		
		List k =new ArrayList<>(); 
		k=		redisClient.lrange(key, 0, -1);
		System.out.println("abced" + k.toString());
		
//		JSONObject result = new JSONObject();
		
		
		k.get(0);
		System.out.println(k.get(0));
		System.out.println();
		
//		result = (JSONObject) k.get(0);
		
//		redisClient.rpush(key, result.toJSONString());
		return k.get(0).toString();
	}
}
