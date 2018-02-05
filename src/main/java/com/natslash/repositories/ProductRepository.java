/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.repositories;

import com.natslash.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 */

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
