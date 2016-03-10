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
	String month;
	String day;
	String year;
	String time;
	String bday;
	String description;
	String location;
	String name;
	String latitude;
	String longitude;
	String classification;


	// Tests the datestarttime
	@Test
	public void testDateTimeStart() {
		month = "12";
		day = "24";
		year = "1993";
		time = "000001";
		bday = month + day + year;
		test.dateTimeStart(bday + "T" + time + "Z");
		assertEquals("12241993T000001Z", test.returnDateTimeStart());

	}

	@Test
	public void testDateTimeEnd() {
		month = "12";
		day = "24";
		year = "1993";
		time = "240000";
		bday = month + day + year;
		test.dateTimeEnd(bday + "T" + time + "Z");
		assertEquals("12241993T240000Z", test.returnDateTimeEnd());

	}

	@Test
	public void testDescription() {
		description = "Birthday Party";
		test.description(description);
		assertEquals("Birthday Party", test.returnDescription());
	}

	@Test
	public void testLocation() {
		location = "Okinawa";
		test.location(location);
		assertEquals("Okinawa", test.returnLocation());
	}
	
	@Test
	public void testName() {
		name = "Birthday";
		test.name(name);
		assertEquals("Birthday", test.returnName());
	}

	@Test
	public void testGeoLocation() {
		latitude = "125.72";
		longitude = "25.66";
		test.geoLocation(latitude + ";" + longitude);
		assertEquals("125.72;25.66", test.returnGeoLocation());
	}

	@Test
	public void testClassification() {
		classification = "Public";
		test.classification(classification);
		assertEquals("Public", test.returnclassification());
	}
}