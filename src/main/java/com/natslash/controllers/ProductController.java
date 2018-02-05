/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.controllers;

import com.natslash.domain.Product;
import com.natslash.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 */

@Controller
public class ProductController {

  private ProductService productService;

  @Autowired
  public void setProductService(final ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping(
      value = "/products",
      method = RequestMethod.GET)
  public String list(final Model model) {
    model.addAttribute("products", productService.listAllProducts());
    return "products";
  }

  @GetMapping(
      path = "/all-products")
  public @ResponseBody Iterable<Product> getProducts() {
    return productService.listAllProducts();
  }

  @RequestMapping("product/{id}")
  public String showProduct(@PathVariable final Integer id, final Model model) {
    model.addAttribute("product", productService.getProductById(id));
    return "productshow";
  }

  @RequestMapping("product/edit/{id}")
  public String edit(@PathVariable final Integer id, final Model model) {
    model.addAttribute("product", productService.getProductById(id));
    return "productform";
  }

  @RequestMapping("product/new")
  public String newProduct(final Model model) {
    model.addAttribute("product", new Product());
    return "productform";
  }

  @RequestMapping(
      value = "product",
      method = RequestMethod.POST)
  public String saveProduct(final Product product) {
    productService.saveProduct(product);
    return "redirect:/product/" + product.getId();
  }

  @RequestMapping("product/delete/{id}")
  public String delete(@PathVariable final Integer id) {
    productService.deleteProduct(id);
    return "redirect:/products";
  }

}
