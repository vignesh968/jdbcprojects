import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.exceptions.RSAException;

public class studentdao {
private String st_id ;
private String st_name;
private int st_class ;
//private int roll_no;
private String address;
private String sc_name;


public String getSt_id() {
	return st_id;
}
public void setSt_id(String st_id) {
	this.st_id = st_id;
}
public String getSt_name() {
	return st_name;
}
public void setSt_name(String st_name) {
	this.st_name = st_name;
}
public int getSt_class() {
	return st_class;
}
public void setSt_class(int st_class) {
	this.st_class = st_class;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getSc_name() {
	return sc_name;
}
public void setSc_name(String sc_name) {
	this.sc_name = sc_name;
}

public void addstudent()throws SQLException{
	Connection connection=Dbconnection.getConnection();
	Scanner scanner=new Scanner(System.in);
	String check="select sc_name from school ";
	//String classstr="select class_std from class";
	System.out.println("please Enter your school name: ");
	 sc_name=scanner.nextLine();
	Statement statement=connection.createStatement();
	ResultSet rs=statement.executeQuery(check);
	//ResultSet rs2=statement.executeQuery(classstr);
	int y=0;
	int h=0;
	while (rs.next()) {
		if(rs.getString(1).equals(sc_name)) {
			y=1;
		
		}
		}
	if(y==1)
	{
		System.out.println("please Enter your student id: ");
		 st_id=scanner.next();
		 System.out.println("please Enter  your name: ");
		 st_name=scanner.next();
		 System.out.println("please Enter your class: ");
		 st_class=scanner.nextInt();
		 System.out.println("please Enter your address: ");
		 address=scanner.next();
	String query="insert into students values(?,?,?,?,?)";
	PreparedStatement pst=connection.prepareStatement(query);
	pst.setString(1, st_id);
	pst.setString(2, st_name);
	pst.setInt(3, st_class);
	pst.setString(4, address);
	pst.setString(5, sc_name);
	int rows=pst.executeUpdate();
	System.out.println("Number of row affected "+rows);
	System.out.println("------------------------------------------");
	}
	else
		 {
			 System.out.println("please Enter vaild school name!------");
	 }
//connection.close();

}
public void displaystudent()throws SQLException{
	Connection con=Dbconnection.getConnection();
	String query="select * from students";
	Statement statement=con.createStatement();
	ResultSet rowResultSet=statement.executeQuery(query);
	while(rowResultSet.next())
	{
		System.out.print("st_id: "+rowResultSet.getString(1));
		System.out.print("\tst_name: "+rowResultSet.getString(2));
	System.out.print("\tclass: "+rowResultSet.getString(3));
	System.out.print("\tvillage: "+rowResultSet.getString(4));
	System.out.print("\t school_name: "+rowResultSet.getString(5));
	System.out.println();
	}
	con.close();
}
public void deletestudent()throws SQLException{
Scanner scanner=new Scanner(System.in);
	Connection connection=Dbconnection.getConnection();
System.out.println("please Enter id to delete  details");
int id=scanner.nextInt();
String queryString="delete from students where st_id="+id;
Statement statement=connection.createStatement();
int row=statement.executeUpdate(queryString);
System.out.println("number of rows affected"+ row);
	connection.close();
}
}