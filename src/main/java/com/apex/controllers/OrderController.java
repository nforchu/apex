package com.apex.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apex.jpa.Order;
import com.apex.services.OrderService;
import com.apex.util.MenuMap;

@Controller
@RequestMapping("console/order")
public class OrderController {
	
	private OrderService orderService;
	
	
	
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String get(Model model, @PathVariable long id) {
		Order order = orderService.findById(id);
		model.addAttribute("order", order)
			 .addAttribute("menu", buildMenu());
		return "order";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getOrders(Model model, @RequestParam(required = false) String status) {
		List<Order> orders = 
				status == null ?
				orderService.findAll() : 
				orderService.findByStatus(status);
		String title = String.format("%s ORDERS", status == null ? "ALL" : status);
		model.addAttribute("orders", orders)
			 .addAttribute("title", title)
			.addAttribute("menu", buildMenu());
		return "order-list";
	}
	
	@RequestMapping(value = "{id}/process", method = RequestMethod.GET)
	public String checkout(@PathVariable long id, @RequestParam String status){
		orderService.process(id, status);
		return String.format("redirect:/order/%s", id);
	}
	
	private MenuMap buildMenu(){
        MenuMap menuMap = new MenuMap()
        			.setTitle("Products")
        			.addPair("All", "/order/list");
        for (Order.OrderStatus status : Order.OrderStatus.values()) {
        	menuMap.addPair(status.name(), String.format("/order/list/?status=%s", status.name()));
        }
        return menuMap;
   }

}
