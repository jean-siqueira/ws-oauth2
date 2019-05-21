package com.jean.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jean.curso.repository.UserRepository;
import com.jean.curso.ws.domain.User;

@Service
public class UserService {

	@Autowired(required=true)
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
}
