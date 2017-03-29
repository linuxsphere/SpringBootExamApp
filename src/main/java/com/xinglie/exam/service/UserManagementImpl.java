package com.xinglie.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinglie.exam.domain.User;
import com.xinglie.exam.repository.UserRepository;

@Service
class UserManagementImpl implements UserManagement {

	private final UserRepository userRepository;


	public UserManagementImpl(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	public long saveUser(User user) {
		User savedUser = userRepository.saveAndFlush(user);
		return savedUser.getId();
	}

	public User getUserInfo(long id, Integer version) {

		Sort sort = new Sort(Direction.ASC, "version");
		User u = userRepository.findByIdSortByVersion(id, version);
		return u;
	}

	public List<User> getUsers(long id) {

		List<User> u = userRepository.findAllUsers(id);
		
		return u;
	}

	@Transactional
	public void updateUserEmail(long uid, String email) {

		User user = userRepository.findOne(uid);
		user.setEmailAddress(email);
		userRepository.saveAndFlush(user);
	}


}