package org.ucb.service.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ucb.data.domain.Login;

@RestController
public class Logincontroller {

	@RequestMapping(value="/logIn" , method = RequestMethod.POST)
	public Login checkLogin(@RequestBody Login login){
		
		// Here we should call the logging in service 
		
		return login;
	}
	
}
