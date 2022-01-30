package cs544.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs544.domain.Post;
import cs544.domain.PostWithComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cs544.domain.Comment;
import cs544.service.UserService;

@RestController
@RequestMapping("/client")
public class MainController {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	UserService userService;

	@RequestMapping("/post/user/{userId}")
	public List<Post> getAllPostsByUser(@PathVariable("userId") Integer userId) {
		Post[] allUserPosts = restTemplate.getForObject("http://localhost:8081/post/user/" + userId, Post[].class);
		List<Post> posts = Arrays.asList(allUserPosts);
		System.out.println(posts);
		return posts;
	}

	@RequestMapping("/post/{postId}")
	public PostWithComments getPostWithComments(@PathVariable("postId") Integer postId) {
		Post post = restTemplate.getForObject("http://localhost:8081/post/" + postId, Post.class);
		Comment[] commentArray = restTemplate.getForObject("http://localhost:8082/comment/post/" + postId,
				Comment[].class);
		List<Comment> comments = Arrays.asList(commentArray);

		PostWithComments pwc = new PostWithComments();
		pwc.setPost(post);
		pwc.setComments(comments);
		System.out.println(comments);
		return pwc;
	}

	@RequestMapping("/post")
	public List<Post> getAllPosts() {
		Post[] allUserPosts = restTemplate.getForObject("http://localhost:8081/post/", Post[].class);
		List<Post> posts = Arrays.asList(allUserPosts);
		System.out.println(posts);
		return posts;
	}

	@RequestMapping("/post/{postId}/comments")
	public List<Comment> getAllCommentsByPost(@PathVariable("postId") Integer postId) {

		Comment[] commentArray = restTemplate.getForObject("http://localhost:8082/comment/post/" + postId,
				Comment[].class);
		List<Comment> lstComments = Arrays.asList(commentArray);

		System.out.println(lstComments);
		return lstComments;
	}

	@RequestMapping("/post/comments/user/{userId}")
	public List<Comment> getAllCommentsByUser(@PathVariable("userId") Integer userId) throws Exception {
		List<Comment> lstComments = new ArrayList<>();

		if (userService.isPoster(userId) || userService.isAdmin(userId)) {
			Comment[] commentArray = restTemplate.getForObject("http://localhost:8082/comment/user/" + userId,
					Comment[].class);
			lstComments = Arrays.asList(commentArray);
		} else {
			throw new Exception("You do not have permitions.");
		}

		System.out.println(lstComments);
		return lstComments;
	}

	@PostMapping("/post")
	public Post setPost(@RequestBody Post post) {
		ResponseEntity<Post> postAnswer = restTemplate.postForEntity("http://localhost:8081/post/", post, Post.class);
		System.out.println(postAnswer);
		return postAnswer.getBody();
	}

	@DeleteMapping("/post/{postId}")
	public void deletePost(@PathVariable Integer postId) {
		restTemplate.delete("http://localhost:8081/post/" + postId);
	}

	@PostMapping("/post/{postId}/comment")
	public Comment setCommentToPost(@PathVariable Integer postId, @RequestBody Comment comment) {
		comment.setPostId(postId);
		ResponseEntity<Comment> postAnswer = restTemplate.postForEntity("http://localhost:8082/comment/", comment,
				Comment.class);
		System.out.println(postAnswer);
		return postAnswer.getBody();
	}

	@PutMapping("/post/{postId}")
	public Post putPost(@PathVariable Integer postId, @RequestBody Post post) {
		ResponseEntity<Post> postAnswer = restTemplate.postForEntity("http://localhost:8081/post/" + postId, post,
				Post.class);
		System.out.println(postAnswer);
		return postAnswer.getBody();
	}

	@PutMapping("/comment/{id}")
	public Comment putComment(@PathVariable Integer id, @RequestBody Comment comment) {
		comment.setId(id);

		System.out.println(":: UPDATE comment");
		System.out.println(comment);

//		restTemplate.put("http://localhost:8082/comment/"+id, comment);
		ResponseEntity<Comment> postAnswer = restTemplate.postForEntity("http://localhost:8082/comment/" + id, comment,
				Comment.class);
		System.out.println(postAnswer);
		return postAnswer.getBody();
	}

	@DeleteMapping("/post/comment/{commentId}")
	public void deleteComment(@PathVariable Integer commentId) {
		restTemplate.delete("http://localhost:8082/comment/" + commentId);
	}
}
