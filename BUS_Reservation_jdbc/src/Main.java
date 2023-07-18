import java.sql.SQLException;
import java.util.*;


public class Main {

	public static void main(String[] args)throws SQLException  {
		Busdao busdao=new Busdao();
//		try {
		busdao.displaybusInfo(); 
	int useropt=1; 
	Scanner scanner=new Scanner(System.in);
	while (useropt==1) 
	{
		System.out.println("Enter 1 to BOOK and 2 to Exist");
		useropt=scanner.nextInt();
		if(useropt==1)
		{
			Booking booking=new Booking();
			if(booking.isAvailable())
			{
				Bookingdao bookingdao=new Bookingdao();
				bookingdao.addbooking(booking);
				System.out.println("Your booking is comfirmed  ");
			}
			else 
			
				System.out.println("Sorry , bus is full ,try another bus or date ");
			
		}
	}
		scanner.close();
//}
//	
//	catch(Exception e)
//		{
//		System.out.println(e);
//		}
	}

}
 