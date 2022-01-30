package cs544.dao;

import java.util.Date;
import java.util.List;

import cs544.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentDao extends JpaRepository<Comment, Integer>{
	List<Comment> findByPostId(Integer postId);
	List<Comment> findByUserId(Integer userId);
	List<Comment> findByCommentedOn(Date date);
	List<Comment> findTop10ByCommentedOn(Date date);
}
