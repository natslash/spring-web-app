/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(
    prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(final HttpSecurity httpSecurity) throws Exception {
    httpSecurity.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST, "/rest/api/**")
        .hasRole("ADMIN").antMatchers(HttpMethod.PUT, "/rest/api/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.PATCH, "/rest/api/**").hasRole("ADMIN").and().csrf().disable();
    httpSecurity.authorizeRequests().antMatchers("/console/**").permitAll();

    httpSecurity.csrf().disable();
    httpSecurity.headers().frameOptions().disable();

  }

  @Autowired
  public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN").and()
        .withUser("user").password("user").roles("USER");
  }

}
