package com.giorgoch.projectClient.Service;

import java.util.List;

import com.giorgoch.projectClient.Model.User;

public interface UserService {

	public List<User> getUser() throws Exception;

	public void createAcount(User user);

	User registeredNewUserAccount(User user);

	public List<User> getusers();

	

}
