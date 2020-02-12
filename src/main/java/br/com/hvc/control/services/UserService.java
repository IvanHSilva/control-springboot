package br.com.hvc.control.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.hvc.control.entities.User;
import br.com.hvc.control.repositories.UserRepository;
import br.com.hvc.control.services.exceptions.DatabaseException;
import br.com.hvc.control.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user) {
		return repository.save(user);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User user) {
		try {
			User userAffected = repository.getOne(id);
			updateData(userAffected, user);
			return repository.save(userAffected);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User userAffected, User user) {
		userAffected.setName(user.getName());
		userAffected.setEmail(user.getEmail());
		userAffected.setPhone(user.getPhone());
	}
}
