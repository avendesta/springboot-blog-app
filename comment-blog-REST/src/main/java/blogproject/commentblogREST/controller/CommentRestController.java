package blogproject.commentblogREST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import blogproject.commentblogREST.service.CommentService;
import blogproject.commentblogREST.domain.Comment;

@RestController
public class CommentRestController {
	@Autowired
	private CommentService commentService;

	// CRUD OPERATIONS
	@GetMapping("/comment")
	public List<Comment> getAll() {
		return commentService.getAll();
	}

	@GetMapping("/comment/{id}")
	public Comment get(@PathVariable int id) {
		return commentService.get(id);
	}

	@PostMapping("/comment")
	public ResponseEntity<Comment> comment(@RequestBody Comment comment, UriComponentsBuilder builder) {
		commentService.add(comment);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/comment/{id}").buildAndExpand(comment.getId()).toUri());
		return new ResponseEntity<Comment>(comment, headers, HttpStatus.CREATED);
	}

	@PostMapping("/comment/{id}")
	public ResponseEntity<Comment> put(@PathVariable Integer id, @RequestBody Comment comment, UriComponentsBuilder builder) {
		comment.setId(id);
		commentService.update(comment);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/comment/{id}").buildAndExpand(comment.getId()).toUri());
		return new ResponseEntity<Comment>(comment, headers, HttpStatus.CREATED);
	}

	@DeleteMapping("/comment/{id}")
	public void delete(@PathVariable int id) {
		commentService.delete(id);
	}

	// ADDITIONAL OPERATIONS
	@GetMapping("/comment/post/{postId}")
	public List<Comment> getCommentByPostId(@PathVariable Integer postId) {
		return commentService.findByPostId(postId);
	}

	@GetMapping("/comment/user/{userId}")
	public List<Comment> getCommentByUserId(@PathVariable Integer userId) {
		return commentService.findByUserId(userId);
	}
}
