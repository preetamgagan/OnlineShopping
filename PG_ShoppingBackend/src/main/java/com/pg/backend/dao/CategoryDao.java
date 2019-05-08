package com.pg.backend.dao;

import java.util.List;

import com.pg.backend.dto.CategoryDTO;

public interface CategoryDao {

	public List<CategoryDTO> list();
	
	public CategoryDTO get(int id);

}
