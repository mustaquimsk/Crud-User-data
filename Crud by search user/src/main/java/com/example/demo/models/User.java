package com.example.demo.models;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Size(min = 4,max = 10)
	@Column(name ="username",updatable = true)
	private String name;
	
	@Email(message="plese enter valid email")
	@NotNull
	@NotBlank
	@Column(nullable = false,unique = true)
	private String email;
	
	@NotNull
	@NotBlank
	@Pattern(regexp ="[a-zA-Z0-9]+",message ="password must be a character or number")
	@Column(nullable = false)
	private String password;
	
	public Instant getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Instant createDate) {
		this.createDate = createDate;
	}

	public Instant getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Instant updateDate) {
		this.updateDate = updateDate;
	}

	@CreatedDate
	private Instant createDate;
	
	@LastModifiedDate
	private Instant updateDate;
	
	@OneToOne
	@JoinColumn(name ="address_id")
	private Address address;
	
	@OneToMany(mappedBy="user")
	private List<Blogs>blogs;
	
	public Address getAddress() {
		return address;
		
	}
	public void setAddress(Address address) {
		this.address=address;
	}
	
	User(){
		
	}

	public User(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
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

	
}
