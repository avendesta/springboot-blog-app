package cs544.dao;

import cs544.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Integer>{

}
