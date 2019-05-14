
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="vendor" value="/resources/vendor" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
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
	window.menu = "${title}";
	window.contextRoot = "${contextRoot}"
</script>

<!-- Bootstrap core CSS -->
<link href="${vendor }/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap DataTable-->
<link href="${css }/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- Bootstrap theme -->
<%-- <link href="${css}/bootstrap-theme.min.css" rel="stylesheet"> --%>

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
			role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Home</a>
				</div>
			</div>
		</nav>


		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="jumbotron">
							<h1>${errorTitle}</h1>
							<hr />
							<blockquote style="word-wrap:break-word">${errorDescription}</blockquote>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

	</div>
</body>

</html>