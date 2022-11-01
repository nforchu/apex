package com.apex.jpa;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categories")
@SequenceGenerator(name = "categories_sequence")
@SQLDelete(sql = "UPDATE categories SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Category {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "categories_sequence" )
	@Column(name = "id")
	private long id;
	
	@Column(name="title")
	private String title;	
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "created")
	private Date created;
	
	@Column(name = "updated")
	private Date updated;
	
	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;
	
	
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
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
		Category other = (Category) obj;
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
