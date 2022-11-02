package com.apex.jpa;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "cart_items")
@SequenceGenerator(name = "cart_items_sequence")
@SQLDelete(sql = "UPDATE cart_items SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cart_items_sequence")
	@Column(name = "order_item_id")
	private long id;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "quantity")	
	private int quantity;

	@JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cart cart;		
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private Product product;

	@Column(name = "created")
	private Date created;

	@Column(name = "updated")
	private Date updated;

	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;

}
