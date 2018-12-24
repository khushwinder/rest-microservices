package com.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
* Indicates that a class declares one or more {@link Bean @Bean} methods and
* may be processed by the Spring container to generate bean definitions and
* service requests for those beans at runtime, for example:
*
* <pre class="code">
* &#064;Configuration
* public class AppConfig {
*
*     &#064;Bean
*     public MyBean myBean() {
*         // instantiate, configure and return bean ...
*     }
* }</pre>
*
* <h2>Bootstrapping {@code @Configuration} classes</h2>
*
* <h3>Via {@code AnnotationConfigApplicationContext}</h3>
*
* {@code @Configuration} classes are typically bootstrapped using either
* {@link AnnotationConfigApplicationContext} or its web-capable variant,
* {@link org.springframework.web.context.support.AnnotationConfigWebApplicationContext
* AnnotationConfigWebApplicationContext}. 
**/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2);
		
	}

}
