import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Splash_page extends JFrame implements ActionListener{

	static JButton play = new JButton("Play");
	static Splash_page frame = new Splash_page();
	JButton htp = new JButton("Info");
	JButton res = new JButton("Results");
	private JPanel contentPane;

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
	public Splash_page() {
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 686, 468);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon bgimg = new ImageIcon("C:\\Users\\agarw_5tye0zl\\eclipse-workspace\\Mystery_Rooms\\src\\images\\splashbg.jpg");
		JLabel bg = new JLabel(bgimg);
		bg.setBackground(Color.BLACK);
		bg.setBounds(0, 10, 679, 431);
		contentPane.add(bg);
		
		JLabel Heading = new JLabel("MYSTERY ROOMS");
		Heading.setHorizontalAlignment(SwingConstants.CENTER);
		Heading.setFont(new Font("Snap ITC", Font.PLAIN, 50));
		Heading.setForeground(Color.RED);
		Heading.setBackground(Color.BLACK);
		Heading.setBounds(32, 10, 611, 101);
		bg.add(Heading);
		
		
		play.setBackground(new Color(0, 0, 0));
		play.setForeground(new Color(255, 255, 255));
		play.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		play.setBounds(240, 240, 175,75);
		play.setFocusable(false);
		play.addActionListener(this);
		bg.add(play);
		
		
		htp.setBackground(new Color(0, 0, 0));
		htp.setForeground(new Color(255, 255, 255));
		htp.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		htp.setBounds(10, 236, 161, 80);
		htp.setFocusable(false);
		bg.add(htp);

		htp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					
				frame.dispose();
				Info i = new Info();
				i.setVisible(true);
				
			}
		});
		
		
		res.setBackground(new Color(0, 0, 0));
		res.setForeground(new Color(255, 255, 255));
		res.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		res.setBounds(532, 236, 130, 91);
		res.setFocusable(false);
		res.addActionListener(this);
		bg.add(res);

		res.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					
				frame.dispose();
				result r = new result();
				r.setVisible(true);
				
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==play) {
			frame.dispose();
			game2 g = new game2();
			g.setVisible(true);
		}
		
	}
}
