<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink"><stripes:link
	beanclass="com.mybatis.sia.web.actions.ProductActionBean"
	event="viewProduct">
	<stripes:param name="productId" value="${actionBean.product.productId}" />
	Reload data for product[${actionBean.product.productId}]
</stripes:link></div>

<table>
	<tr>
		<td>Product ID:</td>	
		<td><b> ${actionBean.product.productId} </b></td>
	</tr>
	<tr>
		<td>Category:</td>
		<td><b> ${actionBean.product.category} </b></td>
	</tr>
	<tr>
		<td>Name:</td>
		<td><b> ${actionBean.product.name} </b></td>
	</tr>
	<tr>
		<td>Descrition:</td>
		<td><b>${actionBean.product.description}</b></td>
	</tr>
	<tr>
		<td>Amount:</td>
		<td><b> ${actionBean.product.amnt} </b></td>
	</tr>
	<tr>
		<td></td>
	  <td><stripes:link
		  beanclass="com.mybatis.sia.web.actions.ProductActionBean"
		  event="updateProductForm">
		  <stripes:param name="productId" value="${actionBean.product.productId}" />
		  Change amount
	  </stripes:link></td>
	</tr>
</table>

<%@ include file="../common/IncludeBottom.jsp"%>



