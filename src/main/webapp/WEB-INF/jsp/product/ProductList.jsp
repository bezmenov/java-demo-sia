<%@ include file="../common/IncludeTop.jsp"%>

<table id="hor-minimalist-a">
	<tr>
		<th>Product ID</th>
		<th>Category</th>
		<th>Name</th>
		<th>Amnt</th>
		<th></th>
		<th></th>
	</tr>
	<c:forEach var="row" items="${actionBean.productList}">
		<tr>
			<td><stripes:link
				beanclass="com.mybatis.sia.web.actions.ProductActionBean"
				event="viewProduct">
				<stripes:param name="productId" value="${row.productId}" />
				${row.productId}
			</stripes:link></td>
			<td>${row.category}</td>
			<td>${row.name}</td>
			<td>${row.amnt}</td>
			<td><stripes:link
				beanclass="com.mybatis.sia.web.actions.ProductActionBean"
				event="updateProductForm">
				<stripes:param name="productId" value="${row.productId}" />
				Change amount
			</stripes:link></td>
			<td><stripes:link
				beanclass="com.mybatis.sia.web.actions.ProductActionBean"
				event="deleteProduct">
				<stripes:param name="productId" value="${row.productId}" />
				Delete
			</stripes:link></td>
		</tr>
	</c:forEach>
</table>
<stripes:link beanclass="com.mybatis.sia.web.actions.ProductActionBean" event="viewList">
<stripes:param name="rows" value="${actionBean.prev}" />
Prev</stripes:link> 
<stripes:link beanclass="com.mybatis.sia.web.actions.ProductActionBean" event="viewList">
<stripes:param name="rows" value="${actionBean.next}" />
Next</stripes:link> 

<%@ include file="../common/IncludeBottom.jsp"%>


