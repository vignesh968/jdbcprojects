import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
private static final String url="jdbc:mysql://localhost:3306/studentschoolds";
private static final String userName="root";
private static final String  password="Vicky@2611";
public static Connection getConnection() throws SQLException{
	 return DriverManager.getConnection(url, userName, password);
}
}
