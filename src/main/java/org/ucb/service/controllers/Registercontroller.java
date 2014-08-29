package org.ucb.service.controllers;

import java.util.Date;

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
	public void register(@RequestBody RegisteredHCP hcp){
		
		System.out.print("33333333333333");
		
		RegisteredHCP hcp1 = new RegisteredHCP();
		
		hcp1.setAcademic_practitioner_value(hcp.getAcademic_practitioner_value());
		hcp1.setCountry(hcp.getCountry());
		hcp1.setEmail(hcp.getEmail());
		hcp1.setHCPName(hcp.getHCPName());
		hcp1.setRegisteredAt(new Date());
		
		RegisteredHCP hcpReturn = 
				iRegisteredUserService.registerUser(hcp);
		
		//return hcpReturn;
		
	}
}
