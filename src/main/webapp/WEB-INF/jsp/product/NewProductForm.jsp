<%@ include file="../common/IncludeTop.jsp"%>

<div id="Product">
<stripes:form
	beanclass="com.mybatis.sia.web.actions.ProductActionBean"
	focus="">
	<h3>Product Information</h3>
	<table>
		<tr>
			<td>Product ID:</td>
			<td><stripes:text name="product.productId" /></td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><stripes:text name="product.name" /></td>
		</tr>
		<tr>
			<td>Category:</td>
			<td><stripes:text name="product.category" /></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><stripes:text name="product.description" /></td>
		</tr>		
		<tr>
			<td>Amount:</td>
			<td><stripes:text name="product.amnt" /></td>
		</tr>
	</table>
	<stripes:submit name="newProduct" value="Save Product Information" />
</stripes:form>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
