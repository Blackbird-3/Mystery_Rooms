import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Info extends JFrame {

	private JPanel contentPane;
	static Info frame = new Info();
	/**
	 * Launch the application.
	 */
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
	public Info() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon bgimg = new ImageIcon("C:\\Users\\agarw_5tye0zl\\eclipse-workspace\\Mystery_Rooms\\src\\images\\infobg.jpg");
		JLabel bg = new JLabel(bgimg);
		bg.setBackground(Color.BLACK);
		bg.setBounds(0, 0, 650, 427);
		contentPane.add(bg);
		
		JTextArea text = new JTextArea();
		text.setFont(new Font("Poor Richard", Font.PLAIN, 20));
		text.setEditable(false);
		text.setText("Mystery Rooms is a challenging race against \nthe clock where the sole motive is to get \nyourself out of a theme based room before \ntime kicks you out! Imagine being locked in a \nthrill space and you have exact 3 minutes to \nuse logic, solve puzzles and find hints to pave \nyour path to freedom. Its as easy as its hard... \neverything you need to escape is inside the \nroom waiting to meet your eyes! Just analyse, \ninterpret and conclude!\nGood Luck :)");
		text.setBounds(220, 59, 338, 265);
		bg.add(text);
		
		JButton back = new JButton("Back");
		back.setBackground(new Color(0, 255, 255));
		back.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		back.setBounds(255, 338, 131, 39);
		back.setFocusable(false);
		bg.add(back);
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Splash_page sp = new Splash_page();
				sp.setVisible(true);
			}
		});
	}
}
