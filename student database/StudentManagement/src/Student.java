import java.sql.*;
import java.util.Scanner;
public class Student {

	public static void main(String[] args) throws Exception {
//recoreddatabase();
//	insertdatabase();
	//insertpst();
		//updaterecord();
	spdata();
	}
public static void recoreddatabase()throws Exception{
	// TODO Auto-generated method stub
	String url="jdbc:mysql://localhost:3306/Studentds";
	String username="root";
	String password="Vicky@2611";
	String query="select * from studentdata";
	Connection con=DriverManager.getConnection(url, username, password);
	Statement st=con.createStatement();
	ResultSet rt=st.executeQuery(query);
while (rt.next()) {
	System.out.println("Student id : "+rt.getInt(1));
	System.out.println("student Name: "+rt.getString(2));
	System.out.println("School Name: "+rt.getString(3));
	System.out.println("Address: "+rt.getString(4));	}	
rt.close();
}
public static void insertdatabase() throws Exception{
	// TODO Auto-generated method stub
	String url="jdbc:mysql://localhost:3306/Studentds";
	String username="root";
	String password="Vicky@2611";
	String query="insert into studentdata values (2,'raja','stfms','padalur')";
	Connection con=DriverManager.getConnection(url, username, password);
	Statement st=con.createStatement();
	int rows=st.executeUpdate(query);
System.out.println("number of rows affected "+rows);
recoreddatabase();

}
public static void insertpst()throws Exception{
	Scanner s=new Scanner(System.in);
	String url="jdbc:mysql://localhost:3306/Studentds";
	String username="root";
	String password="Vicky@2611";
	System.out.println("Enter a student id: ");
	int id=s.nextInt();
	System.out.println("Enter a student Name: ");
	String st_name=s.next();
	System.out.println("Enter a school Name: ");
	String school_name=s.next();
	System.out.println("Enter a Address: ");
	String address=s.next();
	System.out.println("insert the data by preparestatement");
	String query="insert into studentdata values (?,?,?,?)";
	Connection con=DriverManager.getConnection(url, username, password);
	PreparedStatement pst=con.prepareStatement(query);
	pst.setInt(1,id);
	pst.setString(2, st_name);
	pst.setString(3, school_name);
	pst.setString(4, address);
	int rows=pst.executeUpdate();
System.out.println("number of rows affected "+rows);
	
	  System.out.println("-----------insert by pst ------------------------");
recoreddatabase();
}
public static void updaterecord() throws Exception {
	Scanner s=new Scanner(System.in);
	String url="jdbc:mysql://localhost:3306/Studentds";
	String username="root";
	String password="Vicky@2611";
	System.out.println("Enter a student id: ");
	int id=s.nextInt();

	System.out.println("Enter a Address to change : ");
	String address=s.next();
	System.out.println("update database");
	String query="update studentdata set address=? where st_id= ?";
	Connection con=DriverManager.getConnection(url, username, password);
	PreparedStatement pst=con.prepareStatement(query);
	pst.setString(1,address);
	
	pst.setInt(2, id);
	int rows=pst.executeUpdate();
System.out.println("number of rows affected "+rows);
	recoreddatabase();
}

//callable 
public static void spdata() throws  Exception {
Scanner s=new Scanner(System.in);
	String url="jdbc:mysql://localhost:3306/Studentds";
	String username="root";
	String password="Vicky@2611";
	System.out.println("Enter a student id to showcase: ");
	int id=s.nextInt();
	Connection con=DriverManager.getConnection(url, username, password);
	CallableStatement cst=con.prepareCall("{call GetstudentById(?)}");
cst.setInt(1, id);
ResultSet rt=cst.executeQuery();
while (rt.next()) {
	System.out.println("Student id : "+rt.getInt(1));
	System.out.println("student Name: "+rt.getString(2));
	System.out.println("School Name: "+rt.getString(3));
	System.out.println("Address: "+rt.getString(4));	}	
rt.close();
}
}