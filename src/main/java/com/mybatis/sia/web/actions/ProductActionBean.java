package com.mybatis.sia.web.actions;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SessionScope;
import net.sourceforge.stripes.integration.spring.SpringBean;


import com.mybatis.sia.domain.Product;
import com.mybatis.sia.service.ProductService;
import java.math.BigInteger;
@SessionScope
public class ProductActionBean extends AbstractActionBean {

  private static final long serialVersionUID = 5849523372175050635L;

  private static final String MAIN = "/WEB-INF/jsp/product/Main.jsp";
  private static final String VIEW_CATEGORY = "/WEB-INF/jsp/product/ProductList.jsp";
  private static final String VIEW_PRODUCT = "/WEB-INF/jsp/product/Product.jsp";
  private static final String VIEW_NEWPRODUCT = "/WEB-INF/jsp/product/NewProductForm.jsp";  
  private static final String VIEW_EDITPRODUCT = "/WEB-INF/jsp/product/EditProductForm.jsp";  

  @SpringBean
  private transient ProductService ProductService;

  private String keyword;

  private String productId;
  private int  rows = 0;  
  private List<Product> productList;
  private Product product = new Product();
  
  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }
  public void setRows(int rows) {
    this.rows = rows;
  }
  public int getRows() {
    return rows;
  }
  public int getNext() {
    return rows+5;
  }

  public int getPrev() {
    if( (rows -5) <=0)
      return 0;
    else
      return rows-5;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public List<Product> getProductList() {
    return productList;
  }

  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

  @DefaultHandler
  public ForwardResolution viewMain() {
    return new ForwardResolution(MAIN);
  }

  public ForwardResolution viewList() {

    setMessage("List of products");
    productList = ProductService.getListByProduct(rows);
    return new ForwardResolution(VIEW_CATEGORY);
  }

  public ForwardResolution viewProduct() {
    setMessage("Product details");
    product = ProductService.getProduct(productId);
    return new ForwardResolution(VIEW_PRODUCT);
  }

  public ForwardResolution newProductForm() {
    setMessage("Add new product");
    return new ForwardResolution(VIEW_NEWPRODUCT);
  }

  public Resolution newProduct() {
    Product productExist = null;
    productExist = ProductService.getProduct( this.getProduct().getProductId());  
    if( productExist != null) {
      setMessage("<div class='error'>Product with ID "+this.getProduct().getProductId()+" exists!</div>");    
      return new ForwardResolution(VIEW_NEWPRODUCT);      
    }
    if( !this.validateProduct( this.getProduct())) {
      return new ForwardResolution(VIEW_NEWPRODUCT);      
    }    
    
    
    
    ProductService.insertProduct(product);
    setMessage("Product with ID "+this.getProduct().getProductId()+" was saved successfully!");    
    product = ProductService.getProduct(this.getProduct().getProductId());
    return new ForwardResolution(VIEW_PRODUCT);
  }
  
  public ForwardResolution updateProductForm() {
    setMessage("Edit product's amount");
    product = ProductService.getProduct(productId);
    return new ForwardResolution(VIEW_EDITPRODUCT);
  }

  public Resolution updateProduct() {
    if( this.product.getAmnt() == null ||
        this.product.getAmnt().intValue() < 0 ||
        this.product.getAmnt().intValue() > 1000) {
      setMessage("Amount value must be [0..1000]!");
      return new ForwardResolution(VIEW_EDITPRODUCT);
    }
    ProductService.updateProduct(product);
    setMessage("Amount is updated to "+product.getAmnt());
    product = ProductService.getProduct(productId);
    return new ForwardResolution(VIEW_PRODUCT);
  }
  
  public Resolution deleteProduct() {
    ProductService.deleteProduct(productId);
    setMessage("Record is deleted!");
    productList = ProductService.getListByProduct(rows);
    return new ForwardResolution(VIEW_CATEGORY);
  }
  
  public void clear() {
    keyword = null;
    rows    = 0;
    productId = null;
    product = null;
    productList = null;
  }
  public boolean validateProduct( Product pProduct) {
    boolean ret = true;
    if( pProduct.getProductId() == null ||
        pProduct.getProductId().length() > 10) {
      setMessage("Product ID length must be not more than 10 chars!");
      ret = false;
    }    
    if( pProduct.getCategory() == null ||
        pProduct.getCategory().length() > 10) {
      setMessage("Category length must be not more than 10 chars!");
      ret = false;
    }    
    if( pProduct.getName() == null ||
        pProduct.getName().length() > 80) {
      setMessage("Category length must be not more than 80 chars!");
      ret = false;
    }    
    if( pProduct.getDescription() == null ||
        pProduct.getDescription().length() > 80) {
      setMessage("Description length must be not more than 255 chars!");
      ret = false;
    }    
    if( pProduct.getAmnt() == null ||
        pProduct.getAmnt().intValue() < 0 ||
        pProduct.getAmnt().intValue() > 1000) {
      setMessage("Amount value must be [0..1000]!");
      ret = false;
    }    
      
    return ret;  
  }

}
