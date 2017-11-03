package controllers;

import java.io.File;
import java.util.Collection;

import models.User;
import utils.Serializer;
import utils.XMLSerializer;

public class Main
{
	

    public static void main(String[] args) throws Exception {
    
    
    File  datastore = new File("datastore4.xml");
    Serializer serializer = new XMLSerializer(datastore);

    MovieAPI movieAPI = new MovieAPI(serializer);
    if (datastore.isFile())
    {
      movieAPI.load();
    }
	
    movieAPI.initalLoad();
    movieAPI. createUser("Ger", "O Dywer", "24", "Student", "M");
    

    Collection<User> users = movieAPI.getUsers();
    System.out.println(users);
    
    User homer = movieAPI.getUserByFirstName("Ger");
    System.out.println(homer);
    
    movieAPI.store();
    
    
    }
  
  
  
}