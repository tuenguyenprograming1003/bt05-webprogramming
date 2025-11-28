<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>

<page:applyDecorator name="main">
    <page:parameter name="title" value="Video Form" />

    <h2>Video Form</h2>

    <form action="${pageContext.request.contextPath}/admin/videos/save" method="post">
        <input type="hidden" name="videoId" value="${item.videoId}" />

        <div class="mb-3">
            <label>Title</label>
            <input class="form-control" name="title" value="${item.title}">
        </div>

        <div class="mb-3">
            <label>Poster</label>
            <input class="form-control" name="poster" value="${item.poster}">
        </div>

        <div class="mb-3">
            <label>Views</label>
            <input class="form-control" name="views" value="${item.views}">
        </div>

        <div class="mb-3">
            <label>Description</label>
            <textarea class="form-control" name="description">${item.description}</textarea>
        </div>

        <div class="mb-3">
            <label>Category</label>
            <select name="category.categoryId" class="form-select">
                <c:forEach var="c" items="${categories}">
                    <option value="${c.categoryId}" <c:if test="${item.category != null && item.category.categoryId == c.categoryId}">selected</c:if>>
                        ${c.categoryName}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label>Active</label>
            <input type="checkbox" name="active" <c:if test="${item.active}">checked</c:if> />
        </div>

        <button class="btn btn-success" type="submit">Save</button>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/admin/videos">Back</a>
    </form>
</page:applyDecorator>
