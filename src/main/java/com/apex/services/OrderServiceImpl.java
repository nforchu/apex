package com.apex.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apex.dto.CartItem;
import com.apex.jpa.Customer;
import com.apex.jpa.Order;
import com.apex.jpa.Order.OrderStatus;
import com.apex.jpa.OrderItem;
import com.apex.jpa.Product;
import com.apex.repository.CustemerRepository;
import com.apex.repository.OrderRepository;
import com.apex.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	OrderRepository orderRepo;
	ProductRepository productRepo;
	CustemerRepository customerRepo;

	public OrderServiceImpl(OrderRepository orderRepo, ProductRepository productRepo, CustemerRepository customerRepo) {
		super();
		this.orderRepo = orderRepo;
		this.productRepo = productRepo;
		this.customerRepo = customerRepo;
	}
	
	@Override
	public Order findById(long orderId) {
		Order order = orderRepo.findById(orderId).orElseThrow();
		return order;
	}


	@Override
	public Order findByIdAndStatus(long orderId, String status) {
		Order order = orderRepo.findByIdAndStatus(orderId, Order.OrderStatus.valueOf(status))
							   .orElseThrow();
		return order;
	}
	
	public List<Order> findAll() {		
		return orderRepo.findAll();
	}
	
	@Override
	public List<Order> findByStatus(String status) {		
		return orderRepo.findByStatus(Order.OrderStatus.valueOf(status));
	}
	

	@Override
	public Order addItem(long orderId, CartItem cartItem) {
		Order order;
		if (orderId > 0) {
			order = orderRepo.findById(orderId).orElseThrow();
		} else {
			order = new Order().setStatus(Order.OrderStatus.OPEN);
			Customer customer = customerRepo.findById(cartItem.getCustomerId()).orElseThrow();
			order.setCustomer(customer)
				 .setOrderNumber(String.format("APX-%s", Math.random()));
			customer.addOrder(order);
		}		
		Product product = productRepo.findById(cartItem.getProductId()).orElseThrow();			
		OrderItem orderItem = order.getItems().stream()
				.filter(item -> item.getOrder().getId() == orderId && item.getProduct().getId() == product.getId())
				.reduce((a, b) -> {
		            throw new IllegalStateException("Duplicate product in order: " + a + ", " + b);
		        })
				.orElse(null);
		if (orderItem == null) {
			
			orderItem = new OrderItem()
					.setOrder(order)
					.setPrice(product.getPrice())	
					.setProduct(product)
					.setDiscount(product.getDiscountPercent())
					.setQuantity(1);		
		} else if(orderItem.getProduct().getId() == cartItem.getProductId()) {
			orderItem.setQuantity(orderItem.getQuantity() + 1);
		} 
		
		product.addOrderItem(orderItem);
		orderItem.setProduct(product);
		if(!order.getStatus().equals(Order.OrderStatus.OPEN)) {
			order.setStatus(Order.OrderStatus.OPEN);
		}
		return orderRepo.saveAndFlush(order);
	}

	@Override
	public boolean removeItem(long orderId, long itemId) {
		Order order = orderRepo.findById(orderId).orElseThrow();
		order.getItems().stream().forEach(item -> {
			if(item.getId() == itemId) {
				if (item.getQuantity() > 1) {
					item.setQuantity(item.getQuantity() - 1);
				} else {
					item.setDeleted(true);
				}
			}
		});
		if(!order.getStatus().equals(Order.OrderStatus.OPEN)) {
			order.setStatus(Order.OrderStatus.OPEN);
		}
		orderRepo.save(order);
		return true;
	}
	
	@Override
	public boolean deleteItem(long orderId, long itemId) {
		Order order = orderRepo.findById(orderId).orElseThrow();
		order.getItems().stream().forEach(item -> {
			if(item.getId() == itemId) {
				item.setDeleted(true);
			}
		});
		if(!order.getStatus().equals(Order.OrderStatus.OPEN)) {
			order.setStatus(Order.OrderStatus.OPEN);
		}
		orderRepo.save(order);
		return true;
	}

	@Override
	public Order confirmCheckout(long orderId) {
		Order order = orderRepo.findById(orderId).orElseThrow();
		order.setStatus(Order.OrderStatus.CONFIRMED);
		return orderRepo.save(order);
	}

}
