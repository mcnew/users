package com.github.mcnew.misc.users.service;

import java.util.Collection;

import com.github.mcnew.misc.users.controller.request.UserRequest;
import com.github.mcnew.misc.users.model.User;

public interface UserService {

	User create(UserRequest request);
	
	User read(Integer id);
	
	Collection<User> read();
	
	boolean update(Integer id, UserRequest request);

}
