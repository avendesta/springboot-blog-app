package blogproject.commentblogREST.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import blogproject.commentblogREST.dao.ICommentDao;
import blogproject.commentblogREST.domain.Comment;

@Service
@Transactional
public class CommentService {
	// CRUD OPERATIONS
	@Resource
	private ICommentDao iCommentDao;
	public List<Comment> getAll() {
        return iCommentDao.findAll();
    }

    public void delete(int id) {
    	iCommentDao.deleteById(id);
    }

	public void add(Comment comment) {
		iCommentDao.save(comment);
	}

	public Comment get(int id) {
		return iCommentDao.findById(id).get();
	}

	public void update(Comment comment) {
		iCommentDao.save(comment);
	}
	// ADDITIONAL OPERATIONS
	public List<Comment> findByPostId(Integer postId){
		return iCommentDao.findByPostId(postId);
	}
	public List<Comment> findByUserId(Integer userId){
		return iCommentDao.findByUserId(userId);
	}
}
