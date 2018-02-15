/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.bootstrap;

import com.natslash.domain.Role;
import com.natslash.domain.User;
import com.natslash.repositories.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 */

@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

  private UserRepository userRepository;

  private final Logger log = Logger.getLogger(UserLoader.class);

  @Autowired
  public void setUserRepository(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void onApplicationEvent(final ContextRefreshedEvent event) {

    final Role role1 = new Role();
    role1.setRoleId(1L);
    role1.setRole("ADMIN");

    final Role role2 = new Role();
    role2.setRoleId(2L);
    role2.setRole("USER");

    final Set<Role> roles = new TreeSet<Role>();
    roles.add(role1);
    final User user1 = new User();
    user1.setId(1L);
    user1.setUsername("peter@example.com");
    user1.setPassword("$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri");
    user1.setEnabled(true);
    user1.setRoles(roles);
    userRepository.save(user1);

    log.info("Saved user1 - id: " + user1.getId());

    roles.remove(role1);
    roles.add(role2);
    final User user2 = new User();
    user2.setId(2L);
    user2.setUsername("john@example.com");
    user2.setPassword("$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri");
    user2.setEnabled(true);
    user2.setRoles(roles);
    userRepository.save(user2);

    log.info("Saved user2 - id:" + user2.getId());

    roles.remove(role2);
    roles.add(role1);
    final User user3 = new User();
    user3.setId(3L);
    user3.setUsername("katie@example.com");
    user3.setPassword("$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri");
    user3.setEnabled(true);
    user3.setRoles(roles);
    userRepository.save(user3);

    log.info("Saved user3 - id:" + user3.getId());
  }
}
