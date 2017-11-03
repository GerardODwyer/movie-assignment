package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllers.MovieAPI;
import static models.Fixtures.users;
import static models.Fixtures.activities;
import static models.Fixtures.locations;

public class MovieApiTest {


	
	{
		  private MovieAPI pacemaker;

		  @Before
		  public void setup()
		  {
		    pacemaker = new MovieAPI();
		    for (User user : users)
		    {
		      Movie.createUser(user.firstName, user.lastName,user.age, user.occupation, user.gender);
		    }
		  }

		  @After
		  public void tearDown()
		  {
		    pacemaker = null;
		  }

		  @Test
		  public void testUser()
		  {
		    assertEquals (users.length, Movie.getUsers().size());
		    Movie.createUser("Bob", "Bobby",52, "clerk", "male");
		    assertEquals (users.length+1, Movie.getUsers().size());
		    assertEquals (users[0], Movie.getUserByfirstName(users[0].firstName));
		  }  

		  @Test
		  public void testUsers()
		  {
		    assertEquals (users.length, Movie.getUsers().size());
		    for (User user: users)
		    {
		      User eachUser = Movie.getUserByfirstName(user.firstName);
		      assertEquals (user, eachUser);
		      assertNotSame(user, eachUser);
		    }
		  }

		  @Test
		  public void testDeleteUsers()
		  {
		    assertEquals (users.length, Movie.getUsers().size());
		    User marge = Movie.getUserByfirstName("Ross");
		    Movie.deleteUser(Ross.id);
		    assertEquals (users.length-1, pacemaker.getUsers().size());    
		  }  
		  
		  @Test
		  public void testAddActivity()
		  {
		    User marge = pacemaker.getUserByEmail("marge@simpson.com");
		    Activity activity = pacemaker.createActivity(marge.id, activities[0].type, activities[0].location, activities[0].distance);
		    Activity returnedActivity = pacemaker.getActivity(activity.id);
		    assertEquals(activities[0],  returnedActivity);
		    assertNotSame(activities[0], returnedActivity);
		  }
		  
		  @Test
		  public void testAddActivityWithSingleLocation()
		  {
		    User marge = pacemaker.getUserByEmail("marge@simpson.com");
		    Long activityId = pacemaker.createActivity(marge.id, activities[0].type, activities[0].location, activities[0].distance).id;

		    pacemaker.addLocation(activityId, locations[0].latitude, locations[0].longitude);

		    Activity activity = pacemaker.getActivity(activityId);
		    assertEquals (1, activity.route.size());
		    assertEquals(0.0001, locations[0].latitude,  activity.route.get(0).latitude);
		    assertEquals(0.0001, locations[0].longitude, activity.route.get(0).longitude);   
		  }
		  
		  @Test
		  public void testAddActivityWithMultipleLocation()
		  {
		    User marge = pacemaker.getUserByEmail("marge@simpson.com");
		    Long activityId = pacemaker.createActivity(marge.id, activities[0].type, activities[0].location, activities[0].distance).id;

		    for (Location location : locations)
		    {
		      pacemaker.addLocation(activityId, location.latitude, location.longitude);      
		    }

		    Activity activity = pacemaker.getActivity(activityId);
		    assertEquals (locations.length, activity.route.size());
		    int i = 0;
		    for (Location location : activity.route)
		    {
		      assertEquals(location, locations[i]);
		      i++;
		    }
		  } 
		}
