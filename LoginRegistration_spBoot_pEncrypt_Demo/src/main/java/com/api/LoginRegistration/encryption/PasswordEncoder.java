package com.api.LoginRegistration.encryption;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public String encoder(String pass) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPass = encoder.encode(pass);
		return encodedPass;
		
	}
}
