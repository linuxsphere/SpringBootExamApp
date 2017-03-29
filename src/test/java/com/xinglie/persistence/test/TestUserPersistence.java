package com.xinglie.persistence.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xinglie.exam.domain.User;
import com.xinglie.exam.service.UserManagement;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context-test.xml" })
public class TestUserPersistence  {


	@Autowired
	UserManagement userManagement;
	
	@Test
	public void testUserInsert(){
		User user = new User();
		user.setFirstName("testUser1");
		user.setLastName("Test");
		user.setEmailAddress("dummy@gmail.com");
		long uid = userManagement.saveUser(user);
		
		System.out.print("saved user id" + uid);
		userManagement.updateUserEmail(uid, "realemail@gmail.com");
	}
}
