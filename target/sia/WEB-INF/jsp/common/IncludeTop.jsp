<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<link rel="StyleSheet" href="../css/style.css" type="text/css" media="screen" />
<title>Simple Inventory Accounting Demo</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<meta http-equiv="Cache-Control" content="max-age=0" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="Pragma" content="no-cache" />
</head>

<body>

<div class="container clearfix">
  <div class="grid12 first">
    <h1>
    <stripes:link beanclass="com.mybatis.sia.web.actions.ProductActionBean" event="viewList">
    <stripes:param name="rows" value="0" />
    Simple Inventory Accounting Demo</stripes:link> 
    </h1>
    <h2>used frameworks: ibatis, spring and stripes.</h2>
  </div>  

  <div class="topnav grid12 first">
    <stripes:link beanclass="com.mybatis.sia.web.actions.ProductActionBean" event="viewList">
    <stripes:param name="rows" value="0" />
    Browse Products </stripes:link> 
    <stripes:link beanclass="com.mybatis.sia.web.actions.ProductActionBean" event="newProductForm">
    <stripes:param name="categoryId" value="" />New Product</stripes:link> 
  </div>
  <div class="grid12 first messages">
    <stripes:messages />
  </div>  
  
    

  
  
  
