package cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import cs544.domain.Post;
import cs544.service.PostService;

@RestController
public class PostRestController {
	@Autowired
	private PostService postService;

	// CRUD OPERATIONS
	@GetMapping("/post/")
	public List<Post> getAll() {
		return postService.getAll();
	}

	@GetMapping("/post/{id}")
	public Post get(@PathVariable int id) {
		return postService.get(id);
	}

	@PostMapping("/post/")
	public ResponseEntity<Post> post(@RequestBody Post post, UriComponentsBuilder builder) {
		postService.add(post);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/post/{id}").buildAndExpand(post.getId()).toUri());
		return new ResponseEntity<Post>(post, headers, HttpStatus.CREATED);
	}

	@PostMapping("/post/{id}")
	public ResponseEntity<Post> put(@PathVariable Integer id, @RequestBody Post post, UriComponentsBuilder builder) {
		post.setId(id);
		postService.update(post);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/post/{id}").buildAndExpand(post.getId()).toUri());
		return new ResponseEntity<Post>(post, headers, HttpStatus.CREATED);
	}

	@DeleteMapping("/post/{id}")
	public void delete(@PathVariable int id) {
		postService.delete(id);
	}

	// ADDITIONAL OPERATIONS
	@GetMapping("/post/user/{userId}")
	public List<Post> getByUserId(@PathVariable Integer userId) {
		return postService.findByUserId(userId);
	}
}