package controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.User;

public class MovieAPI {
	 private Map<String, User> users = new HashMap<>();
	 
	 public Collection<User> getUsers ()
	  {
	    return users.values();
	  }

	public void deleteUsers() {
		users.clear();
	}

	
	
	
	  public User createUser(String firstName, String lastName,int age, String occupation, String gender) 
	  {
	    User user = new User (firstName, lastName,age, occupation, gender);
	    users.put(firstName, user);
	    return user;
	  }

	  
	  
	  
	  public User getUser(String firstName) 
	  {
	    return users.get(firstName);
	 
	}

	  public void deleteUser(String firstName) 
	  {
	    users.remove(firstName);
	  }
	
}