/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.repositories;

import com.natslash.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @param <User>
 * 
 */

public interface UserRepository extends CrudRepository<User, Long> {
  User findOneByUsername(String username);
}
