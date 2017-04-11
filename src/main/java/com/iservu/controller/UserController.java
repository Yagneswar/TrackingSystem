package com.iservu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import com.iservu.dao.UserDAO;
import com.iservu.daoImpl.UserDAOImpl;
import com.iservu.model.User;

@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	User user;

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers()
	{
		
		log.debug("Starting of method getAllUsers ");
		List<User> users = userDAO.list();
		if (users.isEmpty()) 
		{
			
		}
		log.debug("Ending of method getAllUsers ");
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserDetails(@PathVariable("id") String id) 
	{
		
		log.debug("Starting of method getUserDetails");
		
		user=userDAO.get(id);
		if (user == null)
		{
			 user=new User();
			

		}

		log.debug("ending of method getUserDetails");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/validate/", method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User user, HttpSession session) {
		
		log.debug("Starting of method login ");
		user=userDAO.isValidUser(user.getId(), user.getPassword());
		if (user == null) 
		{
			user=new User();
			

		}

		else
		{
			user.setIsonline('Y');
			userDAO.update(user);
			session.setAttribute("loggedInUserID", user.getId());
		}

		log.debug("Ending of method login ");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/logout/", method = RequestMethod.GET)
	public ResponseEntity<User> logout(HttpSession session) 
	{
		log.debug("Starting of method logout ");
		user.setIsonline('N');
		
		session.invalidate();

		if (userDAO.update(user))
		{
			
		}
		else 
		{
			
		}
		
		log.debug("Ending of method logout ");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/register/", method = RequestMethod.POST)
	public ResponseEntity<User> register(@RequestBody User user)
	{
		log.debug("Starting of method register ");
		if (userDAO.get(user.getId()) != null) 
		{
			
		} 
		else 
		{
			if (userDAO.save(user)) 
			{
				
			}
			else
			{
				
			}
		}
		
		log.debug("Ending of method register ");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/accept/{Id}", method = RequestMethod.GET)
	public ResponseEntity<User> accept(@PathParam("Id") String Id)
	{
		log.debug("Starting of method accept ");
		
		user=updateStatus(Id,'A',"");
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/reject/{Id}/{reason}", method = RequestMethod.GET)
	public ResponseEntity<User> reject(@PathParam("Id") String Id,@PathParam("reason") String reason)
	{
		user=updateStatus(Id,'R',reason);
		return new ResponseEntity<User>(user, HttpStatus.OK);

		
	}
	
	private User updateStatus(String Id, char status, String reason)
	{

		user=userDAO.get(Id);
		
		if(user==null)
		{
			user=new User();
			
		}
		else
		{
			user.setStatus(status);
			user.setReason(reason);
		}
		return user;
	}
}
