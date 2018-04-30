package com.skcc.snapshot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.snapshot.domain.logic.RedisServiceLogic;
import com.skcc.snapshot.dto.SnapshotDto;
import com.skcc.snapshot.redis.RedisClient;



@RestController
@RequestMapping(value= "/v1")
public class RedisServiceController{

	private static final Logger logger = LoggerFactory.getLogger(RedisServiceController.class.getName());
	
	@Autowired
	private RedisServiceLogic redisServiceLogic;
	
	@Autowired
	private RedisClient redisClient;
	
	@RequestMapping("/redis")
	public Map<String, Object> main(HttpServletRequest request, HttpServletResponse response/*, @PathVariable String ver*/)  {
		
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> node = new HashMap<String, Object>();
		redisServiceLogic.set("test", System.currentTimeMillis()+"");
		logger.debug(""+redisServiceLogic.get("test"));
		
		logger.info("hello");
		
		SnapshotDto snapshot = new SnapshotDto(0, 136310925, 10, 1000, "http://soffice.11st.co.kr/jsp/product/information/sellProductDesc4HtmltoImg.jsp?type=html2img&prdNo=1732496840", 
				"jpg", "/home/mrbluesky/data3/sn/sn6/p/6/3/1/0/9/2/5/1732496838", "6", 60);
		
	
		String key = "snapshot_request_low";
		
		result.put("titleMax", 0);
		result.put("productNo", 136310925);
		result.put("loadTimeout", 10);
		result.put("tileHeight", 1000);
		result.put("url", "http://soffice.11st.co.kr/jsp/product/information/sellProductDesc4HtmltoImg.jsp?type=html2img&prdNo=1732496838");
		result.put("format", "jpg");
		result.put("prefix", "/home/mrbluesky/data3/sn/sn6/p/6/3/1/0/9/2/5/1732496838");
		result.put("imgLoc", "6");
		result.put("quality", 60);

		
		JSONObject a = new JSONObject();
		
			a.put("titleMax", 0);
			a.put("productNo", 136310925);
			a.put("loadTimeout", 10);
			a.put("tileHeight", 1000);
			a.put("url", "http://soffice.11st.co.kr/jsp/product/information/sellProductDesc4HtmltoImg.jsp?type=html2img&prdNo=1732496838");
			a.put("format", "jpg");
			a.put("prefix", "/home/mrbluesky/data3/sn/sn6/p/6/3/1/0/9/2/5/1732496838");
			a.put("imgLoc", "6");
			a.put("quality", 60);
		
		
		
		System.out.println("aaaaaeeaaa"+a);
		
		System.out.println("aaa" + result);
		System.out.println("abc" + result.toString());
		
		
		redisClient.rpush(key, a.toJSONString());
		
		//redisClient.rpush(key, result.toString());
//		redisClient.rpush(key, result.toString());
		
		System.out.println("012345678901234");
//		System.out.println("snapshot is "+ snapshot);
//		System.out.println("ttttt" + snapshot.toString());
		//redisClient.rpush(key, snapshot);
		
		
		
		return result;
	}
}