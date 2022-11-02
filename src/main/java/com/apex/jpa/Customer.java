package com.apex.jpa;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "customers")
@SequenceGenerator(name = "customers_sequence")
@SQLDelete(sql = "UPDATE customers SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "customers_sequence")
	@Column(name = "customer_id")
	private long id;
	
	@Column(name = "customer_name")
	private String name;
	
	@Column(name = "email")
	private String email;

	@Column(name = "created")
	private Date created;

	@Column(name = "updated")
	private Date updated;

	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> orders = new ArrayList<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Cart> carts = new ArrayList<>();


	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public void addOrder(Order order) {
		orders.add(order);
		order.setCustomer(this);
	}

	public void removeOrder(Order order) {
		orders.remove(order);
		order.setCustomer(null);
	}

	public void addCart(Cart cart) {
		carts.add(cart);
		cart.setCustomer(this);
	}

	public void removeCart(Cart cart) {
		carts.remove(cart);
		cart.setCustomer(null);
	}

}
