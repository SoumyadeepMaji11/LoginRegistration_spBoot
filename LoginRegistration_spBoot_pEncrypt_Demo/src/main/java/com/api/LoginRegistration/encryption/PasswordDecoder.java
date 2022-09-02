package com.api.LoginRegistration.encryption;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordDecoder {

	public boolean dectyption(String password, String encodedPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(password, encodedPassword);
	}

}
