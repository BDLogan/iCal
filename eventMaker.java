package icalendar;

public class eventMaker {
	private String prodid;
	private String name;
	private String dateTimeStart;
	private String dateTimeEnd;
	private String location;
	private String description;
	private String geoLocation;
	private String classification;
	private String filename;

	public eventMaker() {
		prodid("- Forgot Team name // Event Maker");
		dateTimeStart(toString());
		dateTimeEnd(toString());
		description(toString());
		location(toString());
		name(toString());
		geoLocation(toString());
		classification(toString());
		filename(toString());
	}

	public void prodid(String prodid) {
		this.prodid = prodid;
	}

	public void dateTimeStart(String startTime) {
		this.dateTimeStart = startTime;
	}

	public void dateTimeEnd(String dateTimeEnd) {
		this.dateTimeEnd = dateTimeEnd;
	}

	public void description(String description) {
		this.description = description;
	}

	public void location(String location) {
		this.location = location;
	}

	public void name(String name) {
		this.name = name;
	}

	public void geoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	public void classification(String classification) {
		this.classification = classification;
	}


	public void filename(String filename) {
		this.filename = filename;
		
	}

	/***********************************
	 * Returns the event details       *
	 ***********************************/

	public String returnProdid() {
		return prodid;
	}

	public String returnDateTimeStart() {
		return dateTimeStart;
	}

	public String returnDateTimeEnd() {
		return dateTimeEnd;
	}

	public String returnDescription() {
		return description;
	}

	public String returnLocation() {
		return location;
	}

	public String returnName() {
		return name;
	}

	public String returnclassification() {
		return classification;
	}

	public String returnGeoLocation() {
		return geoLocation;
	}

	public String returnFilename() {
		return filename;
		
	}


}