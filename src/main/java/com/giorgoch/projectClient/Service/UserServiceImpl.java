package com.giorgoch.projectClient.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.giorgoch.projectClient.Model.User;


@Transactional(propagation=Propagation.REQUIRED,timeout=50)
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Override
	public List<User> getUser() throws Exception {

		return null;
	}

	@Override
	public void createAcount(User user) {

	}

	@Override
	public User registeredNewUserAccount(User user) {

		return null;
	}

	@Override
	public List<User> getusers() {

		return null;
	}

	
}
