package cs544.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import cs544.domain.Post;
import cs544.service.PostService;

import javax.validation.Valid;

@RestController
public class PostRestController {
	@Autowired
	private PostService postService;

	// redirect to swagger documentation
	@GetMapping("/doc")
	ResponseEntity<Void> redirect() {
		return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/swagger-ui.html#/post45rest45controller"))
				.build();
	}

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
	public ResponseEntity<Post> post(@Valid @RequestBody Post post, UriComponentsBuilder builder) {
		postService.add(post);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/post/{id}").buildAndExpand(post.getId()).toUri());
		return new ResponseEntity<Post>(post, headers, HttpStatus.CREATED);
	}

	@PostMapping("/post/{id}")
	public ResponseEntity<Post> put(@PathVariable Integer id, @Valid @RequestBody Post post, UriComponentsBuilder builder) {
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

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}