package com.jean.curso.ws.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.jean.curso.ws.domain.User;
import com.jean.curso.ws.repository.UserRepository;

@Configuration
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		userRepository.deleteAll();
		
		User joao = new User("João", "Souza", "joao@gmail.com"); 
		User maria = new User("Maria", "Teixeira", "maria@gmail.com");
		
		createUserIfNotFound(joao);
		createUserIfNotFound(maria);
		
	}
	
	private User createUserIfNotFound(User user) {
		Optional<User> obj = userRepository.findByEmail(user.getEmail());
		
		if(obj.isPresent()) {
			return obj.get();
		}
		
		return userRepository.save(user);
		
	}

}
