package com.competition.entities;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Sauveteur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Column(name = "age")
	private Integer age;
	
	public Sauveteur() {
		super();
	}
	public Sauveteur(Long id, String name, String email, LocalDate dob, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	public Sauveteur(String name, String email, LocalDate dob, Integer age) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail(String s) {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Integer getAge(int i) {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Sauveteur [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + "]";
	}


}
