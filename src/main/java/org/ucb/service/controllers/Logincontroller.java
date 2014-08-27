package org.ucb.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ucb.service.model.LoginInfo;
import org.ucb.services.identification.IRegisteredUserService;

@RestController
public class Logincontroller {

	@Autowired
	IRegisteredUserService iRegisteredUserService;
	
	@RequestMapping(value="/logIn" , method = RequestMethod.POST)
	public LoginInfo checkLogin(@RequestBody LoginInfo login){
		
		LoginInfo info;
		
		// Here we should call the logging in service 
		info = iRegisteredUserService.login(login);
		
		return info;
	}
	
}
