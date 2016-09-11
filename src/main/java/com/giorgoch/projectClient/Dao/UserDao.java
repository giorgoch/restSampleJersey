package com.giorgoch.projectClient.Dao;

import java.util.List;

import com.giorgoch.projectClient.Model.User;

public interface UserDao {

	public List<User> getUsers();

	public boolean updateUser(User user);

	public boolean delete(int id);

	public User getUser(int id);

	public boolean create(User user);
}
