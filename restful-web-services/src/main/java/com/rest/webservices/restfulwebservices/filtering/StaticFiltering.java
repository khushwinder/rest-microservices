package com.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFiltering {
	
	
	@GetMapping("/staticfiltering")
	public SomeBean returnSomeBean() {
	return new SomeBean("v1","v2","v3");	
	}

}
