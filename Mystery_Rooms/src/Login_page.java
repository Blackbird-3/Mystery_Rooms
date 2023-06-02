import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.w3c.dom.UserDataHandler;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login_page extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField pwd;
	static JButton login = new JButton("Login");
	static String password;
	static String user;
	static String userdb;
	static String pwddb;
	static Login_page frame = new Login_page();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public Login_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 535);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		userLabel.setBounds(10, 113, 242, 21);
		panel.add(userLabel);
		
		username = new JTextField();
		username.setBounds(10, 144, 242, 30);
		panel.add(username);
		username.setColumns(10);
		
		JLabel pwdLabel = new JLabel("Password");
		pwdLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pwdLabel.setForeground(new Color(255, 255, 255));
		pwdLabel.setBackground(new Color(0, 191, 255, 80));
		pwdLabel.setBounds(10, 196, 174, 35);
		panel.add(pwdLabel);
		
		pwd = new JPasswordField();
		pwd.setBounds(10, 241, 242, 30);
		panel.add(pwd);
		
		user = username.getText();
		password = pwd.getText();
		
		login.setMargin(new Insets(0, 14, 2, 14));
		login.setForeground(new Color(0, 0, 128));
		login.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		login.setBackground(new Color(0, 255, 255));
		login.setBounds(74, 281, 133, 42);
		login.setFocusable(false);
		login.addActionListener(this);
		panel.add(login);
		
		JButton Register = new JButton("Don't have an account?");
		Register.setMargin(new Insets(0, 14, 2, 14));
		Register.setForeground(new Color(0, 0, 128));
		Register.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		Register.setBackground(new Color(0, 255, 255));
		Register.setBounds(10, 28, 260, 51);
		Register.setFocusable(false);
		panel.add(Register);
		Register.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					
				frame.dispose();
				register r = new register();
				r.setVisible(true);
				
			}
		});
		
		setResizable(false);
//		setUndecorated(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		user = username.getText();
		password = pwd.getText();
	
		if(e.getSource()==login) {
			if (user.equals(""))
					{
					System.out.println("Empty username not allowed");
					return;
					}	
			if (password.equals(""))
					{
					System.out.println("Empty password not allowed");
					return;
					}	
			if (check(user, password)) 
			{
//				System.out.println("got true");

				Splash_page sp = new Splash_page();
				sp.setVisible(true);
				frame.dispose();
			}
//			System.out.println("got false");

		}
		
	}
	public boolean check(String user,String pass) {
		String url="jdbc:mysql://localhost:3306/mystery_rooms";
		String userr= "root";
		String pwd="shreshth";
		try {
//			System.out.println("Entered check");
//			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(	url,userr,pwd);  
			Statement stmt=con.createStatement(); 
			ResultSet rs=stmt.executeQuery("select Password from credentials where Username=\""+user+"\";");
			while(rs.next())  {
				String p=rs.getString(1);
				
//				System.out.println(pass);
//				System.out.println(p);
				if (pass.equals(p)) 
				{
					con.close();  
//					System.out.println("logging in");
					return true;
				} 
			}
			con.close();  
			return false;}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
		}
	
}
