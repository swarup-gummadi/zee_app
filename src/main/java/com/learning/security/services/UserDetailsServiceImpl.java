package com.learning.security.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.dto.User;
import com.learning.repo.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("user not found with username: "+ userName));
	
		return UserDetailsImpl.build(user);
	}

}