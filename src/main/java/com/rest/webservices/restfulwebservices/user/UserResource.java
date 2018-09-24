package com.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(user == null)
			throw new UserNotFoundException("id-" + id);
		
		/*Resource<User> resource = new Resource<User>(user);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass(), retrieveAllUsers()));
		resource.add(linkTo.withRel("all-users"));
		return resource;*/
		return user;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User userSaved = service.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
			.buildAndExpand(userSaved.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if(user == null)
			throw new UserNotFoundException("id-" + id);
	}
}
