 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="vendor" value="/resources/vendor" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping-${title}</title>

<script>
	window.menu="${title}";
</script>

<!-- Bootstrap core CSS -->
<link href="${vendor }/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- Bootstrap theme -->
<%-- <link href="${css}/bootstrap-theme.min.css" rel="stylesheet"> --%>

</head>

<body>
<div class="wrapper">
	<!-- Navigation -->
	<%@include file="./shared/header.jsp"%>

<div class="content">
	<!-- Page Content -->
	<!-- Loading the home content -->
	<c:if test="${userClickHome==true}">
	<%@include file="home.jsp" %>
	</c:if>
	<!-- Loading the about us content -->
	<c:if test="${userClickAbout==true}">
	<%@include file="about.jsp" %>
	</c:if>
	<!-- Loading the contact us content -->
	<c:if test="${userClickContact==true}">
	<%@include file="contact.jsp" %>
	</c:if>
	<!-- Loading the listProducts content -->
	<c:if test="${userClickAllProducts==true or userClickCategoryProducts == true}">
	<%@include file="listProducts.jsp" %>
	</c:if>
</div>
	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="${vendor }/jquery/jquery.min.js"></script>
	<script src="${vendor }/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${js }/myapp.js"></script>

</div>
</body>

</html>