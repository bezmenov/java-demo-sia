<%@ include file="../common/IncludeTop.jsp"%>

<div id="Product">
<stripes:form
	beanclass="com.mybatis.sia.web.actions.ProductActionBean"
	focus="">
	<h3>Product Information</h3>
	<table>
		<tr>
			<td>Product ID:</td>
			<td><b>${actionBean.product.productId}</b></td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><b>${actionBean.product.name}</b></td>
		</tr>
		<tr>
			<td>Category:</td>
			<td><b>${actionBean.product.category}</b></td>
		</tr>
	  <tr>
		  <td>Descrition:</td>
		  <td><b>${actionBean.product.description}</b></td>
	  </tr>
		<tr>
			<td>Amount:</td>
			<td><stripes:text name="product.amnt" /></td>
		</tr>
	</table>
	<stripes:submit name="updateProduct" value="Update amount" />
</stripes:form>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
