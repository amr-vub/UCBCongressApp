package org.ucb.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.services.identification.IRegisteredUserService;

@RestController
public class Registercontroller {

	@Autowired
	private IRegisteredUserService iRegisteredUserService;
	
	@RequestMapping(value="/register",  method = RequestMethod.POST)
	public RegisteredHCP register(@RequestBody RegisteredHCP hcp){
		
		RegisteredHCP hcpReturn = 
				iRegisteredUserService.registerUser(hcp);
		
		return hcpReturn;
		
	}
}
