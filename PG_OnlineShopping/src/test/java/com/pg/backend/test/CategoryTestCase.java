package com.pg.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pg.backend.dao.CategoryDao;
import com.pg.backend.entity.Category;
import com.pg.backend.util.HibernateUtils;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDao categoryDao;
	
	private static Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.pg.backend");
		context.refresh();
		
		categoryDao = (CategoryDao) context.getBean("categoryDao") ;
	}
	
	/*@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Dummy");
		category.setDescription("This is some description about dummy");
		category.setImageUrl("CAT_6.png");
		
		assertEquals("Successfully added the category inside the table", true,categoryDao.addCategory(category));
	}
	*/
	/*@Test
	public void testGetCategoty() {
		category = categoryDao.get(3);
		assertEquals("Successfully fetched a single category", "Camera", category.getName());
	}*/
	
	
	/*@Test
	public void updateCategoryTest() {
		category = categoryDao.get(1);
		category.setDescription("Laptop is an electronic device");
		category.setName("Lapi");
		
		assertEquals("Successfully updated a single category", true, categoryDao.updateCategory(category));
	}
	*/
	
	/*@Test
	public void deleteCategoryTest() {
		category = categoryDao.get(7);
		assertEquals("Successfully deleted a single category", true, categoryDao.deleteCategory(category));
	}*/
	
	/*@Test
	public void listCategoryTest() {
		assertEquals("Successfully fetched the list of category", 5, categoryDao.listCategory().size());
	}*/
	
	@Test
	public void CURDCategoryTest() {
		
		//Adding new category to the table
		category = new Category();
		category.setName("Car");
		category.setDescription("This is some description about car");
		category.setImageUrl("CAT_8.png");
		assertEquals("Successfully added the category inside the table", true,categoryDao.addCategory(category));
	
		//fetching and updating the category from the table
		category = categoryDao.get(8);
		category.setDescription("six seater car available");
		category.setName("Racing Car");
		assertEquals("Successfully updated a single category", true, categoryDao.updateCategory(category));
	
		category = categoryDao.get(4);
		category.setActive(true);
		assertEquals("Successfully updated a single category", true, categoryDao.updateCategory(category));
	
		//deleting the category
		category = categoryDao.get(7);
		assertEquals("Successfully deleted a single category", true, categoryDao.deleteCategory(category));

		//fetching all active category
		assertEquals("Successfully fetched the list of category", 7, categoryDao.listCategory().size());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
