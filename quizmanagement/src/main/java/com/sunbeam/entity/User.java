package com.sunbeam.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;

public class User  extends JFrame {

	private int id;
	private String name;
	private String email;
	private String password;
	private Role role;
	
	
	
	
	private Map<Integer,Attempt> attemptmap;
	public User() {
		attemptmap = new HashMap<>();
		
	}

	public User(int id, String name, String email, String password, Role role) {
		
		this.id = id; 
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		attemptmap = new HashMap<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

	public Map<Integer, Attempt> getAttemptmap() {
		return attemptmap;
	}

	public void setAttemptmap(Map<Integer, Attempt> attemptmap) {
		this.attemptmap = attemptmap;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && role == other.role;
	}
	
	
}
