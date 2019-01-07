package net.asd.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Supplier {

	//private fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="name")
	@NotBlank(message="Please enter supplier name!")
	private String Name;
	
	@Column(name="email")
	@NotBlank(message="Please enter email address!")
	@Email(message="Please provide a valid email address")
	private String Email;
	
	//@Size(min=10,max=10,message="Please enter valid phone number!")
	private int phone;
	
	private String code;
	
	private boolean active;
	
	
	//default constructor
		public Supplier() {
			
			this.code = "SUP1004";
			
		}
		
	//getters and setters
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Supplier [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", phone=" + phone + ", code=" + code
				+ ", active=" + active + "]";
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
