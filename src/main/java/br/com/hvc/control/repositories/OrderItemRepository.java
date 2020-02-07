package br.com.hvc.control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hvc.control.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
