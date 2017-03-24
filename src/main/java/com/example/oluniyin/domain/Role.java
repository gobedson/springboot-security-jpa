package com.example.oluniyin.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String role;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();

	private Role() {
		// Do something
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
