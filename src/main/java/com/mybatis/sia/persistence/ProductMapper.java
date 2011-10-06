package com.mybatis.sia.persistence;

import java.util.List;
import java.util.Map;

import com.mybatis.sia.domain.Product;

public interface ProductMapper {

  List<Product> getListByProduct(int rows);

  Product getProduct(String productId);

  void insertProduct(Product product);

  void updateProduct(Product product);  

  void deleteProduct(String productId);    
}
