package com.example.oluniyin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.oluniyin.domain.User;
import com.example.oluniyin.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailService implements UserDetailsService {

	private UserRepository userRepository;

	@Autowired
	public UserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findByEmail(String email) {

		return userRepository.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(user);
	}

}
