package com.github.mcnew.misc.users.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.mcnew.misc.users.controller.request.UserRequest;
import com.github.mcnew.misc.users.model.User;
import com.github.mcnew.misc.users.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<User>> get() {
		return ResponseEntity.ok(service.read());
	}

	@GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> get(@PathVariable("id") Integer id) {
		User user = service.read(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(user);
		}
	}

	@PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> post(@Validated @RequestBody UserRequest request) {
		User user = service.create(request);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(path = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> put(@PathVariable("id") Integer id, @Validated @RequestBody UserRequest request) {
		boolean found = service.update(id, request);
		if (found) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
