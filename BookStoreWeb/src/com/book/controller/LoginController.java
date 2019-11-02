package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoredb.bean.to.LoginRequestTO;
import com.bookstoredb.bean.to.LoginResponseTO;
import com.bookstoredb.service.impl.UserServiceImpl;


@RestController
public class LoginController {
	
	
	@Autowired
	UserServiceImpl usesrvice;
	
	@RequestMapping(value= "/login", method = RequestMethod.POST  )
	@ResponseBody
	public LoginResponseTO login(@RequestBody LoginRequestTO loginRequest){
	//public LoginResponseTO login(){
		
		//LoginRequestTO loginRequest = new LoginRequestTO();
		//loginRequest.setUserName("khassan");
		System.out.println("login ...");
		LoginResponseTO loginResponseTO = usesrvice.login(loginRequest);
		
		return loginResponseTO;
	}

}
