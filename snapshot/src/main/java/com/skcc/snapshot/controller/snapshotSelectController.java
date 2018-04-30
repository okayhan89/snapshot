package com.skcc.snapshot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
@RequestMapping(value = "/api/v1/snapshot")
public class snapshotSelectController {

	private static final Logger logger = LoggerFactory.getLogger(RedisServiceController.class.getName());

	@Autowired
	private RedisServiceLogic redisServiceLogic;

	@Autowired
	private RedisClient redisClient;

	@SuppressWarnings("unchecked")
	@RequestMapping("/result")
	public Map<String, Object> main2(HttpServletRequest request,
			HttpServletResponse response/* , @PathVariable String ver */
	/* ,@RequestHeader(value="auth") String auth */ ) {

		/*현재 snapshot_result 관련해서는 안됨 이상하게 json 보냄 수정 요청 해야함.*/
//		String key = "snapshot_result";
		String key = "snapshot_request_low";
		List result = new ArrayList<>();
		result = redisClient.lrange(key, 0, -1);

		System.out.println("0" + result.get(0));
		System.out.println("1" + result.get(1));

		String val = (String) result.get(1);

		System.out.println("val is " + val);

		
		/* 혹시 json 이상하게 된다면 string 으로 주어야 할 수 도 잇음 */
		//val = val.replaceAll("\\\\", "");
		// val = val.replaceAll(",", ", \"+\"");
		// System.out.println("val is "+val);

		// val = val.replaceAll("\":", "\":\"+\"");
		// val = val.replaceAll("files\\\\\":", "files\\\\\":\"+\"");
		// System.out.println("val is "+val);


		JSONParser jsonParser = new JSONParser();
		
		JSONObject jsonObj = null;
		try {
			jsonObj = (JSONObject) jsonParser.parse(val);
			
			System.out.println("efef" + jsonObj);
			System.out.println("123");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObj;
	}
}
