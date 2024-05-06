package StudentManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class studentOperations {
	
	public Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details2","root","root");
		return con;
	}
	public void insertStudent(student s)throws Exception{
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement("insert into student values(?,?,?)");
		st.setString(1, s.getUsn());
		st.setString(2, s.getName());
		st.setString(3, s.getBranch());
		st.execute();
		st.close();
		con.close();
	}
	public void updateStudent(String usn,student s)throws Exception{
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement("update student set name=? ,branch=? where usn=?");
		st.setString(1,s.getName());
		st.setString(2, s.getBranch());
		st.setString(3, s.getUsn());
		st.executeUpdate();
		st.close();
		con.close();
	}
	public void getStudent(String usn) throws Exception
	{
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement("Select * from student where usn =?");
		st.setString(1, usn);
		ResultSet res=st.executeQuery();
		while(res.next())
		{
			System.out.println("Details");
			System.out.print(res.getString(1)+" "+res.getString(2)+" "+res.getString(3));
			
		}
		st.close();
		con.close();
	}
	public void deleteStudent(String usn) throws Exception
	{
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement("delete from student where usn =?");
		st.setString(1, usn);
		st.execute();
		st.close();
		con.close();
		
	}
}
