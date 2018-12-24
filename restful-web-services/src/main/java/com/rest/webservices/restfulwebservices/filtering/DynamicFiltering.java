package com.rest.webservices.restfulwebservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFiltering {
	
	@GetMapping("/dynamicfiltering")
	public MappingJacksonValue retrieveSomeBean() {
		
		DynamicBean o = new DynamicBean("v1","v2","v3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("v1");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(o);
		
		mapping.setFilters(filters);
		
		
		return mapping;
		
	}

}
