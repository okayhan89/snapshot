package com.skcc.snapshot.domain.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skcc.snapshot.storeLogic.RedisStoreLogic;

@Service
public class RedisServiceLogic {

	
	@Autowired
	private RedisStoreLogic redisStoreLogic; 
	
	public void set(String key, Object value) {
		redisStoreLogic.set(key, value);
    }
	
	public Object get(String key) {
		Object result = redisStoreLogic.get(key);
        return result;
    }
}