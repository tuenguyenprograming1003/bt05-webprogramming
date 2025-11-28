<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>

<page:applyDecorator name="main">
    <page:parameter name="title" value="Category List" />

    <h2>Category List</h2>
    <a href="${pageContext.request.contextPath}/admin/categories/create" class="btn btn-primary mb-2">New Category</a>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Code</th>
            <th>Status</th>
            <th>User</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${items}">
            <tr>
                <td>${c.categoryId}</td>
                <td>${c.categoryName}</td>
                <td>${c.categoryCode}</td>
                <td>${c.status}</td>
                <td><c:out value="${c.user != null ? c.user.username : ''}" /></td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/categories/edit/${c.categoryId}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/admin/categories/delete/${c.categoryId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</page:applyDecorator>
