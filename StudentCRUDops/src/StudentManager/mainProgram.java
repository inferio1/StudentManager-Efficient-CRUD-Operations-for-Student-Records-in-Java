package StudentManager;
import java.util.Scanner;
public class mainProgram {

	public static void main(String[] args) throws Exception {

		for(;;)
		{
			System.out.println("1.Insert into Student   2.Update Student  3.Get Student Details  4.Delete student Details  5.Exit");
			System.out.println("enter your choice");
			Scanner sc=new Scanner(System.in);
			int ch=sc.nextInt();
			studentOperations so=new studentOperations();
			switch(ch)
			{
			case 1:
			  {
				System.out.println("Enter usn, name and branch");
				String usn=sc.next();
				String name=sc.next();
				String branch=sc.next();
				student s=new student();
				s.setBranch(branch);
				s.setName(name);
				s.setUsn(usn);
				so.insertStudent(s);
				System.out.println("Inserted");
				break;
			  }
			case 2:
			{
				System.out.println("Enter usn to update student's detail");
				String usn=sc.next();
				student s=new student();
				s.setUsn(usn);
				System.out.println("Enter name to update");
				String name=sc.next();
				s.setName(name);
				System.out.println("Enter branch to update");
				String branch=sc.next();
				s.setBranch(branch);
				
				so.updateStudent(usn, s);
				System.out.println("Updated");
				break;
				
			}
			
			case 3:
			{
				System.out.println("Enter usn to get student details");
				String usn=sc.next();
				student s=new student();
				s.setUsn(usn);
				so.getStudent(usn);
				System.out.println();
				break;
				
			}
			case 4:
			{
				System.out.println("Enter usn to delete student details");
				String usn=sc.next();
				student s=new student();
				s.setUsn(usn);
				so.deleteStudent(usn);
				System.out.println("Deleted");
				break;
			}
			case 5:
			{
				System.out.println("Thank you");
				System.exit(0);
				break;
			}
			default:
			{
				System.out.println("Invalid choice");
			}
				
			
				
				
			}
		}
	}

}
