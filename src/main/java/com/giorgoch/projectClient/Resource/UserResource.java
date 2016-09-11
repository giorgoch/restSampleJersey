package com.giorgoch.projectClient.Resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.giorgoch.projectClient.Commons.LoggingHandler;
import com.giorgoch.projectClient.Model.*;
import com.giorgoch.projectClient.wsService.UserServiceWS;

@Path("/user")
@Component
public class UserResource {

	
	/**
	 * @author giorgos chatziefstratiou
	 * Jersey Rest Service 
	 * returning  json and xml format
	 * using @GET to retrieve data
	 * 
	 */
	UserServiceWS userService = new UserServiceWS();

	@GET
	@Path("/Json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserJson() {
		//returning all users  in json
		return userService.getAllUsers();
	}

	/**
	 * @pathparam userid to get the user data to retrieve specific user
	 * @return
	 */
	@GET
	@Path("/Json/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getSingleUserJson(@PathParam("userId") int id) {
		//returning specific user  in json
		return userService.getUser(id);
	}

	@GET
	@Path("/Xml/{userId}")
	@Produces(MediaType.APPLICATION_XML)
	public User getSingleUserXML(@PathParam("userId") int id) {
		//returning specific user  in xml
		return userService.getUser(id);
	}

	@GET
	@Path("/Xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUserXML() {
		//returning all users  in Xml
		return userService.getAllUsers();
	}
	
	
}
