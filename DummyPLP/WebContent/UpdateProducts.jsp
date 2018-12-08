<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Products</title>
</head>
<body>
<table border = 1>
<b:form action = "ProductUpdate?product_id=P001" method="POST" modelAttribute="yy">
<tr> 
<th> Product Name </th>
<th> Product Id </th>
<th> Description </th>
<th> Category </th>
<th> Merchant </th>
<th> Price </th>
<th> Quantity </th>
<th> Subcategory </th>
<th> </th>
</tr>
<a:forEach var = "pro" items ="${data}">
<tr> 
<td> ${pro.product_name} </td>
<td> ${pro.product_id} </td>
<td> ${pro.product_descr} </td>
<td> ${pro.category_id} </td>
<td> ${pro.merchant_id} </td>
<td> ${pro.price} </td>
<td> ${pro.quantity} </td>
<td> ${pro.subcategory_id} </td>
<td> <input type="submit" value="update">
</tr>
</a:forEach>
</b:form>
</table>
</body>
</html>