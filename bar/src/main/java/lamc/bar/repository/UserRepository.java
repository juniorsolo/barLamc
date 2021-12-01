package lamc.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lamc.bar.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUserName(String userName);
}
