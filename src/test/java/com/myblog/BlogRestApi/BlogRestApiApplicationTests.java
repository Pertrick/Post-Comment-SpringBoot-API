package com.myblog.BlogRestApi;

import com.myblog.BlogRestApi.domain.User;
import com.myblog.BlogRestApi.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogRestApiApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	public void TestUser(){
		User user = new User();
		user.setId(2);
		user.setFullname("Patrick Udoh");
		user.setPassword("12345");
		user.setEmail("pat@gmail.com");
		User savedUser = userService.saveUser(user);
		assertNotNull(savedUser);

		User user1 = userService.getUser(savedUser.getId());

		assertEquals("pat@gmail.com", user1.getEmail());

	}

	@Test
	public void getAllUsers(){
		List<User> user =  userService.getAllUser();

		assertNotNull(user);
		assertEquals(1, user.size());
	}

}
