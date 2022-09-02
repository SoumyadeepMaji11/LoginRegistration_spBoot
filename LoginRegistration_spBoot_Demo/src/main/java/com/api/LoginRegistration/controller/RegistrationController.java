package com.api.LoginRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.LoginRegistration.entity.User;
import com.api.LoginRegistration.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;
	
	@PostMapping("/registeruser")
	public boolean registerUser(@RequestBody User user){
		User userObj = null;
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			userObj = registrationService.fetchUserByEmailId(tempEmailId);
			if(userObj != null) {
				return false;
			}
		}else {
			return false;
		}
		userObj = registrationService.saveUser(user);
		return true;
	}
	
	
	@PostMapping("/loginuser")
	public boolean loginUser(@RequestBody User user) {
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword(); 
		User userObj = null ;
		if(tempEmailId != null && tempPassword != null) {
			userObj = registrationService.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		if(userObj == null) {
			return false;
		}
		return true;
	}
}
