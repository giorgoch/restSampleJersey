package com.giorgoch.projectClient.wsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.giorgoch.projectClient.Dao.ServiceWS.DBUtils;
import com.giorgoch.projectClient.Model.User;

@Transactional(propagation = Propagation.REQUIRED, timeout = 50)
public class UserServiceWS {

	private Map<Integer, User> users = DBUtils.getUsers();

	/**
	 * @author giorgos chatziefstratiou adding some test data
	 * 
	 */
	public UserServiceWS() {
		users.put(1, new User(1, "Alladin", "The Thief", "Persia 3", "12345", "Persia", "123456789"));
		users.put(2, new User(2, "Lucky", "Loke", "Texas", "74185", "El paso", "000000000"));
		users.put(3, new User(3, "Marty", "Martian", "Mars 8", "00000", "Mars", "7777777777"));
		users.put(4, new User(4, "Zeus", "The Olympian", "Mount Olympos", "56789", "Olympos", "99999999"));
	}

	public List<User> getAllUsers() {
		return new ArrayList<User>(users.values());
	}

	public User getUser(int id) {
		return users.get(id);
	}

	public User saveUser(User user) {
		users.put(5, new User(user.getId(), user.getAddress(), user.getCity(), user.getLname(), user.getName(),
				user.getPostcode(), user.getTel()));
		return user;
	}

}
