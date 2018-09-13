package com.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	public static List<User> users = new ArrayList<>();
	public static int usersCount = 5;
	
	static {
		users.add(new User(1, "Clayton", new Date()));
		users.add(new User(2, "Clayton", new Date()));
		users.add(new User(3, "Clayton", new Date()));
		users.add(new User(4, "Clayton", new Date()));
		users.add(new User(5, "Clayton", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for (User user : users) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
	public void deleteById(int id) {
		
	}
}
