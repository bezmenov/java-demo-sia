package com.mybatis.sia.domain;

import java.io.Serializable;
import java.math.BigInteger;

public class Product implements Serializable {

  private static final long serialVersionUID = -2159121673445254631L;

  private String productId;
  private String category;
  private String name;
  private String description;
  private BigInteger amnt;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId.trim();
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category.trim();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name.trim();
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description.trim();
  }

  public BigInteger getAmnt() {
    return amnt;
  }

  public void setAmnt(BigInteger amnt) {
    this.amnt = amnt;
  }

  public String toString() {
    return "(" + getProductId() + ")";
  }

}
