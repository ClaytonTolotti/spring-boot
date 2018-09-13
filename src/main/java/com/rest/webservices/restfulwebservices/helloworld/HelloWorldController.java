package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	public HelloWorldController() {
		
	}
	
	@GetMapping(path="hello-world")
	public String helloWord() {
		return "Hello World";
	}
	
	@GetMapping(path="hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("welcome");
	}
	
	@GetMapping(path="hello-world-path/{name}")
	public HelloWorldBean helloWorldPath(@PathVariable String name) {
		return new HelloWorldBean("welcome: " + name);
	}

}
