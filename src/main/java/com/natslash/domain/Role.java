/**
 * Copyright 2018 Shashidhara Subramanyam.
 */

package com.natslash.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @param <T>
 * 
 */

@Entity
@Table(
    name = "role")
public class Role implements Comparable<Role> {

  @Id
  @GeneratedValue(
      strategy = GenerationType.AUTO)
  @Column(
      name = "role_id")
  private Long roleId;

  @Column(
      name = "role")
  private String role;

  private static boolean sortByRoleId = true;

  public Role() {}

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(final Long roleId) {
    this.roleId = roleId;
  }

  public String getRole() {
    return role;
  }

  public void setRole(final String role) {
    this.role = role;
  }

  /**
   * Get the sortByRoleId value.
   * 
   * @return The sortByRoleId value.
   */
  public static boolean isSortByRoleId() {
    return sortByRoleId;
  }

  /**
   * Set the sortByRoleId value.
   *
   * @param sortByRoleId The sortByRoleId value to set.
   */
  public static void setSortByRoleId(final boolean sortByRoleId) {
    Role.sortByRoleId = sortByRoleId;
  }

  @Override
  public int compareTo(final Role otherRole) {
    if (sortByRoleId)
      return roleId.compareTo(otherRole.getRoleId());
    else
      return role.compareTo(otherRole.role);
  }
}
