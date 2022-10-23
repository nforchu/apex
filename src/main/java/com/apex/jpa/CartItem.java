package com.apex.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "quantity")	
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cart cart;		
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;

}
