import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class studentpersionaldata {
	private String st_name;
	private String  strenght;
	private String weaknessString;
	private String habit;
	private int parent_phno;
	private String parent_occ;
	private String sc_name;
	public String getSc_name() {
		return sc_name;
	}
	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}
	public void setStrenght(String strenght) {
		this.strenght = strenght;
	}
	public void personaldataentry()throws SQLException{
		Scanner scanner=new Scanner(System.in);
		Connection connection=Dbconnection.getConnection();
		System.out.println("------Enter student personal datas-----");
		System.out.println("please enter your school name:");
		sc_name=scanner.next();
		String check="select sc_name from school where sc_name=?";
		PreparedStatement statement=connection.prepareStatement(check);
		statement.setString(1, sc_name);
		ResultSet rs=statement.executeQuery();
		int y=0;
		while (rs.next()) {
			//if(rs.getString(1).equals(sc_name)) {
				y=1;
			
			
			}
		System.out.println("please enter your name");
		st_name=scanner.next();
		String checkstudent="select st_name, sc_name from students where st_name=? and sc_name=?";
		PreparedStatement prepared=connection.prepareStatement(checkstudent);
		prepared.setString(1, st_name);
		prepared.setString(2, sc_name);
		ResultSet rs1=prepared.executeQuery();
		int h=0;
		while (rs1.next()) {
			
			h=1;
			
					}
		if(y==1&&h==1)
		{

	System.out.println("please Enter your parent phno:");
	parent_phno=scanner.nextInt();
	System.out.println("please Enter your parent occupation");
	parent_occ=scanner.next();
	System.out.println("please Enter  any two strength");
	strenght=scanner.next();
	System.out.println("please enter your weekness");
	weaknessString=scanner.next();
	System.out.println("please Enter your habit");
	habit=scanner.next();
		}
		else if(h==0)
		{
			System.out.println("please enter vaild student name");

		}
		else {
			System.out.println("please enter vaild school");
		}
	String queryString="insert into studentpersonaldata values(?,?,?,?,?,?,?)";
	Connection con=Dbconnection.getConnection();
	PreparedStatement pStatement=con.prepareStatement(queryString);
	pStatement.setString(1, st_name);
	pStatement.setInt(2, parent_phno);
	pStatement.setString(3, parent_occ);
	pStatement.setString(4, strenght);
	
	pStatement.setString(5, weaknessString);
	pStatement.setString(6, habit);
	pStatement.setString(7, sc_name);
	int rows=pStatement.executeUpdate();
	System.out.println("number of rows  affected"+rows);
	}
	
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getWeaknessString() {
		return weaknessString;
	}
	public void setWeaknessString(String weaknessString) {
		this.weaknessString = weaknessString;
	}
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	public int getParent_phno() {
		return parent_phno;
	}
	public void setParent_phno(int parent_phno) {
		this.parent_phno = parent_phno;
	}
	public String getParent_occ() {
		return parent_occ;
	}
	public void setParent_occ(String parent_occ) {
		this.parent_occ = parent_occ;
	}
	
	public void displaypersonal()throws SQLException{
		Connection connection=Dbconnection.getConnection();
		String query="select * from studentpersonaldata";
		Statement statement=connection.createStatement();
		ResultSet rSet=statement.executeQuery(query);
		while(rSet.next())
		{
			System.out.print("st_name: "+rSet.getString(1));
		System.out.print("\tparent phno: "+rSet.getInt(2));
		System.out.print("\tparent_occ: "+rSet.getString(3));
		System.out.print("\t strength: "+rSet.getString(4));
		System.out.print("\tweakness; "+rSet.getString(5));
		System.out.print("\thabit: "+rSet.getString(6));
		System.out.print("\tsc_name: "+rSet.getString(7));

		System.out.println();
		}}
		public void modifydata()throws SQLException{
			Scanner scanner=new Scanner(System.in);
			Connection connection=Dbconnection.getConnection();
			System.out.println("enter your phno");
			parent_phno=scanner.nextInt();
			System.out.println("-------update your details------");
			System.out.println("modify your strength");
			String st=scanner.next();
			System.out.println("modify your weakness");
			weaknessString=scanner.next();
			String query="update studentpersonaldata set strength=? , weakness=? where parent_phno=? ";
			PreparedStatement coPrepared=connection.prepareStatement(query);
			coPrepared.setString(1, st);
			coPrepared.setString(2, weaknessString);
			coPrepared.setInt(3, parent_phno);
			int rows=coPrepared.executeUpdate();
			System.out.println("number of rows affected "+rows);
		connection.close();
		}
	

}
