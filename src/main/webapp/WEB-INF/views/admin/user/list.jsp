<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>

<page:applyDecorator name="main">
    <page:parameter name="title" value="User List" />

    <h2>User List</h2>
    <a href="${pageContext.request.contextPath}/admin/users/create" class="btn btn-primary mb-2">New User</a>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Username</th>
            <th>Phone</th>
            <th>Fullname</th>
            <th>Email</th>
            <th>Admin</th>
            <th>Active</th>
            <th>Images</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="it" items="${items}">
            <tr>
                <td>${it.username}</td>
                <td>${it.phone}</td>
                <td>${it.fullname}</td>
                <td>${it.email}</td>
                <td>${it.admin}</td>
                <td>${it.active}</td>
                <td>${it.images}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/users/edit/${it.username}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/admin/users/delete/${it.username}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</page:applyDecorator>
