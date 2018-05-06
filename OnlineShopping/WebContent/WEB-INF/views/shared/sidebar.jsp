<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="my-4">Cheapness</h1>
<c:forEach items="${listCatagory}" var="catagory">

	<div class="list-group">
		<a href="
		${pageContext.request.contextPath}/show/catagory/${catagory.id}/products"
		class="list-group-item" id="a_${catagory.name}">${catagory.name}</a>
	</div>
</c:forEach>