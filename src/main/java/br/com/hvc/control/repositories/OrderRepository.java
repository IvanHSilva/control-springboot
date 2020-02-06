package br.com.hvc.control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hvc.control.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
