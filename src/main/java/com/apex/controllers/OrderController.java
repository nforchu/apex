package com.apex.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apex.jpa.Order;
import com.apex.services.OrderService;
import com.apex.util.MenuMap;

@Controller
@RequestMapping("order")
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
		model.addAttribute("orders", orders);
		model.addAttribute("menu", buildMenu());
		return "order-list";
	}
	
	private MenuMap buildMenu(){
        MenuMap menuMap = new MenuMap().setTitle("Products");
        for (Order.OrderStatus status : Order.OrderStatus.values()) {
        	menuMap.addPair(status.name(), String.format("/order/list/?status=%s", status.name()));
        }
        return menuMap;
   }

}
