package br.com.hvc.control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hvc.control.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
