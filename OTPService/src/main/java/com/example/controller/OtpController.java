package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.OtpService;

@RestController
public class OtpController {

	
	@Autowired
	OtpService otpservice;
	
	@PostMapping("/otp")
	public String generateOtp(@RequestParam  String mobilenumber){
		
		String otp=otpservice.GenerateOtp(mobilenumber);
		System.out.println(otp);
		return otp;
	}
	@PostMapping("/otp/validate")
	public String VaalidateOtp(@RequestParam String mobilenumber,@RequestParam String otp)
	{
		System.out.println("AAYA HU ANDAR ISKE");
		
		if(otpservice.validateOtp(mobilenumber, otp))
		{
			return "OTP MATCHED SUCCESSFULLY";
		}
		return "OTP NOT MATCHED !!!";
	}
}
