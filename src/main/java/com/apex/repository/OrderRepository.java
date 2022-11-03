package com.apex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apex.jpa.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	Optional<Order> findByIdAndStatus(long id, Order.OrderStatus status);
	List<Order> findByStatus(Order.OrderStatus status);

}
