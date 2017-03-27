
package com.xinglie.exam.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.xinglie.exam.domain.User;
import com.xinglie.exam.service.UserManagement;

@Component
@Path("api/user")
public class UserApi {

	private final UserManagement userService;

	public UserApi(UserManagement service) {
		this.userService = service;
	}

	@GET
	@Path("config/{version}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@QueryParam("uid") long uid, @PathParam("version") Integer version) {
		
		User u =  this.userService.getUserInfo(uid, version);
		return u;
		
	}
	
	
	
	@GET
	@Path("config")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUser(@QueryParam("uid") long uid) {
		
		List<User> u =  this.userService.getUsers(uid);
		return u;
		
	}
	
	@POST
	@Path("config/{version}")
	public String addNew(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName, @FormParam("email") String email, @PathParam("version") Integer version){
		User user  = new User();
		user.setEmailAddress(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setVersion(version);
		userService.saveUser(user);
		return "success";
	}
}
