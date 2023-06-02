import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField pwd;
	private JPasswordField pwd2;
	static JLabel success;
	static JLabel fail;
	static String user;
	static String password;
	

	/**
	 * Launch the application.
 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		
		ImageIcon bgimg = new ImageIcon("C:\\Users\\agarw_5tye0zl\\eclipse-workspace\\Mystery_Rooms\\src\\login_bg.jpg");
		JLabel bgLabel = new JLabel(bgimg);
		bgLabel.setBounds(0, 0, 660, 500);
		contentPane.add(bgLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 155, 80));
		panel.setBounds(180, 55, 293, 350);
		bgLabel.add(panel);
		panel.setLayout(null);
		
		JLabel userLabel = new JLabel("Username");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userLabel.setForeground(new Color(255, 255, 255));
		userLabel.setBackground(new Color(0, 191, 255));
		userLabel.setBounds(10, 24, 242, 21);
		panel.add(userLabel);
		
		username = new JTextField();
		username.setBounds(10, 56, 242, 30);
		panel.add(username);
		username.setColumns(10);
		
		JLabel pwdLabel = new JLabel("Password");
		pwdLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pwdLabel.setForeground(new Color(255, 255, 255));
		pwdLabel.setBackground(new Color(0, 191, 255, 80));
		pwdLabel.setBounds(10, 97, 174, 35);
		panel.add(pwdLabel);
		
		pwd = new JPasswordField();
		pwd.setBounds(10, 143, 242, 30);
		panel.add(pwd);
		
		JLabel rep = new JLabel("Repat Password");
		rep.setForeground(Color.WHITE);
		rep.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rep.setBackground(new Color(0, 191, 255, 80));
		rep.setBounds(10, 184, 174, 35);
		panel.add(rep);
		
		pwd2 = new JPasswordField();
		pwd2.setBounds(10, 230, 242, 30);
		panel.add(pwd2);
		
		JButton register = new JButton("Register");
		register.setFont(new Font("Tahoma", Font.PLAIN, 16));
		register.setBounds(83, 308, 101, 32);
		panel.add(register);
		register.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (pwd.equals(pwd2)) {
					System.out.println("pwd checked");
					user = username.getText();
					password = pwd.getText();
					System.out.println(user+" , "+ password);
					success.setText("Registration Successfull!");
					insert();
				} else {
					fail.setText("Registration Failed");
					
				}
			}
		});
		
		success = new JLabel("");
		success.setFont(new Font("Tahoma", Font.BOLD, 17));
		success.setForeground(new Color(255, 255, 255));
		success.setBounds(10, 271, 242, 21);
		panel.add(success);

		fail = new JLabel("");
		fail.setFont(new Font("Tahoma", Font.BOLD, 17));
		fail.setForeground(new Color(255, 255, 255));
		fail.setBounds(10, 271, 242, 21);
		panel.add(fail);
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
