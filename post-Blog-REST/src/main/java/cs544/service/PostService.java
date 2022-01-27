package cs544.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.dao.IPostDao;
import cs544.domain.Post;

@Service
@Transactional
public class PostService {
	@Resource
	private IPostDao iPostDao;
	
	public List<Post> getAll() {
        return iPostDao.findAll();
    }

    public void delete(int id) {
    	iPostDao.deleteById(id);
    }

	public void add(Post post) {
		iPostDao.save(post);
	}

	public Post get(int id) {
		return iPostDao.findById(id).get();
	}

	public void update(Post post) {
		iPostDao.save(post);
	}
}
