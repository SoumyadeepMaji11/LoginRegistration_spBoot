package com.api.LoginRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.LoginRegistration.encryption.PasswordDecoder;
import com.api.LoginRegistration.encryption.PasswordEncoder;
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
		PasswordEncoder pe = new PasswordEncoder();
		String enPass = pe.encoder(user.getPassword()); //Encrypting the password
		user.setPassword(enPass);
		registrationService.saveUser(user);
		return true;
	}
	
	
	@PostMapping("/loginuser")
	public boolean loginUser(@RequestBody User user) {
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword(); 
		String enPass = registrationService.fetchPassByEmail(tempEmailId);
		PasswordDecoder pd = new PasswordDecoder();
		boolean check = pd.dectyption(tempPassword, enPass); //Decrypting the password
		if(check == false) {
			return false;
		}
		return true;
	}
}
