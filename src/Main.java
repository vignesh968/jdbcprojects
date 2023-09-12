import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in); 
		schooldao scdata=new schooldao();

		while (true) {
			System.out.println("1.add school details \n 2.displayschooldetails \n 3.delete schooldetails \n 4.add student details \n 5. display student details\n 6. delete student data\n 7.add persional details \n 8 display persional data");
			System.out.println("please Enter your choise");
			int input=scanner.nextInt();
			switch (input) {
			case 1:
				scdata.adddatabase();
				break;
			case 2:
				scdata.display();
				break;
			case 3:
				scdata.deletedata();
				break;
			case 4:
				studentdao stdao=new studentdao();
				stdao.addstudent();
				break;
			case 5:
				studentdao st=new studentdao();
				st.displaystudent();
				break;
			case 6:
				studentdao studentdao=new studentdao();
				studentdao.deletestudent();
				break;
			case 7:
				studentpersionaldata stper=new studentpersionaldata();
				stper.personaldataentry();
				break;
			case 8:
			    studentpersionaldata studdata = new studentpersionaldata();
			    studdata.displaypersonal();
			    break;
			case 9:
				studentpersionaldata modify=new studentpersionaldata();
				modify.modifydata();
				break;
			default:
				break;
			}
		}
	}

}
