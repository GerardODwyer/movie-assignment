package controllers;

import java.io.IOException;
import java.util.Collection;

import models.User;

public class Main
{
	
  public static void main(String[] args) throws IOException
  {    
    MovieAPI movieAPI = new MovieAPI();

    movieAPI.createUser("lance", "hardwood", 12, "stripper", "apache attack helicopter");
    movieAPI.createUser("beth", "Smith",34, "hamburgerler", "universe-kin");
    movieAPI.createUser("Lisa", "Simpson",21, "cannable", "roof shingle-kin");


    Collection<User> users = movieAPI.getUsers();
    System.out.println(users);
  }
  
  
  
}