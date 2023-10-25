package com.register.registerrol.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Roles {
	
	@Id
	private long id;
	private String name;
	private String surname;
	private String contact;
	private String email;
	private String password;
	
	public Roles(long id,String name, String surname, String contact, String email, String password) {
		super();
		this.id=id;
		this.name = name;
		this.surname = surname;
		this.contact = contact;
		this.email = email;
		this.password = password;
	}
	
	
	public Roles() {
		super();
	}


	public String getName() {
		return name;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
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


	@Override
	public String toString() {
		return "Roles [id=" + id + ", name=" + name + ", surname=" + surname + ", contact=" + contact + ", email="
				+ email + ", password=" + password + "]";
	}
	

}
