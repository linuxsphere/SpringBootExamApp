package com.xinglie.exam.service;

import java.util.List;

import com.xinglie.exam.domain.User;

public interface UserManagement {
	public User getUserInfo(long uid, Integer version);
	public long saveUser(User user);
	public void updateUserEmail(long id, String email);
	public List<User> getUsers(long id);
}
