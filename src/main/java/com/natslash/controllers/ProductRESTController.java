/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.controllers;

import com.natslash.domain.Product;
import com.natslash.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 */

@Controller
@RequestMapping(
    path = "/api/")
public class ProductRESTController {

  private ProductService productService;

  @Autowired
  public void setProductService(final ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(
      path = "/products")
  public @ResponseBody Iterable<Product> getProducts() {
    return productService.listAllProducts();
  }

  @GetMapping("/product/{id}")
  public @ResponseBody Product showProduct(@PathVariable final Integer id, final Model model) {
    return productService.getProductById(id);
  }


  @PutMapping("/product/edit/{id}")
  public @ResponseBody Product edit(@PathVariable final Integer id,
      @RequestBody final Product product) {
    productService.saveProduct(product);
    return productService.getProductById(product.getId());
  }


  @DeleteMapping("product/delete/{id}")
  public @ResponseBody Product delete(@PathVariable final Integer id) {
    productService.deleteProduct(id);
    return productService.getProductById(id);
  }


  @PostMapping("/product")
  public @ResponseBody Product saveProduct(@RequestBody final Product product) {
    productService.saveProduct(product);
    return productService.getProductById(product.getId());
  }
}
