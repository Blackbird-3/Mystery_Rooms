import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


class btn extends JButton{
	public btn(String x) {

		setForeground(Color.cyan);
		setBackground(Color.black);
		setFont(new Font("Calibri", 10, 20));
		setBounds(30, 30, 30, 30);
		setText(x);
	}
}

public class code_panel extends JFrame implements ActionListener{
static JFrame frame =new JFrame();
static JPanel panel = new JPanel();
static JTextField ans1 = new JTextField(8);
static String code ="3569";
ImageIcon keyimg = new ImageIcon("C:\\Users\\agarw_5tye0zl\\Downloads\\key.png");
	
	public code_panel() {
		frame.setSize(200,250);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("LOCKED");
		frame.add(panel);
		frame.setAlwaysOnTop( true );
		panel.setBackground(Color.DARK_GRAY);
		
		ans1.setBackground(Color.black);
		Font font1 = new Font("SansSerif", Font.BOLD, 25);
		ans1.setHorizontalAlignment(JTextField.RIGHT);
		ans1.setForeground(Color.white);
		ans1.setFont(font1);
		ans1.setEditable(false);
		btn b0 = new btn("0");
		btn b1 = new btn("1");
		btn b2 = new btn("2");
		btn b3 = new btn("3");
		btn b4 = new btn("4");
		btn b5 = new btn("5");
		btn b6 = new btn("6");
		btn b7 = new btn("7");
		btn b8 = new btn("8");
		btn b9 = new btn("9");


		panel.add(ans1);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b0);
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
	
		frame.setResizable(false);
		frame.setVisible(true);	

		}
	
	public static void main(String[] args) {
		
		new code_panel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac=e.getActionCommand();
		System.out.println(ac);
		String tt= ans1.getText();
		ans1.setText(tt+ac);
		String text=tt+ac;
		
		if(text.equals(code)) {
			System.out.println("CODE correct");
			game2 g = new game2();
			g.codecheck=true;
			JOptionPane.showMessageDialog(
                    null,
                    "Key Received",
                    "KEY", JOptionPane.INFORMATION_MESSAGE,
                    keyimg);
			frame.dispose();
		}
		
	}

}
