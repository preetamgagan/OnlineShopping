package com.pg.backend.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pg.backend.dto.CategoryDTO;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	private static List<CategoryDTO> categories = new ArrayList<>();
	static {
		CategoryDTO category = new CategoryDTO();
		// adding first category
		category.setId(1);
		category.setName("Mobiles");
		category.setDescription("This is Mobile");
		category.setImageUrl("Cat1.png");
		categories.add(category);

		// adding Second category
		category.setId(2);
		category.setName("Telivision");
		category.setDescription("This is Telivision");
		category.setImageUrl("Cat2.png");
		categories.add(category);

		// adding Third category
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is Laptop");
		category.setImageUrl("Cat3.png");
		categories.add(category);
	}

	@Override
	public List<CategoryDTO> list() {

		return categories;
	}

	@Override
	public CategoryDTO get(int id) {
		//using enhanced for loop
		for(CategoryDTO category : categories) {
			if(category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
