package blogproject.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import blogproject.blog.domain.User;

public interface IUserDao extends JpaRepository<User, Integer>{

}
