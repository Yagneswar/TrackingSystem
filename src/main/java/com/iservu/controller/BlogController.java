package com.iservu.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iservu.dao.BlogDAO;
import com.iservu.model.Blog;

@RestController
public class BlogController {

	@Autowired
	BlogDAO blogDAO;
	
	
	/*
	 * static List<Blog> blogs;
	 * 
	 * static { blogs=populateDummyBlogs(); }
	 */

	@RequestMapping(value = "/allblog", method = RequestMethod.GET)
	@ResponseBody
	public List<Blog> displayAllBlogs() {

		
		
		System.out.println(blogDAO.getAllBlogs());
		return blogDAO.getAllBlogs();
		// return blogDAO.getAllBlogs();

	}
	/*
	 * private static List<Blog> populateDummyBlogs(){ List<Blog> blogs = new
	 * ArrayList<Blog>(); blogs.add(new Blog("1", "NY", "sam@abc.com"));
	 * blogs.add(new Blog("2", "ALBAMA", "tomy@abc.com")); blogs.add(new
	 * Blog("2", "NEBRASKA", "kelly@abc.com")); return blogs; }
	 * 
	 */

}
