package com.apex.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name="title")
	private String title;	
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private String status;
	
	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
		@JoinTable(name = "category_products",
		    joinColumns = @JoinColumn(name = "category_id"),
		    inverseJoinColumns = @JoinColumn(name = "product_id")
		)
	private Set<Product> products = new HashSet<>();
		
	public long getId() {
		return id;
	}

	public Category setId(long id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}
	
	public Category setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Category setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Category setStatus(String status) {
		this.status = status;
		return this;
	}
	
}
