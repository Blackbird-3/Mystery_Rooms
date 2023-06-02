import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class result extends JFrame {

	private JPanel contentPane;
	static JLabel bg;
	private JTable table;
	static result frame = new result();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					result frame = new result();
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
	public result() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 860);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		ImageIcon bgimg = new ImageIcon("C:\\Users\\agarw_5tye0zl\\eclipse-workspace\\Mystery_Rooms\\src\\images\\resbg.jpg");
		contentPane.setLayout(null);
		bg = new JLabel(bgimg);
		bg.setBackground(Color.BLACK);
		bg.setBounds(-2, 10, 640, 853);
		contentPane.add(bg);
		
		table = new JTable();
		table.setBounds(133, 101, 389, 315);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
//		bg.add(table);
		
		JButton back = new JButton("Back");
		back.setBackground(new Color(0, 255, 255));
		back.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		back.setBounds(255, 460, 131, 39);
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
