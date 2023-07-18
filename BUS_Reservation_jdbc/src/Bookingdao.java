import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;



public class Bookingdao {
public int getbookedcount(int busno,Date date)throws SQLException
{
	String query="select count(passenger_name) from booking where bus_no=? and travel_date=?";
	Connection con=Dbconnection.getConnection(); 
	PreparedStatement pStatement=con.prepareStatement(query);
	java.sql.Date sqlDate=new java.sql.Date(date.getTime());
	pStatement.setInt(1, busno);
	pStatement.setDate(2, sqlDate);
	ResultSet rs=pStatement.executeQuery();
	rs.next();
	return rs.getInt(1);
}
public void addbooking(Booking booking)throws SQLException{
String query="insert into booking values(?,?,?)";
	Connection con=Dbconnection.getConnection(); 
	
	java.sql.Date sqlDate=new java.sql.Date(booking.date.getTime());
PreparedStatement pst=con.prepareStatement(query);
	pst.setString(1,booking.passanger_name);
	pst.setInt(2, booking.busno);
pst.setDate(3, sqlDate);
pst.executeUpdate();

}
}
