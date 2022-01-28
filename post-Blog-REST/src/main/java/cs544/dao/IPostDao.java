package cs544.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import cs544.domain.Post;

public interface IPostDao extends JpaRepository<Post, Integer>{
	List<Post> findByUserId(Integer postId);
	List<Post> findByPostedOn(Date date);
	List<Post> findTop10ByPostedOn(Date date);	
}
