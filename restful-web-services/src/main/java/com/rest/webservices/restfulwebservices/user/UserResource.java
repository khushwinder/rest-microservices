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
	private UserDaoService userService;

	// retrieveAllUsers

	@GetMapping("/users")
	public List<User> getUsers() {

		return userService.findAll();
	}

	@GetMapping("/user/{id}")
	public User findUser(@PathVariable int id) {
		 User user = userService.findUser(id);
		 if (null == user)	{
			 throw new UserNotFoundException("id - "+id);
		 } 
		 return user;
	}

	@PostMapping("/user")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.saveUser(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		
		User user  = userService.deletebyId(id);
		
		if(null == user) {
			 throw new UserNotFoundException("id - "+id);
		}
		
	}
}
