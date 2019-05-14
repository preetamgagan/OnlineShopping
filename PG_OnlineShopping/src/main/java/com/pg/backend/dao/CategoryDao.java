package com.pg.backend.dao;

import java.util.List;

import com.pg.backend.entity.Category;


public interface CategoryDao {

	public Category get(int id);
	
	public List<Category> listCategory();
	
	public boolean addCategory(Category category);

	public boolean updateCategory(Category category);

	public boolean deleteCategory(Category category);
}
