package com.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	//To return default locale
	
	//@Bean Indicates that a method produces a bean to be managed by the Spring container.
	@Bean
	public LocaleResolver localeResolver() {
		//SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		
		//implementation that simply uses the primary locale specified in the "accept-language" header of the HTTP request
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	
/*	* {@link org.springframework.context.MessageSource} implementation that
	 * accesses resource bundles using specified basenames. */
	
	/*@Bean
	public MessageSource  messageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("messages");		
		return messageSource;	
		
	}*/
	
	/* @Bean
	    public MessageSource messageSource() {
	        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	        messageSource.setBasenames("messages");
	        messageSource.setDefaultEncoding("UTF-8");
	        messageSource.setCacheSeconds(1);
	        return messageSource;
	    }    */

	
}
