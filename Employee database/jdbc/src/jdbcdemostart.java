import java.sql.*;
public class jdbcdemostart {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String userName="root";
		String passWord="Test";
		String query="select * from employee";
			Connection con=DriverManager.getConnection(url, userName, passWord);
			// to get user name,password,link tosql database
			//drivermanager class
			Statement st=con.createStatement();// statement object
			// by use this only execute query
			ResultSet rs=st.executeQuery(query);
			rs.next();
			System.out.println("ID is"+rs.getInt(1));
			System.out.println("Name is "+rs.getString(2));
			System.out.println("Salary is"+rs.getInt(3));
		con.close();
	}

}
