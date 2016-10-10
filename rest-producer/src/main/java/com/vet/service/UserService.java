package com.vet.service;

import java.util.ArrayList;
import java.util.List;

import com.vet.model.Address;
import com.vet.model.User;

public class UserService {
	
	private static List<User> USERS = new ArrayList<User>();
	static {
		for (int i = 1; i <= 20; i++) {
			User u = new User();
			u.setId(i);
			u.setName("name" + i);
			u.setLastname("lastname" +i);
			u.setSex(i % 2 == 0 ? "M" : "F");
			u.setExtraField("extra Field" + i);
			Address address = new Address();
			address.setZip("zip" + i);
			address.setPhone("phone" + i);
			u.setAddress(address);
			
			USERS.add(u);
		}
	}
	
	public static List<User> getUsers() {
		return USERS;
	}


}
