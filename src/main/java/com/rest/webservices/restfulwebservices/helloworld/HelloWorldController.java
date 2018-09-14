package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
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
	
	@GetMapping(path="hello-world-internationalized")
	public String helloWordInternationalized(/*@RequestHeader(name="Accept-Language", required=false) Locale locale*/) {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
