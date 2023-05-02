package com.example.service;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpService {

	private static final int Otp_Lenght=6;
	private static final long Otp_Ttl=300;
	
	@Autowired
    RedisService redisservice;
	
	
	public String GenerateOtp(String mobilenumber) {
		if(redisservice.hasValue(mobilenumber)) redisservice.deleteValue(mobilenumber);
		String key=mobilenumber;
		int randomNum=new Random().nextInt(1000000);
		String otp=String.format("%06d", randomNum);
		redisservice.setValue(mobilenumber, otp, Otp_Ttl);
		return otp;
	}
	
	public boolean validateOtp(String mobilenumber,String otp) {
		String storedOtp=redisservice.getvalue(mobilenumber);
		if(storedOtp!=null && otp.equals(storedOtp)) return true;
		
		return false;
	}
}
