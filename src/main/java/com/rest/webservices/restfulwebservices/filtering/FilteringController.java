package com.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		return someBean;
	}
	
	@GetMapping("/filtering-dinamic")
	public MappingJacksonValue retrieveDinamicSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		
		MappingJacksonValue jacksonValue = new MappingJacksonValue(someBean);
		jacksonValue.setFilters(filters);
		
		return jacksonValue;
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean(){
		return Arrays.asList(new SomeBean("value1", "value2", "value3"), 
				new SomeBean("value4", "value5", "value6"), 
				new SomeBean("value7", "value8", "value9"));
	}
	
	@GetMapping("/filtering-list-dinamic")
	public MappingJacksonValue retrieveDinamicListOfSomeBean(){
		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"), 
				new SomeBean("value4", "value5", "value6"), 
				new SomeBean("value7", "value8", "value9"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		
		MappingJacksonValue jacksonValue = new MappingJacksonValue(list);
		jacksonValue.setFilters(filters);
		
		return jacksonValue;
	}
}
