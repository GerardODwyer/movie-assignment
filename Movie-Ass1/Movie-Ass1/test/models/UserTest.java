package models;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

import static models.Fixtures.users;

public class UserTest
{
  User bob = new User ("Bob", "Bobby", 52, "clerk", "male");

  @Test
  public void testCreate()
  {
    assertEquals ("Bob",                Bob.firstName);
    assertEquals ("Bobby",             Bob.lastName);
    assertEquals (52,                          Bob.age);
    assertEquals ("clerk",           Bob.occupation);   
    assertEquals ("gender",               Bob.gender);   
  }

  @Test
  public void testIds()
  {
    Set<Long> ids = new HashSet<>();
    for (User user : users)
    {
      ids.add(user.id);
    }
    assertEquals (users.length, ids.size());
  }

  @Test
  public void testToString()
  {
    assertEquals ("User{" + Bob.id + ", Bob, Bobby,52, clerk,male}", Bob.toString());
  }
  @Test
  public void testEquals()
  {
    User homer2 = new User ("Bob", "Bobby",52, "clerk",  "male"); 
    User bart   = new User ("Beth", "Smith",52 "maid",  "female"); 

    assertEquals(Bob, Bob);
    assertEquals(Bob, Bob2);
    assertNotEquals(Bob, Beth);
  } 
}