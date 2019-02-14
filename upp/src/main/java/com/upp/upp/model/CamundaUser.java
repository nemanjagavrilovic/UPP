package com.upp.upp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class CamundaUser implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String username;
	
	@Column
	private String password;

	@Column
	private String firstName;
	
	@Column
	private String lastName;

	@Column
	private String country;
	
	@Column
	private String city;
	
	@Column
	private String email;
	
	@ManyToMany
	private List<Magazine> memberOf;
	
	
	public CamundaUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public CamundaUser(String firstName, String lastName, String country, String city, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.city = city;
		this.email = email;
	}
	
	
}
