package com.pg.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pg.backend.dao.ProductDao;
import com.pg.backend.entity.Product;

public class ProductCURDTest {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDao productDao;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.pg.backend");
		context.refresh();
		productDao = (ProductDao) context.getBean("productDao");
	}
	
	/*@Test
	public void testCURDProduct() {
		
		product = new Product();
		product.setName("Vivo Selfie v6");
		product.setBrand("Vivo");
		product.setDescription("Selfie with music");
		product.setUnitPrice(10000);
		product.setQuantity(15);
		product.setActive(true);
		product.setSupplierId(3);
		product.setCategoryId(3);
		
		assertEquals("Something went wrong while inserting products",true,productDao.add(product));
	}*/
	/*@Test
	public void getProductsById() {
		assertEquals("Something went wrong while retrieving product","apple",productDao.get(1).getBrand());
		
	}*/
	
	@Test
	public void getProductsById() {
		Product product = productDao.get(1);
		product.setQuantity(0);
		productDao.update(product);
		assertEquals("Something went wrong while retrieving product",0,productDao.get(1).getQuantity());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
