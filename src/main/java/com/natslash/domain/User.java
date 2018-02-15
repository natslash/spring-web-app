/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(
    name = "users")
public class User implements UserDetails {

  static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(
      strategy = GenerationType.AUTO)
  @Column(
      name = "user_id",
      nullable = false,
      updatable = false)
  private Long id;

  @Column(
      name = "username",
      nullable = false,
      unique = true)
  private String username;

  @Column(
      name = "password",
      nullable = false)
  private String password;

  @Column(
      name = "enabled",
      nullable = false)
  private boolean enabled;

  @ManyToMany(
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER)
  @JoinTable(
      name = "user_role",
      joinColumns = @JoinColumn(
          name = "user_id"),
      inverseJoinColumns = @JoinColumn(
          name = "role_id"))
  private Set<Role> roles;

  public User() {}

  /**
   * @param username
   * @param password
   * @param enabled
   * @param roles
   */
  public User(final User user) {
    super();
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.enabled = user.isEnabled();
    this.roles = user.getRoles();
  }



  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
   */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
        .collect(Collectors.toList());
  }

  /**
   * Get the id value.
   * 
   * @return The id value.
   */
  public Long getId() {
    return id;
  }

  /**
   * Set the id value.
   *
   * @param id The id value to set.
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * Set the username value.
   *
   * @param username The username value to set.
   */
  public void setUsername(final String username) {
    this.username = username;
  }

  /**
   * Set the password value.
   *
   * @param password The password value to set.
   */
  public void setPassword(final String password) {
    this.password = password;
  }

  /**
   * Set the enabled value.
   *
   * @param enabled The enabled value to set.
   */
  public void setEnabled(final boolean enabled) {
    this.enabled = enabled;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
   */
  @Override
  public String getPassword() {
    return password;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
   */
  @Override
  public String getUsername() {
    return username;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
   */
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
   */
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
   */
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
   */
  @Override
  public boolean isEnabled() {
    return enabled;
  }



  /**
   * Get the roles value.
   * 
   * @return The roles value.
   */
  public Set<Role> getRoles() {
    return roles;
  }



  /**
   * Set the roles value.
   *
   * @param roles The roles value to set.
   */
  public void setRoles(final Set<Role> roles) {
    this.roles = roles;
  }

}
