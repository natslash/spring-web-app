/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import com.natslash.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

  private UserRepository userRepository;

  @Autowired
  public void setProductRepository(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Test
  public void testSaveUser() {
    final User user = new User();
    user.setId(1L);
    user.setUsername("peter@example.com");
    user.setPassword("$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri");
    user.setEnabled(true);

    // save user, verify has ID value after save
    userRepository.save(user);
    assertNotNull(user.getId()); // not null after save

    // fetch from DB
    final User fetchedUser = userRepository.findOne(user.getId());

    // Should not be null
    assertNotNull(fetchedUser);

    // should equal
    assertEquals(user.getId(), fetchedUser.getId());
    assertEquals(user.getUsername(), fetchedUser.getUsername());

    // verify count of users in DB
    final long userCount = userRepository.count();
    assertEquals(3, userCount);

    // get all users, list should only have one
    final Iterable<User> users = userRepository.findAll();

    int count = 0;

    for (final User u : users) {
      System.out.println(u.toString());
      count++;
    }

    assertEquals(3, count);


  }

}
