import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class schooldao {
	public void display() throws SQLException{
String query1="select * from school";
Connection con=Dbconnection.getConnection();
Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(query1);
	while(rs.next()) {
	System.out.println("school_id : "+rs.getInt(1)+" , "+"School_Name : "+rs.getString(2)+" , "+"School_Address : "+rs.getString(3));
	}
	con.close();}
public void adddatabase() throws SQLException{
	Scanner scanner=new Scanner(System.in);
	Connection con=Dbconnection.getConnection(); 
	System.out.println( "please Enter a school_id: ");
	int id=scanner.nextInt();
	System.out.println("please Enter school name:");
	String sc_name=scanner.next();
	System.out.println("please Enter sc_address:");
	String sc_address=scanner.next();
	String query1="insert into  school values(?,?,?)";
	PreparedStatement pStatement=con.prepareStatement(query1);
	pStatement.setInt(1, id);
	pStatement.setString(2, sc_name);
	pStatement.setString(3, sc_address);
	pStatement.executeUpdate();
}
public void deletedata()throws SQLException{
	Scanner s=new Scanner(System.in);
	System.out.println("please enter your id");
	int id=s.nextInt();
	String query="delete from school where sc_id="+id;
	Connection connection=Dbconnection.getConnection();
	Statement t=connection.createStatement();
	int row=t.executeUpdate(query);
	System.out.println("Number of affected "+row);	
	connection.close();
}

}
