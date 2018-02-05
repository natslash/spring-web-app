/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.services;

import com.natslash.domain.Product;

/**
 * 
 */

public interface ProductService {
  Iterable<Product> listAllProducts();

  Product getProductById(Integer id);

  Product saveProduct(Product product);

  void deleteProduct(Integer id);
}
