package cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

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
	public RedirectView post(@RequestBody Post post) {
		System.out.println(post);
		postService.add(post);
		return new RedirectView("/post/");
	}

	@PostMapping("/post/{id}")
	public void put(@PathVariable long id, @RequestBody Post post) {
		if (id != post.getId()) { throw new IllegalArgumentException(); }
		postService.update(post);
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