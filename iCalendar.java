package icalendar;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Brian
 *
 */

public class iCalendar {
	public static void main(String[] args) throws IOException {
		eventMaker Event = new eventMaker(); // Uses the eventMaker class to help get the information for the event and make the .ics file.
		Scanner input = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		boolean loop = true;
		boolean run = true;
		String answer3;
		
		Scanner scanner = new Scanner(System.in);
		// OPTIONAL classification of the file
		  do {

		      System.out.println("+------------------------+");
		      System.out.println("|      -Main Menu-       |");
		      System.out.println("|  [1] Make New Event    |");
		      System.out.println("|  [2] Import .ics File  |");
		      System.out.println("|  [3] Edit .ics File    |");
		      System.out.println("|  [4] Clear Screen      |");
		      System.out.println("|  [5] Exit              |");
		      System.out.println("+------------------------+");
		      System.out.print("\nEnter your selection: ");
			
		      String mainMenu = scanner.next();
		      switch (mainMenu) {
				case "1":
						list.add(scheduleEvent(Event));
						outputEvent(Event); // outputs the information into an .ics file
						break;
		        case "2":
						list.add(importFiles());
						outputEvent(Event); // outputs the information into an .ics file
						System.out.println("Invalid input, needs y or n");
		          break;
		        case "4":
		          iCalendar.clearScreen();
		          break;
		        case "5":
		          System.out.println("Exiting Event Calendar Creator...");
		          run = false;
		          System.out.println(list);
		          input.close();
		          System.exit(1);
		          break;
		        default:
		          System.out.println("-Invalid selection-\n");
		          break;
		      }
		    } while (run);
			System.out.println(list);
			input.close();
		  }		

	

	public static String scheduleEvent(eventMaker inputEvent) {
		String startTime;
		String endTime;
		String month;
		String day;
		String year;
		String date;
		String description;
		String location;
		String name;
		String position;
		String position1;
		String answer;
		String classification;
		String filename;

		int answer2;


		Double longitude;
		Double latitude;

		Scanner input = new Scanner(System.in);

		System.out.println("Enter File Name:");

		filename = input.nextLine() + ".ics";
		inputEvent.filename(filename);
		
		//EDIT FOR INCORRECT INPUT. IE if start time input length wasn't 6 or between 000000-240000.
		// input for the date of the event
		System.out.println("Event MONTH (Format MM):");
		month = input.nextLine();
		System.out.println("Event DAY (Format DD):");
		day = input.nextLine();
		System.out.println("Event YEAR (Format YYYY):");
		year = input.nextLine();

		// Start and end time of the event
		System.out.println("Start time of the event (000000 - 240000:");
		startTime = input.nextLine();
		inputEvent.dateTimeStart(startTime);

		System.out.println("End time of the event (000000 - 240000:");
		endTime = input.nextLine();
		inputEvent.dateTimeEnd(endTime);

		// input for the event description
		System.out.println("Event Description:");
		description = input.nextLine();
		inputEvent.description(description);

		// Formats the date to look like the one in the .ics file
		date = year + month + day;
		inputEvent.dateTimeStart(date + 'T' + startTime + 'Z');
		inputEvent.dateTimeEnd(date + 'T' + endTime + 'Z');

		// Location of event
		System.out.println("The location:");
		location = input.nextLine();
		inputEvent.location(location);

		// input for the name of event or SUMMARY
		System.out.println("Name of Event:");
		name = input.nextLine();
		inputEvent.name(name);

		Scanner scanner = new Scanner(System.in);
		// OPTIONAL classification of the file
		System.out.println("Pick the classification that you want: Private, Public, Confidential or Skip");
		String op = scanner.next();

		switch (op) {
		case "Private":
		case "private":
			System.out.println("Setting to Private" + "\n");
			classification = "PRIVATE";
			inputEvent.classification(classification);
			break;
		case "public":
		case "Public":
			System.out.println("Setting to Public" + "\n");
			classification = "PUBLIC";
			inputEvent.classification(classification);
			break;
		case "Confidential":
		case "confidential":
			System.out.println("Setting to Confidential" + "\n");
			classification = "CONFIDENTIAL";
			inputEvent.classification(classification);
			break;
		case "Skip":
		case "skip":
			System.out.println("Classification skipped setting to Public");
			classification = "PUBLIC";
			inputEvent.classification(classification);
			break;
		default:
			System.out.println("Setting to Public" + "\n");
			classification = "PUBLIC";
			inputEvent.classification(classification);
			break;
		}

		System.out.println("OPTIONAL: Would like to put your Geographic Location (1 - Yes 2 - No)");
		answer2 = input.nextInt();
		if (answer2 > 0 && answer2 < 2) {
			// int classInput = input.nextInt();
			switch (answer2) {
			case 1:

				System.out.println("What is your latitude?");
				latitude = input.nextDouble();
				System.out.println("What is your longitude?");
				longitude = input.nextDouble();
				position = Double.toString(latitude) + ";" + Double.toString(longitude);
				position1 = Double.toString(latitude) + " degrees Latitude" + " AND " + Double.toString(longitude)
						+ " degrees longitude.";
				inputEvent.geoLocation(position);
				System.out.println("The Position you inputted is: " + position1 + "\n");
				break;

			// close input only because it's the last input.
			case 2:
				System.out.println("Skipped adding a Geographical Location");
				break;
			default:
				System.out.println("Skipped adding a Geographical Location");
				break;

			}

		}
		return filename;

	}
	

	public static void outputEvent(eventMaker eventMaker) {
		String calendarDetails;

		calendarDetails = "BEGIN:VCALENDAR\n" 
				+ "PRODID:-" + eventMaker.returnProdid() + "\n" 
				+ "VERSION:2.0\n"
				+ "CALSCALE:GREGORIAN\n" 
				+ "METHOD:PUBLISH\n" 
				+ "X-WR-CALNAME:blogan7@hawaii.edu\n"
				+ "X-WR-TIMEZONE:Pacific/Honolulu\n" 
				+ "BEGIN:VEVENT\n" 
				+ "DTSTART:" + eventMaker.returnDateTimeStart() + "\n" 
				+ "DTEND:" + eventMaker.returnDateTimeEnd() + "\n" 
				+ "DTSTAMP:20160221T214356Z\n"
				+ "UID:p5jn8goqda616apkjm2rfhcoq0@google.com\n" 
				+ "CREATED:20160221T214344Z\n" 
				+ "DESCRIPTION:" + eventMaker.returnDescription() + "\n" 
				+ "LAST-MODIFIED:20160221T214344Z\n" 
				+ "LOCATION:" + eventMaker.returnLocation() + "\n" 
				+ "SEQUENCE:0\n" 
				+ "STATUS:CONFIRMED\n" 
				+ "SUMMARY:" + eventMaker.returnName() + "\n" 
				+ "CLASS:" + eventMaker.returnclassification() + "\n" 
				+ "GEO:" + eventMaker.returnGeoLocation() + "\n" 
				+ "TRANSP:OPAQUE\n" 
				+ "END:VEVENT\n"
				+ "END:VCALENDAR\n";

		try {
			// Creates an iCal.ics file provided with the info above
			BufferedWriter outPut = new BufferedWriter(new FileWriter(new File(eventMaker.returnFilename() + ".ics")));
			outPut.write(calendarDetails);
			outPut.close();

		}

		// catches if no file had been made
		catch (IOException e) {
			System.out.println("No file found");

		}

	}
	
		public static void clearScreen() {
		    for (int i = 30; i > 0; i--){
		      System.out.println();
		    }
		}
	
	public static String importFiles() throws IOException{
		
		System.out.println("Write the name of the file:");
		Scanner scanner2 = new Scanner(System.in);
		String fName = scanner2.next();


		BufferedReader br = new BufferedReader(new FileReader(fName));
		
		System.out.println(fName);

		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();

		    }
		    String everything = sb.toString();
			System.out.println(everything);

		} finally {
			
		    br.close();
		}
		return fName;
		
	}
}
