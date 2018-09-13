package com.rest.webservices.restfulwebservices.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.webservices.restfulwebservices.user.User;
import com.rest.webservices.restfulwebservices.user.UserDaoService;
import com.rest.webservices.restfulwebservices.user.UserNotFoundException;

@Component
public class PostDaoService {

	public static List<Post> posts = new ArrayList<>();
	public static int postsCount = 13; 
	
	static {
		posts.add(new Post(1,"publicando um post na timeline", UserDaoService.users.get(0)));
		posts.add(new Post(2,"publicando um post na timeline", UserDaoService.users.get(1)));
		posts.add(new Post(3,"publicando um post na timeline", UserDaoService.users.get(1)));
		posts.add(new Post(4,"publicando um post na timeline", UserDaoService.users.get(0)));
		posts.add(new Post(5,"publicando um post na timeline", UserDaoService.users.get(0)));
		posts.add(new Post(6,"publicando um post na timeline", UserDaoService.users.get(2)));
		posts.add(new Post(7,"publicando um post na timeline", UserDaoService.users.get(2)));
		posts.add(new Post(8,"publicando um post na timeline", UserDaoService.users.get(3)));
		posts.add(new Post(9,"publicando um post na timeline", UserDaoService.users.get(4)));
		posts.add(new Post(10,"publicando um post na timeline", UserDaoService.users.get(2)));
		posts.add(new Post(11,"publicando um post na timeline", UserDaoService.users.get(4)));
		posts.add(new Post(12,"publicando um post na timeline", UserDaoService.users.get(1)));
		posts.add(new Post(13,"publicando um post na timeline", UserDaoService.users.get(3)));
	}
	
	public List<Post> findAll(){
		return posts;
	}
	
	public List<Post> findPostByUser(int id) {
		List<Post> list = new ArrayList<>();
		
		for (Post post : posts) {
			if(post.getUser().getId() == id)
				list.add(post);
		}
		return list;
	}
	
	public Post findPostByUserWhereId(int idUser, int id) {
		for (Post post : posts) {
			if(post.getUser().getId() == idUser && post.getId() == id)
				return post;
		}
		return null;
	}
	
	public void save(int id, Post post) {
		User user = null;
		for (User users : UserDaoService.users) {
			if(users.getId() == id)
				user = users;
		}
		
		if(user == null)
			throw new UserNotFoundException("id-" + id);
		
		post.setUser(user);
		post.setId(++postsCount);
		posts.add(post);
	}
}
