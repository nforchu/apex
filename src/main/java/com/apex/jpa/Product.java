package com.apex.jpa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name = "title")
    private String title;
	
	@Column(name = "description")
    private String description;
	
	@Column(name = "quantity")
    private int stockQuantity;
	
	@Column(name = "discount")
    private int discountPercent;
	
	@Column(name = "price")
    private float price;
	
	@ManyToMany(mappedBy = "products")
	private Set<Category> categories = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "product_id")
	private List<OrderItem> orderItems = new ArrayList<>();

    public long getId() {
        return id;
    }

    public Product setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Product setTitle(String title) {
        this.title = title;
        return this;
    }

	public String getDescription() {
		return description;
	}

	public Product setDescription(String description) {
		this.description = description;
		return this;
	}

	

	public int getStockQuantity() {
		return stockQuantity;
	}

	public Product setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
		return this;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public Product setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
		return this;
	}

	public float getPrice() {
		return price;
	}

	public Product setPrice(float price) {
		this.price = price;
		return this;
	}
    
}
