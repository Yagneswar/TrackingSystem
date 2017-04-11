package com.iservu.dao;

import java.util.List;

import com.iservu.model.Blog;


public interface BlogDAO {
	
	List<Blog> getAllBlogs();// In order to fetch all the Blogs
	Blog getBlog(String id);// In order to fetch a particular blog on the basis of id
	

}
