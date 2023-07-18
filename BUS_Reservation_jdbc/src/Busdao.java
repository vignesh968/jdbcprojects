import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Busdao {
	
public void	displaybusInfo() throws SQLException{
	String query="select * from bus";
	Connection con=Dbconnection.getConnection();	
	Statement statement=con.createStatement();
	ResultSet rs=statement.executeQuery(query);
	while (rs.next()) {
		System.out.print("Bus No : "+rs.getInt(1));
		if(rs.getInt(2)==0)
		{
			System.out.print(" AC :NO");
		}
		else {
			System.out.print(" AC :YES");
		}
		System.out.print(" Capacity: "+rs.getInt(3)+"\n");

	}	System.out.println("------------------------------------");
}
public int getcapacity(int id)throws SQLException {
	String query="select capacity from bus where id= "+id;
	Connection con=Dbconnection.getConnection(); 
	Statement statement=con.createStatement();
	ResultSet rs=statement.executeQuery(query);
	rs.next();
	return rs.getInt(1);
}
}
