package br.com.hvc.control.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hvc.control.entities.User;
import br.com.hvc.control.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User user) {
		User userAffected = repository.getOne(id);
		updateData(userAffected, user);
		return repository.save(userAffected);
	}

	private void updateData(User userAffected, User user) {
		userAffected.setName(user.getName());
		userAffected.setEmail(user.getEmail());
		userAffected.setPhone(user.getPhone());
	}
}
