package com.api.LoginRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.LoginRegistration.entity.User;

public interface RegistrationRepository extends JpaRepository<User,Integer> {

	public User findByEmailId(String email);
	
	public User findByEmailIdAndPassword(String email, String Password);
}
