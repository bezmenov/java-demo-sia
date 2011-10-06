package com.mybatis.sia.service;

import java.util.List;

import com.mybatis.sia.domain.Product;
import com.mybatis.sia.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

  @Autowired
  private ProductMapper productMapper;


  public List<Product> getListByProduct(int rows) {
    //return null;
    return productMapper.getListByProduct(rows);
  }

  public Product getProduct(String productId) {
    return productMapper.getProduct(productId);
  }

  @Transactional
  public void insertProduct(Product product) {
    productMapper.insertProduct(product);
  }
  
  @Transactional
  public void updateProduct(Product product) {
    productMapper.updateProduct(product);
  }
    
  @Transactional
  public void deleteProduct(String productId) {
    productMapper.deleteProduct(productId);
  }
  
}
