package fr.jbe.jfxspringboot.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.jbe.jfxspringboot.db.domain.User;
import fr.jbe.jfxspringboot.db.repository.IUserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private IUserRepository userRepository;
	
	public User findByFirstname(String firstname) {
		return userRepository.findByFirstname(firstname);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
}
