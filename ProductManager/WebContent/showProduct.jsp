<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Show Product</title>
</head>
<body>
<%@include file="/header.jsp"%>
<p>
    <c:set var="product" value="${requestScope.get('product')}"></c:set>
    <c:out value="${product.category.name}"></c:out>
    <c:out value="${product.name}"></c:out>
    <c:out value="${product.description}"></c:out>
    <c:out value="${product.price}"></c:out>

</p>
<%@include file="/footer.jsp"%>
</body>
</html>