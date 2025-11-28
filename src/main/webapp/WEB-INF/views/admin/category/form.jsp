<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>

<page:applyDecorator name="main">
    <page:parameter name="title" value="Category Form" />

    <h2>Category Form</h2>

    <form action="${pageContext.request.contextPath}/admin/categories/save" method="post">
        <input type="hidden" name="categoryId" value="${item.categoryId}" />

        <div class="mb-3">
            <label>Name</label>
            <input class="form-control" name="categoryName" value="${item.categoryName}">
        </div>

        <div class="mb-3">
            <label>Code</label>
            <input class="form-control" name="categoryCode" value="${item.categoryCode}">
        </div>

        <div class="mb-3">
            <label>Images</label>
            <input class="form-control" name="images" value="${item.images}">
        </div>

        <div class="mb-3">
            <label>Status</label>
            <input type="checkbox" name="status" <c:if test="${item.status}">checked</c:if> />
        </div>

        <div class="mb-3">
            <label>User</label>
            <select name="user.username" class="form-select">
                <c:forEach var="u" items="${users}">
                    <option value="${u.username}"
                        <c:if test="${item.user != null && item.user.username == u.username}">selected</c:if>>
                        ${u.username}
                    </option>
                </c:forEach>
            </select>
        </div>

        <button class="btn btn-success" type="submit">Save</button>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/admin/categories">Back</a>
    </form>
</page:applyDecorator>
