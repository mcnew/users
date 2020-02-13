package com.github.mcnew.misc.users.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.mcnew.misc.users.controller.request.UserRequest;
import com.github.mcnew.misc.users.model.User;
import com.github.mcnew.misc.users.repository.UserRepository;
import com.github.mcnew.misc.users.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User create(UserRequest request) {
		User user = new User();
		user.setEdad(request.getEdad());
		user.setNombre(request.getNombre());
		user.setEstatus(request.getEstatus());
		return repository.save(user);
	}

	@Override
	public User read(Integer id) {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	@Override
	public Collection<User> read() {
		Iterable<User> iterable = repository.findAll();
		ArrayList<User> list = new ArrayList<>();
		for (User user : iterable) {
			list.add(user);
		}
		return list;
	}

	@Override
	public boolean update(Integer id, UserRequest request) {
		Optional<User> optional = repository.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
			user.setEdad(request.getEdad());
			user.setNombre(request.getNombre());
			user.setEstatus(request.getEstatus());
			repository.save(user);
			return true;
		} else {
			return false;
		}
	}

}
