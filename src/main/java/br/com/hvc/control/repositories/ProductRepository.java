package br.com.hvc.control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hvc.control.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
