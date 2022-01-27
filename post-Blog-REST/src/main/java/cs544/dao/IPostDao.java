package cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.domain.Post;

public interface IPostDao extends JpaRepository<Post, Integer>{

}
