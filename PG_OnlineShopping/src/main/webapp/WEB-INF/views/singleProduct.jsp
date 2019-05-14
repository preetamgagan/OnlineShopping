<div class="container">

	<!-- BreadCrump -->
	<div class="row">
	
		<div class="col-lg-12">
		
			<ol class="breadcrumb">
			
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
			
			</ol>
		
		</div>	
	
	</div>
	<div class="row">
	
		<!-- Display Product Image -->
		<div class="col-xs-12 col-lg-5">
		
			<div class="thumbnail">
			
				<img src="${images}/${product.code}.jpg" class="viewImg"/>
			
			</div>
		
		</div>
		<!-- Display Product details -->
		<div class="col-xs-12 col-lg-7">
		
			<h3>${product.name}</h3>
			<hr/>
			<p>${product.description}</p>
			<hr/>
			<h4>Price: <strong> &#8377; ${product.unitPrice} /-</strong></h4>
			<hr/>
			<c:choose>
				<c:when test="${product.quantity<1}">
					<h6>Quantity Available: <span style="color:red">Out Of Stock!</span></h6>
				</c:when>
				<c:otherwise>
					<h6>Quantity Available: ${product.quantity}</h6>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${product.quantity<1}">
					<a href = "javascript:void(0)" class="btn btn-success disabled"><strike>
					<span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</strike></a>
				</c:when>
				<c:otherwise>
					<a href = "${contextRoot}/cart/add/${productId}/product" class="btn btn-success">
					<span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a>
				</c:otherwise>
			</c:choose>
			<a href = "${contextRoot}/show/all/products" class="btn btn-success">
			Back</a>
		</div>
	
	</div>

</div>