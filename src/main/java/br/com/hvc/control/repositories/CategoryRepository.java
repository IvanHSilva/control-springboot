package br.com.hvc.control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hvc.control.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
