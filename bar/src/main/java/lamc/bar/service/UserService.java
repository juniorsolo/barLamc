package lamc.bar.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import lamc.bar.entity.User;

public interface UserService {
	User findByUserName(String userName);
	User createOrUpdate(User user);
	Optional<User> findById(Integer id);
	void delete(Integer id);
	public Page<User> findAll(int page, int count);
}
