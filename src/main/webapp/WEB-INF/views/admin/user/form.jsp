<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>

<page:applyDecorator name="main">
    <page:parameter name="title" value="User Form" />

    <h2>User Form</h2>

    <form action="${pageContext.request.contextPath}/admin/users/save" method="post">
        <input type="hidden" name="username" value="${item.username}" />

        <div class="mb-3">
            <label>Username</label>
            <input class="form-control" name="username" value="${item.username}">
        </div>

        <div class="mb-3">
            <label>Password</label>
            <input class="form-control" name="password" value="${item.password}">
        </div>

        <div class="mb-3">
            <label>Phone</label>
            <input class="form-control" name="phone" value="${item.phone}">
        </div>

        <div class="mb-3">
            <label>Fullname</label>
            <input class="form-control" name="fullname" value="${item.fullname}">
        </div>

        <div class="mb-3">
            <label>Email</label>
            <input class="form-control" name="email" value="${item.email}">
        </div>

        <div class="mb-3">
            <label>Admin</label>
            <input type="checkbox" name="admin" value="true" <c:if test="${item.admin}">checked</c:if> />
        </div>

        <div class="mb-3">
            <label>Active</label>
            <input type="checkbox" name="active" value="true" <c:if test="${item.active}">checked</c:if> />
        </div>

        <div class="mb-3">
            <label>Images</label>
            <input class="form-control" name="images" value="${item.images}">
        </div>

        <button class="btn btn-success" type="submit">Save</button>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/admin/users">Back</a>
    </form>
</page:applyDecorator>
