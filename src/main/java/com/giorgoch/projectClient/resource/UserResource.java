package com.giorgoch.projectClient.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.giorgoch.projectClient.Model.*;
import com.giorgoch.projectClient.wsService.UserService;

@Path("/user")
public class UserResource {

	UserService userService = new UserService();

	@GET
	@Path("/Json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserJson() {
		return userService.getAllUsers();
	}

	@GET
	@Path("/Json/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getSingleUserJson(@PathParam("userId") int id) {
		return userService.getUser(id);
	}

	@GET
	@Path("/Xml/{userId}")
	@Produces(MediaType.APPLICATION_XML)
	public User getSingleUserXML(@PathParam("userId") int id) {
		return userService.getUser(id);
	}

	@GET
	@Path("/Xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUserXML() {
		return userService.getAllUsers();
	}

}
