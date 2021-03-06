<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List Of Products</h1>
	<div class="container">
		<div class="row">
			<!-- to display sidebar -->
			<div class="col-md-3">
				<%@ include file="./shared/sidebar.jsp"%>
			</div>
			<!-- To display actual products -->
			<div class="col-md-9">
				<!-- Added BreadCrump component 	 -->
				<div class="row">

					<div class="col-lg-12">

						<c:if test="${userClickAllProducts==true}">

							<script>
								window.categoryId = '';
							</script>
							<ol class="breadcrumb">
								<li><a href="${contextRoot}/home">Home</a></li>
								<li class="active">All Products</li>
							</ol>
						</c:if>
						<c:if test="${userClickCategoryProducts==true}">
							<script>
								window.categoryId = "${category.id}";
							</script>

							<ol class="breadcrumb">
								<li><a href="${contextRoot}/home">Home</a></li>
								<li class="active">Category</li>
								<li class="active">${category.name}</li>
							</ol>
						</c:if>
					</div>

				</div>

				<div class="row">

					<div class="col-md-12">

						<table id="productListTable"
							class="table table-striped table-borderd">

							<thead>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Brand</th>
									<th>Price</th>
									<th>Qty.Available</th>
									<th></th>
								</tr>

							</thead>
							<tfoot>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Brand</th>
									<th>Price</th>
									<th>Qty.Available</th>
									<th></th>
								</tr>

							</tfoot>

						</table>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>