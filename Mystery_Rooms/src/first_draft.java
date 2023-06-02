import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.*;
public class first_draft implements ActionListener{
	static JLabel userlabel;
	static JTextField userText;
	static JLabel pwdlabel;
	static JPasswordField pwdText;
	static JLabel pwdlabel2;
	static JPasswordField pwdText2;
	static JButton button;
	static String user;
	static String password;
	static JLabel success;
	static JLabel fail;
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel imgbg = new JLabel(new ImageIcon("C:\\Users\\agarw_5tye0zl\\eclipse-workspace\\Mystery_Rooms\\src\\images\\login_bg"));
		

//		JFrame frame2 = new JFrame();
//		JPanel panel2 = new JPanel();
		
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("REGISTER");
		frame.add(panel);
		
		
//		frame2.setSize(400,400);
//		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame2.setTitle("LOGIN");
//		frame2.add(panel);
		
		panel.add(imgbg);
		panel.setLayout(null);
		
		
		
		userlabel = new JLabel("User");
		userlabel.setBounds(10,20,80,25);
		panel.add(userlabel);
		
		userText= new JTextField(20);
		userText.setBounds(150,20,165,25);
		panel.add(userText);
		
		pwdlabel = new JLabel("Password");
		pwdlabel.setBounds(10,60,80,25);
		panel.add(pwdlabel);
		
		pwdText= new JPasswordField(20);
		pwdText.setBounds(150,60,165,25);
		panel.add(pwdText);

		pwdlabel2 = new JLabel("Repeat Password");
		pwdlabel2.setBounds(10,100,80,25);
		panel.add(pwdlabel2);
		
		pwdText2= new JPasswordField(20);
		pwdText2.setBounds(150,100,165,25);
		panel.add(pwdText2);
	
		button= new JButton("Submit");
		button.setBounds(10,150,80,25);
		button.addActionListener(new first_draft());
		panel.add(button);

		success = new JLabel("");
		success.setBounds(10,120,300,25);
		panel.add(success);
		success.setText(null);

		fail = new JLabel("");
		fail.setBounds(10,120,300,25);
		panel.add(fail);
		fail.setText(null);

		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (pwdText.equals(pwdText2)) {
			
			user = userText.getText();
			password = pwdText.getText();
			System.out.println(user+" , "+ password);
			success.setText("Registration Successfull!");
			insert();
		} else {
			fail.setText("Registration Failed");
			
		}
		
		
	}
	public void insert() {
		String url="jdbc:mysql://localhost:3306/mystery_rooms";
		String userr= "root";
		String pwd="shreshth";
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
		
	}
}
