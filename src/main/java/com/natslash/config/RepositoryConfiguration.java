/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(
    basePackages = {"com.natslash.domain"})
@EnableJpaRepositories(
    basePackages = {"com.natslash.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
