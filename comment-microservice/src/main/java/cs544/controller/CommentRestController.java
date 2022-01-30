package cs544.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cs544.domain.Comment;
import cs544.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;


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
    public ResponseEntity<Comment> comment(@Valid @RequestBody Comment comment, UriComponentsBuilder builder) {
        commentService.add(comment);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/comment/{id}").buildAndExpand(comment.getId()).toUri());
        return new ResponseEntity<Comment>(comment, headers, HttpStatus.CREATED);
    }

    @PutMapping("/comment/{id}")
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