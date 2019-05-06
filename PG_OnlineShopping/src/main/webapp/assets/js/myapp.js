$(function(){
	//solving the actice menu problem
	switch(menu){
		
	case "About Us" :
		$("#about").addClass("active");
		break;
	
	case "Contact Us" :
		$("#contact").addClass("active");
		break;
	
	case "View Products" :
		$("#listProducts").addClass("active");
		break;
		
	case "Home" :
		$("#home").addClass("active");
		break;
	
	}
	
	
	
})