/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import com.natslash.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigDecimal;

/**
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

  private ProductRepository productRepository;

  @Autowired
  public void setProductRepository(final ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Test
  public void testSaveProduct() {
    // setup product
    final Product product = new Product();
    product.setDescription("Spring Framework Guru Shirt");
    product.setPrice(new BigDecimal("18.95"));
    product.setProductId("1234");

    // save product, verify has ID value after save
    assertNull(product.getId()); // null before save
    productRepository.save(product);
    assertNotNull(product.getId()); // not null after save

    // fetch from DB
    final Product fetchedProduct = productRepository.findOne(product.getId());

    // should not be null
    assertNotNull(fetchedProduct);

    // should equal
    assertEquals(product.getId(), fetchedProduct.getId());
    assertEquals(product.getDescription(), fetchedProduct.getDescription());

    // update description and save
    fetchedProduct.setDescription("New Description");
    productRepository.save(fetchedProduct);

    // get from DB, should be updated
    final Product fetchedUpdatedProduct = productRepository.findOne(fetchedProduct.getId());
    assertEquals(fetchedProduct.getDescription(), fetchedUpdatedProduct.getDescription());

    // verify count of products in DB
    final long productCount = productRepository.count();
    assertEquals(productCount, 1);

    // get all products, list should only have one
    final Iterable<Product> products = productRepository.findAll();

    int count = 0;

    for (final Product p : products) {
      count++;
    }

    assertEquals(count, 1);
  }
}
