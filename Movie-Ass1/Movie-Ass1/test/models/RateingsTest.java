package models;

import org.junit.Test;

public class RateingsTest 
	{ 
		  @Test
		  public void testCreate()
		  {
		    assertEquals (0.01, 23.3f, Rateings[0].latitude);
		    assertEquals (0.01, 33.3f, Rateings[0].longitude);
		  }

		  @Test
		  public void testIds()
		  {
		    assertNotEquals(Rateings[0].id, Rateings[1].id);
		  }

		  @Test
		  public void testToString()
		  {
		    assertEquals ("Location{" + Rateings[0].id + ", 23.3, 33.3}", Rateings[0].toString());
		  }
		}