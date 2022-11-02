package com.apex.services;

import java.util.List;

import com.apex.dto.CartItem;
import com.apex.jpa.Order;


public interface OrderService {
	
	Order findById(long orderId);
	Order findByIdAndStatus(long orderId, String status);
	List<Order> findAll();
	List<Order> findByStatus(String status);
	Order addItem(long orderId, CartItem item);
	boolean deleteItem(long orderId, long itemId);
	boolean removeItem(long orderId, long itemId);
	Order confirmCheckout(long orderId);

}
