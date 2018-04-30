package com.skcc.snapshot.storeLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class RedisStoreLogic {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate; 
	
	
	
	public void set(String key, Object value) {

        redisTemplate.opsForValue().set(key, value);
    }
	
	public Object get(String key) {
		
        return redisTemplate.opsForValue().get(key);
    }
	
}
