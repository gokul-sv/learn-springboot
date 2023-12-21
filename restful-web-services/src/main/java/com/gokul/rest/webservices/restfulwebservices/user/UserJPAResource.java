package com.gokul.rest.webservices.restfulwebservices.user;

import java.io.Serial;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gokul.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.gokul.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJPAResource {

	private UserRepository repository;

	private PostRepository postRepository;


	public UserJPAResource(UserRepository repository, PostRepository postRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUser() {
		return repository.findAll();
	}

	@GetMapping("/jpa/users/{id}") // {} - path variable
	public Optional<User> retrieveUser(@PathVariable Integer id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id:" + id);
		return user;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/jpa/users/{id}") // {} - path variable
	public void deleteUser(@PathVariable Integer id) {
		repository.deleteById(id);
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("id:" + id);

		return user.get().getPosts();

	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = repository.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("id:" + id);

		post.setUser(user.get());

		Post savedPost = postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
