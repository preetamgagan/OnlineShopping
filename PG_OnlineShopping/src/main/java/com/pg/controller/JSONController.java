package com.pg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pg.backend.dao.ProductDao;
import com.pg.backend.entity.Product;

@Controller
@RequestMapping(path="/json/data")
public class JSONController {
	
	@Autowired
	private ProductDao dao;

	@RequestMapping(path="/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		return dao.listActiveProducts();
	}
	
	/*@RequestMapping(path="category/{categoryId}/products")
	@ResponseBody
	public List<Product> getCategoryProducts(@PathVariable("categoryId") int categoryId){
		return dao.listActiveProductsByCategory(categoryId);
	}*/
	
	@RequestMapping("/category/{id}/product")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {
		
		return dao.listActiveProductsByCategory(id);
				
	}
}
