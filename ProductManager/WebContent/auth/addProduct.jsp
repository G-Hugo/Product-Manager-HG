
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@include file="/header.jsp" %>

<form action="/auth/addProduct" method="post">
    <br><h3 id="name">Name :</h3><br>
    <input type="text" name="name">
    <br>Description :<br>
    <input type="text" name="description">
    <br>Price :<br>
    <input type="number" step="0.01" name="price">

    <br> Category: <br>
    <select name="category">
        <c:forEach items="${categorys}" var="category">
            <option value="<c:out value="${category.id}"/>"><c:out value="${category.name}"/></option>
        </c:forEach>
    </select>
    <input type="submit" value="ok">
</form>

<%@include file="/footer.jsp" %>