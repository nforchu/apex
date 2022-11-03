package com.apex.jpa;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "users_sequence")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE user_id=?")
@Where(clause = "deleted=false")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "users_sequence" )
	@Column(name = "user_id")
	private long id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="email", nullable = false)
	private String email;	
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private ActiveOrInactive status;
	
	@Column(name = "created")
	private Date created;
	
	@Column(name = "updated")
	private Date updated;
	
	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;

	public long getId() {
		return id;
	}
	

	public User setId(long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public ActiveOrInactive getStatus() {
		return status;
	}

	public User setStatus(ActiveOrInactive status) {
		this.status = status;
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
	
	@PrePersist
	public void prePersist() {
		this.created = new Date(System.currentTimeMillis());
	}
	
	@PreUpdate
	public void postUpdate() {
		this.updated = new Date(System.currentTimeMillis());
	}	
	

}
