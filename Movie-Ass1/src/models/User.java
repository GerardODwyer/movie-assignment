package models;

import static com.google.common.base.MoreObjects.toStringHelper;
import com.google.common.base.Objects;

public class User 
{
  public String firstName;
  public String lastName;
  public int age;
  public String occupation;
  public String gender;
  
  public User()
  {
  }
  
  public User(String firstName, String lastName, int age, String occupation, String gender)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.occupation = occupation;
    this.occupation = gender;
  }
  @Override
  public String toString()
  {

    return toStringHelper(this).addValue(firstName)
                               .addValue(lastName)
                               .addValue(age)
                               .addValue(occupation) 
                               .addValue(gender) 
                               .toString();
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.lastName, this.firstName, this.age, this.occupation, this.gender);  
  }
  
}