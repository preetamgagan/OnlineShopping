package com.pg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pg.backend.dao.CategoryDao;
import com.pg.backend.dao.ProductDao;
import com.pg.backend.entity.Category;
import com.pg.backend.entity.Product;
import com.pg.exception.ProductNotFoundException;


@Controller
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	/**
	 * This method is used to display home page
	 * @return
	 */
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		logger.info("Info: PageController.index():: started");
		logger.debug("Debug: PageController.index():: started");
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","Home");
		mav.addObject("categories",categoryDao.listCategory());
		mav.addObject("userClickHome",true);
		logger.info("PageController.index():: Ended");
		logger.debug("Debug: PageController.index():: ended");
		return mav;
	}
	/**
	 * This method is used to display about us page
	 * @return
	 */
	@RequestMapping(value="/about")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title","About Us");
		mav.addObject("userClickAbout",true);
		return mav;
	}
	/**
	 * This method is used to display contact us page
	 * @return
	 */
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
	
	/**
	 * This method is used to show a single products
	 */
	@RequestMapping("show/{id}/product")
	public ModelAndView showProductById(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mav = new ModelAndView("page");

		//call dao class method to get product by its id
		Product product = productDao.get(id);
		if(product == null) throw new ProductNotFoundException();
		//update the view count
		product.setViews(product.getViews()+1);
		productDao.update(product);
		
		mav.addObject("title",product.getName());
		mav.addObject("product",product);
		mav.addObject("userClickShowProduct",true);
		return mav;
	}
}
