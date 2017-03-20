package com.sda.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "id"),
		@UniqueConstraint(columnNames = "login") })
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "login")
	private String login;

	@Column(name = "password_hash")
	private String password_hash;

	public User() {
		super();
	}

	public User(String login, String password_hash) {
		super();
		this.login = login;
		this.password_hash = password_hash;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}

}
