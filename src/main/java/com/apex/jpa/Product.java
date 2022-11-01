package com.apex.jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "products")
@SequenceGenerator(name = "products_sequence")
@SQLDelete(sql = "UPDATE products SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "products_sequence")
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
    private double price;
	
	@Column(name = "created")
	private Date created;
	
	@Column(name = "updated")
	private Date updated;
	
	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;
	
	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE,
		    CascadeType.REFRESH
		})
		@JoinTable(name = "product_categories",
		    joinColumns = @JoinColumn(name = "product_id"),
		    inverseJoinColumns = @JoinColumn(name = "category_id")
		)
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

	public double getPrice() {
		return price;
	}

	public Product setPrice(double price) {
		this.price = price;
		return this;
	}	
	
	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public void addCategory(Category category) {
		categories.add(category);
		category.getProducts().add(this);
    }
 
    public void removeCategory(Category category) {
    	categories.remove(category);
        category.getProducts().remove(this);
        
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

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return id == other.id;
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
