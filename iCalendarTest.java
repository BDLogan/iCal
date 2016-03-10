package icalendar;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * 
 * @author Brian
 *
 */


public class iCalendarTest {
    
    eventMaker test = new eventMaker();
    String latitude;
    String longitude;
    String classification;
	
  @Test
  public void testGeoLocation() {
      latitude = "74.23";
      longitude = "32.94";
      test.geoLocation(latitude + ";" + longitude);
      assertEquals("74.23;32.94", test.returnGeoLocation());
  }
  
  @Test
  public void testClassification(){
      classification = "Public";
      test.classification(classification);
      assertEquals("Public", test.returnclassification());
  }
}