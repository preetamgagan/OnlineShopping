package com.pg.backend.dto;

import lombok.Data;

@Data
public class CategoryDTO {

	private int id;
	private String name;
	private String description;
	private String imageUrl;
	private boolean active = true;
}
