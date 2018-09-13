package com.rest.webservices.restfulwebservices.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostResource {

	@Autowired
	private PostDaoService service;
	
	@GetMapping(path="/users/{id}/posts")
	public List<Post> retrieveAllPostFromUser(@PathVariable int id){
		List<Post> list = service.findPostByUser(id);
		
		if(list.isEmpty())
			throw new PostNotFoundException("id-" + id);
		
		return list;
	}
	
	@GetMapping(path="/users/{idUser}/posts/{id}")
	public Post retrievePostFromUser(@PathVariable int idUser, @PathVariable int id){
		Post post = service.findPostByUserWhereId(idUser, id);
		
		if(post == null)
			throw new PostNotFoundException("idUser-" + idUser + " id-" + id);
		
		return post;
	}
	
	@PostMapping(path="/users/{id}/posts")
	public void createPost(@PathVariable int id, @RequestBody Post post) {
		service.save(id, post);
	}
}
