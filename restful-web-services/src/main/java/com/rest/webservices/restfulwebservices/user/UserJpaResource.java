package com.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJpaResource {	

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private PostRepository postRepository;
	
	// retrieveAllUsers

	@GetMapping("/jpa/users")
	public List<User> getUsers() {

		return userRepository.findAll();
	}

	@GetMapping("/jpa/user/{id}")
	public  Resource<User> findUser(@PathVariable int id) {
		 Optional<User> user = userRepository.findById(id);
		 
		 if (!user.isPresent())	{
			 throw new UserNotFoundException("id - "+id);
		 } 
		 
		 Resource<User> resource = new Resource<User>(user.get());
		 return resource;
	}

	@PostMapping("/jpa/user")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
		
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("user with id not found - "+ id);
		}
		
		
		User user = userOptional.get();
		
		post.setUser(user);
		postRepository.save(post);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@DeleteMapping("/jpa/user/{id}")
	public void deleteUser(@PathVariable int id) {
		
		userRepository.deleteById(id);
		
	}
	
	// retrieveAllPosts

	@GetMapping("/jpa/users/{id}/posts")
	
	public List<Post> getUserPosts(@PathVariable int id) {
		
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			
			throw new UserNotFoundException("id- "+ id);
			
		}
		
		return userOptional.get().getPosts();
		
	}
}
