package blogproject.commentblogREST.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import blogproject.commentblogREST.domain.Comment;

public interface ICommentDao extends JpaRepository<Comment, Integer>{
	List<Comment> findByPostId(Integer postId);
	List<Comment> findByUserId(Integer userId);
	List<Comment> findByCommentedOn(Date date);
	List<Comment> findTop10ByCommentedOn(Date date);
}
