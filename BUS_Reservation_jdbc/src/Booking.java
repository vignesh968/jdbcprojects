import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

public class Booking {
String passanger_name;
int busno;
Date date;
Booking()
{
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter a passanger name : ");
	passanger_name=scanner.next();
	System.out.println("Enter a bus no :");
	busno=scanner.nextInt();
	System.out.println("Enter date dd-mm-yyyy");
	String dateinput=scanner.next();
	SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
	try {
		date=dateFormat.parse(dateinput);
	} catch (ParseException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
	scanner.close();
}
public boolean isAvailable() throws SQLException{

	  Busdao busdao=new Busdao();
	  Bookingdao bookingdao=new Bookingdao(); 
	  int capacity=busdao.getcapacity(busno);
	  int booked=bookingdao.getbookedcount(busno,date);
	  return booked<capacity;
}
}
