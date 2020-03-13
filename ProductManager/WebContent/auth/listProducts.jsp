<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="/header.jsp" %>

<h3>Liste des produits</h3>
<div class="table-responsive">
    <table class="table">
        <thead>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Category</th>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="p">
            <tr>
                <td><c:out value="${p.id}"/></td>
                <td><c:out value="${p.name}"/></td>
                <td><c:out value="${p.description}"/></td>
                <td><c:out value="${p.price}"/></td>
                <td><c:out value="${p.category}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="/footer.jsp" %>