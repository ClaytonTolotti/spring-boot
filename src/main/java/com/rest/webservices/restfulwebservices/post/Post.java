package com.rest.webservices.restfulwebservices.post;

import com.rest.webservices.restfulwebservices.user.User;

public class Post {

	private int id;
	private String message;
	private User user;
	
	public Post() {
		super();
	}

	public Post(int id, String message, User user) {
		super();
		this.id = id;
		this.message = message;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
