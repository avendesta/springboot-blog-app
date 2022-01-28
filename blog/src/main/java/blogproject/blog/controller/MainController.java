package blogproject.blog.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import blogproject.blog.domain.Post;

@RestController
@RequestMapping("/client")
public class MainController {
	@Autowired
	RestTemplate restTemplate;
	@RequestMapping("/{userId}")
	public List<Post> getAllPostsByUser(@PathVariable("userId") Integer userId){
		Post[] allUserPosts = restTemplate.getForObject("http://localhost:8081/post/user/"+userId, Post[].class);
		List<Post> posts = Arrays.asList(allUserPosts);
		System.out.println(posts);
		return posts;
	}
}
