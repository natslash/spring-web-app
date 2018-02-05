/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.services;

import com.natslash.domain.Product;
import com.natslash.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 */

@Service
public class ProductServiceImpl implements ProductService {
  private ProductRepository productRepository;

  @Autowired
  public void setProductRepository(final ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Iterable<Product> listAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product getProductById(final Integer id) {
    return productRepository.findOne(id);
  }

  @Override
  public Product saveProduct(final Product product) {
    return productRepository.save(product);
  }

  @Override
  public void deleteProduct(final Integer id) {
    productRepository.delete(id);
  }
}
