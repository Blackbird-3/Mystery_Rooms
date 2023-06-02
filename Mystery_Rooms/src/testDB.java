import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testDB {
	public static void main() {
		String url="jdbc:mysql://localhost:3306/mystery_rooms";
		String userr= "root";
		String pwd="shreshth";
		String user= "user_1";
		String password="shreshth";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(	url,userr,pwd);  
			Statement stmt=con.createStatement();  
			stmt.executeUpdate("insert into credentials (Username, Password) values(\""+user+"\",\""+password+"\");");  
			ResultSet rs=stmt.executeQuery("select * from credentials;");
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  }
		catch (Exception e) {
			System.out.println(e);
		}
}}