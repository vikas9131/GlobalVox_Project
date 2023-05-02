package com.example.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

	
	@Autowired
	RedisTemplate<String, String> redisTemplate;
	
	
	public void setValue(String mobileNumber,String otp,long ttl)
	{
		redisTemplate.opsForValue().set(mobileNumber, otp, Duration.ofSeconds(ttl));
	}
	
	public String getvalue(String mobilenumber) {
		return redisTemplate.opsForValue().get(mobilenumber);
	}
	
	public void deleteValue(String mobileNumber) {
		redisTemplate.delete(mobileNumber);		
	}
	
	public boolean hasValue(String mobilenumber) {
		
		return redisTemplate.hasKey(mobilenumber);
	}
}
