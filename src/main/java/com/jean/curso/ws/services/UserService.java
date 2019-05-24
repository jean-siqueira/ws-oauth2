package com.jean.curso.ws.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jean.curso.ws.domain.User;
import com.jean.curso.ws.dto.UserDTO;
import com.jean.curso.ws.repository.UserRepository;
import com.jean.curso.ws.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User create(User user) {
		return userRepository.save(user);
	}
	
	public User fromDto(UserDTO userDTO) {
		return new User(userDTO);
	}
	
	public User update(User user) {
		 Optional<User> updateUser = userRepository.findById(user.getId());
		 return updateUser.map( u -> userRepository.save(new User(u.getId(), user.getFirstName(), user.getLastName(), user.getEmail())))
				 .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
	}
	
	public void delete(String id) {
		userRepository.deleteById(id);
	}
	
}
