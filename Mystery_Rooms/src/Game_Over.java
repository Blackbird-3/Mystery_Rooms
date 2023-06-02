import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Game_Over extends JFrame {

	private JPanel contentPane;
	static Game_Over frame = new Game_Over();

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
	public Game_Over() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		ImageIcon bgimg = new ImageIcon("C:\\Users\\agarw_5tye0zl\\eclipse-workspace\\Mystery_Rooms\\src\\images\\over.jpg");
		contentPane.setLayout(null);
		
		JLabel bg = new JLabel(bgimg);
		bg.setBackground(Color.BLACK);
		bg.setBounds(-1, 10, 640, 427);

		contentPane.add(bg);
				
						JLabel go = new JLabel("GAME OVER!");
						bg.add(go);
						go.setFont(new Font("Segoe UI Black", Font.BOLD, 60));
						go.setForeground(new Color(255, 0, 0));
						go.setBounds(141, 112, 472, 200);
						
						JButton back = new JButton("Back");
						back.setBackground(new Color(0, 255, 255));
						back.setFont(new Font("Times New Roman", Font.PLAIN, 16));
						back.setBounds(255, 338, 131, 39);
						back.setFocusable(false);
						bg.add(back);
						back.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								Splash_page sp = new Splash_page();
								sp.setVisible(true);
								frame.dispose();
							}
						});
	}
}