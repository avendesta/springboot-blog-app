package blogproject.blog.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blogproject.blog.dao.IUserDao;
import blogproject.blog.domain.User;
import blogproject.blog.utils.Util;

@Service
@Transactional
public class UserService {
	@Resource
	private IUserDao iUserDao;
	
	//CRUD OPERATIONS
	public List<User> getAll() {
        return iUserDao.findAll();
    }

    public void delete(int id) {
    	iUserDao.deleteById(id);
    }

	public void add(User user) {
		iUserDao.save(user);
	}

	public User get(int id) {
		return iUserDao.findById(id).get();
	}

	public void update(User user) {
		iUserDao.save(user);
	}
	
	//ADDITIONAL METHODS
	public boolean isPoster(int id) {
		User user = get(id);
		if(user.getRoleId().equals(Util.ID_POSTER))
			return true;
		else return false;
	}
	
	public boolean isReader(int id) {
		User user = get(id);
		if(user.getRoleId().equals(Util.ID_READER))
			return true;
		else return false;
	}
	
	public boolean isAdmin(int id) {
		User user = get(id);
		if(user.getRoleId().equals(Util.ID_ADMIN))
			return true;
		else return false;
	}
}
