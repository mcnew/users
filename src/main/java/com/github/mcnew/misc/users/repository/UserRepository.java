package com.github.mcnew.misc.users.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.mcnew.misc.users.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
