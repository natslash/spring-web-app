/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.bootstrap;

import com.natslash.domain.Role;
import com.natslash.repositories.RoleRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 
 */

@Component
public class RoleLoader implements ApplicationListener<ContextRefreshedEvent> {

  private RoleRepository roleRepository;

  private final Logger log = Logger.getLogger(RoleLoader.class);

  @Autowired
  public void setUserRepository(final RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public void onApplicationEvent(final ContextRefreshedEvent event) {

    final Role role1 = new Role();
    role1.setRoleId(1L);
    role1.setRole("ADMIN");
    roleRepository.save(role1);

    log.info("Saved role1 - id: " + role1.getRoleId());

    final Role role2 = new Role();
    role2.setRoleId(2L);
    role2.setRole("USER");
    roleRepository.save(role2);

    log.info("Saved role2 - id:" + role2.getRoleId());
  }
}
