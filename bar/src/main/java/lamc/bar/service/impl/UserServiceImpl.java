package lamc.bar.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import lamc.bar.entity.User;
import lamc.bar.repository.UserRepository;
import lamc.bar.service.UserService;
/**
 * 30/11/2021
 * 
 * @author junior solo - Coveiro
 *
 */
@Service
public class UserServiceImpl implements UserService{
	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findByUserName(String userName) {
		return this.userRepository.findByUserName(userName);
	}

	@Override
	public User createOrUpdate(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public Optional<User> findById(Integer id) {
		return this.userRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public Page<User> findAll(int page, int count) {
		//@SuppressWarnings("deprecation")
		//Pageable pages = new PageRequest(page, count, new Sort.Order("asc", "id"));	
		//return this.userRepository.findAll(pages);
		return null;
	}
}
