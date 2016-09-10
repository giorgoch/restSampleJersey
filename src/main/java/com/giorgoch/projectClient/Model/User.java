package com.giorgoch.projectClient.Model;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author giorgos chatziefstratiou
 *
 */
@XmlRootElement
public class User {

	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String lname;
	@NotEmpty
	private String address;
	@NotEmpty
	private String postcode;
	@NotEmpty
	private String city;
	@NotEmpty
	private String tel;

	public User() {

	}

	public User(int id, String name, String lname, String address, String postcode, String city, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.address = address;
		this.postcode = postcode;
		this.city = city;
		this.tel = tel;

	}

	// get set for user

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

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lname=" + lname + ", address=" + address + ", postcode="
				+ postcode + ", city=" + city + ", tel=" + tel + "]";
	}

}
