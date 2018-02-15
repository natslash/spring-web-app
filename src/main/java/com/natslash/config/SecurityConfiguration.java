/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableGlobalMethodSecurity(
    prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  /**
   * Constructor disables the default security settings
   */
  public SecurityConfiguration() {
    super(true);
  }

  @Override
  protected void configure(final HttpSecurity httpSecurity) throws Exception {
    httpSecurity.antMatcher("/rest/**").authorizeRequests().anyRequest().authenticated();
    httpSecurity.authorizeRequests().antMatchers("/console/**").permitAll();

    httpSecurity.csrf().disable();
    httpSecurity.headers().frameOptions().disable();

  }

}
