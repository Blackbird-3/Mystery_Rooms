import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import javax.swing.JButton;

public class game2 extends JFrame implements MouseListener{
	
	static Timer timer;
	static int second=0;
	static int minute=3;
	static String ddsec;
	static String ddmin;
	static DecimalFormat dFormat= new DecimalFormat("00");
	static JLabel counter = new JLabel("03:00");
	static boolean codecheck=false;
	static boolean cuttercheck=false;
	static boolean ballscheck=false;
	static boolean gb=false;
	static boolean rb=false;
	static boolean bb=false;
	static JLabel bg;
	static JLabel key;
	static game2 frame = new game2();
	static ImageIcon cutimg = new ImageIcon("C:\\Users\\agarw_5tye0zl\\eclipse-workspace\\Mystery_Rooms\\src\\images\\cutter.png");
	static String timeleft;
	

	
	public static void countdowntimer() {
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				second--;
				
				ddsec= dFormat.format(second);
				ddmin= dFormat.format(minute);
				counter.setText(ddmin+":"+ddsec);
				timeleft=counter.getText();
				
				if(second==-1) {
					second=59;
					minute--;
					ddsec= dFormat.format(second);
					ddmin= dFormat.format(minute);
//					counter.setText(ddmin+":"+ddsec);
				}
				if(second==0 && minute==0) {
					timer.stop();
					Game_Over go = new Game_Over();
					go.setVisible(true);
				}
			}
		});
	}
	private JPanel contentPane;
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setResizable(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public game2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1365, 790);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
//		ImageIcon bgimg = new ImageIcon("C:\\Users\\agarw_5tye0zl\\eclipse-workspace\\Mystery_Rooms\\src\\mystery_room1.png");
		ImageIcon bgimg = new ImageIcon("C:\\Users\\agarw_5tye0zl\\eclipse-workspace\\Mystery_Rooms\\src\\images\\Room3.png");
		bg = new JLabel(bgimg);
		bg.setBackground(Color.BLACK);
		bg.setBounds(0, 0, 1350, 752);
		contentPane.add(bg);
		

		counter.setForeground(new Color(255, 255, 255));
		counter.setFont(new Font("Arial Black", Font.PLAIN, 25));
		counter.setBounds(1183, 20, 143, 40);
		bg.add(counter);
		countdowntimer();
		timer.start();
		
//		ImageIcon pimg = new ImageIcon("C:\\Users\\agarw_5tye0zl\\Downloads\\panelimg.png");
//		JLabel panel = new JLabel(pimg);
//		bg.add(panel);
//		panel.setBackground(Color.BLACK);
//		panel.setBounds(641, 270, 150, 150);
		
		JButton door = new JButton("");
		door.setBounds(1091, 242, 161, 282);
		door.setOpaque(false);
		door.setContentAreaFilled(false);
		door.setBorderPainted(false);
		bg.add(door);
		
		JButton entercode = new JButton("");
		bg.add(entercode);
		entercode.setBounds(675, 253, 148, 151);
		entercode.setOpaque(false);
		entercode.setContentAreaFilled(false);
		entercode.setBorderPainted(false);
		
		JButton box = new JButton("");
		box.setBounds(939, 560, 190, 146);
		bg.add(box);
		box.setOpaque(false);
		box.setContentAreaFilled(false);
		box.setBorderPainted(false);
		
		JButton gball = new JButton("");
		gball.setBounds(1049, 0, 85, 46);
		bg.add(gball);
		gball.setOpaque(false);
		gball.setContentAreaFilled(false);
		gball.setBorderPainted(false);
		
		JButton rball = new JButton("");
		rball.setBounds(495, 460, 67, 37);
		bg.add(rball);
		rball.setOpaque(false);
		rball.setContentAreaFilled(false);
		rball.setBorderPainted(false);
		
		JButton bball = new JButton("");
		bball.setBounds(1299, 685, 51, 46);
		bg.add(bball);
		bball.setOpaque(false);
		bball.setContentAreaFilled(false);
		bball.setBorderPainted(false);
		
		JButton balls = new JButton("");
		balls.setBounds(53, 69, 137, 273);
		bg.add(balls);
		balls.setOpaque(false);
		balls.setContentAreaFilled(false);
		balls.setBorderPainted(false);
		
		gball.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showMessageDialog(null, "Green ball found", "Ball Found", JOptionPane.INFORMATION_MESSAGE);
				gb=true;
				if (bb==true && rb==true && gb==true) {
					ballscheck=true;
				}
			}
		});
		rball.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				JOptionPane.showMessageDialog(null, "Red ball found", "Ball Found", JOptionPane.INFORMATION_MESSAGE);
				rb=true;
				if (bb==true && rb==true && gb==true) {
					ballscheck=true;
				}
			}
		});
		bball.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				JOptionPane.showMessageDialog(null, "Blue ball found", "Ball Found", JOptionPane.INFORMATION_MESSAGE);
				bb=true;
				if (bb==true && rb==true && gb==true) {
					ballscheck=true;
				}
			}
		});
		
		balls.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if (ballscheck==false) {
					
					JOptionPane.showMessageDialog(null,"Balls not found","Incomplete", JOptionPane.ERROR_MESSAGE);
				}
				else if (ballscheck==true) {
					JOptionPane.showMessageDialog(
		                    null,
		                    "Box Cutter Aquired",
		                    "Tool", JOptionPane.INFORMATION_MESSAGE, cutimg);
					cuttercheck=true;
				}
			
		}
	});
		
		box.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if (cuttercheck==false) {
					
					JOptionPane.showMessageDialog(null,"Box is sealed\nTool is required","LOCKED", JOptionPane.ERROR_MESSAGE);
				}
				else if (cuttercheck==true) {
					JOptionPane.showMessageDialog(
		                    null,
		                    "Code is 3569",
		                    "CODE", JOptionPane.INFORMATION_MESSAGE);
					
				}
			
		}
	});
//		key = new JLabel(keyimg);
//		key.setBounds(901, 315, 145, 113);
//		bg.add(key);
//		key.setVisible(false);
		
		
		
		entercode.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					
					System.out.println("Panel clicked");
					code_panel cp = new code_panel();
					cp.setVisible(true);
				
			}
		});
		door.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (codecheck==false) {
					
					JOptionPane.showMessageDialog(door,"Door is locked\nKey is required","LOCKED", JOptionPane.ERROR_MESSAGE);
					System.out.println("Door clicked");
				}
				else if (codecheck==true) {
					You_Won won= new You_Won();
					won.setVisible(true);
					frame.dispose();
					
				}
			}
		});
	}


	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

//	public void insert() {
//		String url="jdbc:mysql://localhost:3306/mystery_rooms";
//		String userr= "root";
//		String pwd="shreshth";
//		try {
//			
////			Class.forName("com.mysql.jdbc.Driver");
//			Connection con=DriverManager.getConnection(	url,userr,pwd);  
//			Statement stmt=con.createStatement();  
//			stmt.executeUpdate("insert into credentials (Result) values(\""+timeleft+"\");");  
//			ResultSet rs=stmt.executeQuery("select * from credentials;");
//			while(rs.next())  
//				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+rs.getString(4));  
//			con.close();  }
//		catch (Exception e) {
//			System.out.println(e);
//		}
//		
//	}
}
