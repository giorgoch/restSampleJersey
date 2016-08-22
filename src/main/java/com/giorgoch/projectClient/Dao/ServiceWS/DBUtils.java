package com.giorgoch.projectClient.Dao.ServiceWS;

import java.util.HashMap;
import java.util.Map;

import com.giorgoch.projectClient.Model.*;

public class DBUtils {

	private static Map<Integer, User> users = new HashMap<>();

	public static Map<Integer, User> getUsers() {
		return users;
	}

}