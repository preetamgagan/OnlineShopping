package com.pg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pg.backend.dao.CategoryDao;
import com.pg.backend.dao.CategoryDaoImpl;
import com.pg.backend.entity.Category;


@Controller
public class PageController {
	
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","Home");
		mav.addObject("categories",categoryDao.listCategory());
		mav.addObject("userClickHome",true);
		return mav;
	}
	@RequestMapping(value="/about")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","About Us");
		mav.addObject("userClickAbout",true);
		return mav;
	}
	@RequestMapping(value= "contact")
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","Contact Us");
		mav.addObject("userClickContact",true);
		return mav;
	}
	
	/*
	 * method to load all the products based on the category
	 */
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","All Products");
		mav.addObject("categories",categoryDao.listCategory());
		mav.addObject("userClickAllProducts",true);
		return mav;
	}
	/*
	 * method to load the products based on the product id
	 */
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView showProducByCategoryId(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("page");
		//category dao to fetch the single category
		Category category = null;
		//call dao class method
		category = categoryDao.get(id);
		mav.addObject("title",category.getName());
		//passing the list of categories
		mav.addObject("categories",categoryDao.listCategory());
		//passing a single category
		mav.addObject("category",category);
		mav.addObject("userClickCategoryProducts",true);
		return mav;
	}
}
