package com.apex.jpa;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "order_items")
@SequenceGenerator(name = "order_items_sequence")
@SQLDelete(sql = "UPDATE order_items SET deleted = true WHERE order_item_id=?")
@Where(clause = "deleted=false")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "order_items")
	@Column(name = "order_item_id")
	private long id;
	
	@Column(name = "price")	
	private double price;
	
	@Column(name = "discount")
	private int discount;
	
	@Column(name = "quantity")
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", referencedColumnName = "order_id")
	@JsonIgnore
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	@JsonIgnore
	private Product product;

	@Column(name = "created")
	private Date created;

	@Column(name = "updated")
	private Date updated;

	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;


	public long getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public OrderItem setPrice(double price) {
		this.price = price;
		return this;
	}

	public int getDiscount() {
		return discount;
	}

	public OrderItem setDiscount(int discount) {
		this.discount = discount;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public OrderItem setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public Date getCreated() {
		return created;
	}

	
	public Date getUpdated() {
		return updated;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public OrderItem setDeleted(boolean deleted) {
		this.deleted = deleted;
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public OrderItem setOrder(Order order) {
		this.order = order;
		return this;
	}

	public Product getProduct() {
		return product;
	}

	public OrderItem setProduct(Product product) {
		this.product = product;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OrderItem orderItem = (OrderItem) o;
		return id == orderItem.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@PrePersist
	public void prePersist() {
		this.created = new Date(System.currentTimeMillis());
	}

	@PreUpdate
	public void postUpdate() {
		this.updated = new Date(System.currentTimeMillis());
	}
}
