package icalendar;


import java.io.*;
import java.util.Scanner;
import icalendar.eventMaker;

/**
 * 
 * @author Brian
 *
 */

public class iCalendar
{
   public static void main(String[] args)
   {
     
      eventMaker Event = new eventMaker(); //Uses the eventMaker class to help get the information for the event and make the .ics file.
      scheduleEvent(Event); //Gets the information for the event
      outputEvent(Event);  //outputs the information into an .ics file  
   }

   public static void scheduleEvent(eventMaker inputEvent)
   {
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
    
     int answer2;
     
     Double longitude;
     Double latitude;


     Scanner input = new Scanner(System.in);
     
     // input for the date of the event
     System.out.println("Event MONTH (Format MM):");
     month = input.nextLine();
     System.out.println("Event DAY (Format DD):");
     day = input.nextLine();
     System.out.println("Event YEAR (Format YYYY):");
     year = input.nextLine();
     
     //Start and end time of the event
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
     
     //Formats the date to look like the one in the .ics file
     date = year + month + day; 
     inputEvent.dateTimeStart(date + 'T' + startTime + 'Z');
     inputEvent.dateTimeEnd(date + 'T' + endTime + 'Z');
     
     //Location of event
     System.out.println("The location:");
     location = input.nextLine();
     inputEvent.location(location);
          
     // input for the name of event or SUMMARY
     System.out.println("Name of Event:");
     name = input.nextLine();
     inputEvent.name(name);
     
     Scanner scanner = new Scanner(System.in);
    //OPTIONAL classification of the file
     System.out.println("Pick the classification that you want: Private, Public, Confidential or Skip" );
     String op = scanner.next();
     
     switch(op){
       case "Private":
         System.out.println("Setting to Private" + "\n");
      	 classification = "PRIVATE";
         inputEvent.classification(classification);
         break;
       case "private":
         System.out.println("Setting to Private" + "\n");
    	 classification = "PRIVATE";
         inputEvent.classification(classification);
         break;
       case "public":
         System.out.println("Setting to Public" + "\n");  
      	 classification = "PUBLIC";
         inputEvent.classification(classification);
         break;
       case "Public":
         System.out.println("Setting to Public" + "\n");      	   
    	 classification = "PUBLIC";
         inputEvent.classification(classification);
         break;
       case "Confidential":
         System.out.println("Setting to Confidential" + "\n");    
    	 classification = "CONFIDENTIAL";
         inputEvent.classification(classification);
         break;
       case "confidential":
         System.out.println("Setting to Confidential" + "\n");     
    	 classification = "CONFIDENTIAL";
         inputEvent.classification(classification);
         break;
       case "Skip":
         System.out.println("Classification skipped setting to Public");
         classification = "PUBLIC";
         inputEvent.classification(classification);
         break;
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
     if(answer2 > 0 && answer2 < 2){
       //int classInput = input.nextInt();
       switch(answer2){
       case 1:

         System.out.println("What is your latitude?");
         latitude = input.nextDouble();
    	 System.out.println("What is your longitude?");
         longitude = input.nextDouble();
         position = Double.toString(latitude) + ";" + Double.toString(longitude);
         position1 = Double.toString(latitude) + " degrees Latitude" + " AND " + Double.toString(longitude) + " degrees longitude.";
         inputEvent.geoLocation(position);
         System.out.println("The Position you inputted is: " + position1 + "\n");
         break;
         
       // close input only because it's the last input.   
       case 2:
    	 System.out.println("Skipped adding a Geographical Locaation");
    	 input.close();
         break;
       default:
    	 System.out.println("Skipped adding a Geographical Locaation");
    	 input.close();
    	 break;
     
       }
       }
     input.close();
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
			//Creates an iCal.ics file provided with the info above
			BufferedWriter outPut = new BufferedWriter(new FileWriter(new File("iCal.ics")));
			outPut.write(calendarDetails);
			outPut.close();
	   
		}

		// catches if no file had been made
		catch (IOException e) {
			System.out.println("No file found");

		}
		
   }
}