package blogproject.commentblogREST.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import blogproject.commentblogREST.domain.Comment;

public interface ICommentDao extends JpaRepository<Comment, Integer>{

}
