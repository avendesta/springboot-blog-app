package blogproject.commentblogREST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import blogproject.commentblogREST.service.CommentService;
import blogproject.commentblogREST.domain.Comment;

@RestController
public class CommentRestController {
	@Autowired
	private CommentService commentService;

	@GetMapping("/comment")
	public List<Comment> getAll() {
		return commentService.getAll();
	}

	@GetMapping("/comment/{id}")
	public Comment get(@PathVariable int id) {
		return commentService.get(id);
	}

	@PostMapping("/comment")
	public RedirectView comment(@RequestBody Comment comment) {
		commentService.add(comment);
		return new RedirectView("/comment/"+comment.getId());
	}

	@PostMapping("/comment/{id}")
	public void put(@PathVariable long id, @RequestBody Comment comment) {
		if (id != comment.getId()) { throw new IllegalArgumentException(); }
		commentService.update(comment);
	}

	@DeleteMapping("/comment/{id}")
	public void delete(@PathVariable int id) {
		commentService.delete(id);
	}

}
