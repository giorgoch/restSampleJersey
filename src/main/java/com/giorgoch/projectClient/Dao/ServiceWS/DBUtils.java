package com.giorgoch.projectClient.Dao.ServiceWS;

import java.util.HashMap;
import java.util.Map;

import com.giorgoch.projectClient.Model.*;

public class DBUtils {
	/**
	 * @author giorgos chatziefstratiou
	 * 
	 * maps are the same like a database
	 * Here the map is representing a database
	 * Database Connection can be established a little different
	 */
	private static Map<Integer, User> users = new HashMap<Integer,User>();

	public static Map<Integer, User> getUsers() {
		return users;
	}

}