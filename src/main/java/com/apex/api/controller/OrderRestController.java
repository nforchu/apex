package com.apex.api.controller;

import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apex.dto.CartItem;
import com.apex.jpa.Order;
import com.apex.services.OrderService;


@RestController
@RequestMapping("orders")
public class OrderRestController {
	
	private OrderService orderService;
	
	public OrderRestController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	
	@GetMapping("{id}")
	public ResponseEntity<?> get(@PathVariable long id, @RequestParam(required = false) String status) {		
		Order order = 
				status == null ? 
				orderService.findById(id) : 
				orderService.findByIdAndStatus(id, status);
		
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@PutMapping("{id}/add-item")
	public ResponseEntity<?> addItem(
				@PathVariable(name = "id") long orderId, 
				@RequestBody CartItem item) throws ParseException{
		Order order = orderService.addItem(orderId, item);
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@PutMapping("{id}/remove-item/{itemId}")
	public ResponseEntity<?> removeItem(@PathVariable long id, @PathVariable long itemId){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(orderService.removeItem(id, itemId));
	}
	
	
	@DeleteMapping("{id}/delete-item/{itemId}")
	public ResponseEntity<?> deleteItem(@PathVariable long id, @PathVariable long itemId){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(orderService.deleteItem(id, itemId));
	}
	
	@PutMapping("{id}/checkout")
	public ResponseEntity<?> checkout(@PathVariable long id){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(orderService.confirmCheckout(id));
	}
	
	@PutMapping("{id}/cancel")
	public ResponseEntity<?> cancel(@PathVariable long id){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(orderService.process(id, Order.OrderStatus.CANCELED.name()));
	}
	
}
