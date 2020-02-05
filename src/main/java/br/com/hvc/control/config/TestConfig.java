package br.com.hvc.control.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.hvc.control.entities.User;
import br.com.hvc.control.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria José", "maria@gmail.com", "91234-5678", "00000");
		User u2 = new User(null, "José Antonio", "jose@gmail.com", "98765-4321", "111111");
		User u3 = new User(null, "Yuri Sakamoto", "yuri@gmail.com", "90011-2233", "22222");
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}
}
