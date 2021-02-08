package net.codejava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * @author Mayank Mahesh
 */

//This the Entity class which is used for setting and getting data from the database
@Entity
public class Person {
	private Long id;
	private String first_name;
	private String last_name;
	private String mobile;
	private String address;

	public Person() {
	}

	protected Person(Long id, String first_name, String last_name, String mobile, String address) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.address = address;
	}

	//Id is the auto incrimented 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	//This is the to string method used for for cconverting values to string 
	@Override
	public String toString() {
		return "Person [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", mobile=" + mobile
				+ ", address=" + address + "]";
	}

	
	

}
