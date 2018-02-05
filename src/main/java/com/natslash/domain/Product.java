/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * 
 */

@Entity
public class Product {
  @Id
  @GeneratedValue(
      strategy = GenerationType.AUTO)
  private Integer id;

  @Version
  private Integer version;

  private String productId;
  private String description;
  private String imageUrl;
  private BigDecimal price;

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(final String productId) {
    this.productId = productId;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(final String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(final BigDecimal price) {
    this.price = price;
  }
}
