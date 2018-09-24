package com.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@RequestMapping(value="/v1/person", method=RequestMethod.GET)
	public PersonV1 personV1() {
		return new PersonV1("Clayton Tolotti");
	}
	
	@RequestMapping(value="/v2/person", method=RequestMethod.GET)
	public PersonV2 personV2() {
		return new PersonV2(new Name("Clayton", "Tolotti"));
	}
	
	@RequestMapping(value="/person/param", method=RequestMethod.GET, params="version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Clayton Tolotti");
	}
	
	@RequestMapping(value="/person/param", method=RequestMethod.GET, params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Clayton", "Tolotti"));
	}
	
	@RequestMapping(value="/person/header", method=RequestMethod.GET, headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Clayton Tolotti");
	}
	
	@RequestMapping(value="/person/header", method=RequestMethod.GET, headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Clayton", "Tolotti"));
	}
	
	@RequestMapping(value="/person/produces", method=RequestMethod.GET, produces="application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Clayton Tolotti");
	}
	
	@RequestMapping(value="/person/produces", method=RequestMethod.GET, produces="application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Clayton", "Tolotti"));
	}
}
