package com.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
    private MessageSource messageSource;
	

	
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world") OR
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	//hello-world-bean
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("msg from bean");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVairable(@PathVariable String name) {

		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world") OR
		/*@GetMapping(path="/hello-world-i18l")
		public String helloWorldI18l(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
			return messageSource.getMessage("good.morning.message",null, locale);
		}*/
	
	
	//OR 
	
	@GetMapping(path="/hello-world-i18l")
	public String helloWorldI18l() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
		
		

}
