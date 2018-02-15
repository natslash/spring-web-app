/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.repositories;

import com.natslash.domain.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * @param <Role>
 * 
 */

public interface RoleRepository extends CrudRepository<Role, Long> {
  Role findOneByRole(String role);
}
