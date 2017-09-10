package com.giorgoch.projectClient.Model;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;


/**
 * @author giorgos chatziefstratiou
 *
 */
@XmlRootElement
public @Data class User {

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
	
	
	
	

}
