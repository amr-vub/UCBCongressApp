package org.ucb.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ucb.service.model.AccessCode;
import org.ucb.services.identification.IAnonymousUser;

@RestController
public class CheckInController {

	@Autowired
	private IAnonymousUser iAnonymousUser;
	
	@RequestMapping(value="/checkIn", method= RequestMethod.POST)
	public AccessCode handlecheckIn(@RequestBody
									AccessCode accessCode){
		boolean tmp = iAnonymousUser.checkIn(Integer.valueOf(accessCode.getAccess_code()));
		AccessCode acc = new AccessCode();
		acc.setAccess_code(accessCode.getAccess_code());
		acc.setCheckin(tmp);
		return acc;
	
		
	} 
}
