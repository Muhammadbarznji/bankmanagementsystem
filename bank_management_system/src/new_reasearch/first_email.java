package new_reasearch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class first_email extends JFrame implements ActionListener {

	JButton pr_email_BTN = new JButton("Private");
	JButton pu_email_BTN = new JButton("Public");
	JButton Back_BTN = new JButton("Back");

	
  public first_email(){
	
	  setLayout(null);
		setSize(600,300);
		setTitle("Email");
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\e5.jpg")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
		
  
		pr_email_BTN.setBounds(160, 100, 130, 40);
		add(pr_email_BTN);
		pr_email_BTN.setFont(new Font("siref",Font.BOLD,14));

		
		pu_email_BTN.setBounds(330, 100, 135, 40);
		add(pu_email_BTN);
		pu_email_BTN.setFont(new Font("siref",Font.BOLD,14));

		Back_BTN.setBounds(30, 230, 90, 30);
		Back_BTN.setBackground(Color.red);
		add(Back_BTN);
		
		Back_BTN.addActionListener(this);
		pr_email_BTN.addActionListener(this);
		pu_email_BTN.addActionListener(this);
		
		setVisible(true);
	  
  }	
	
		public static void main(String[] args) {
new first_email();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pr_email_BTN){
			Admin_email user = new Admin_email();
			user.setVisible(true);
			setVisible(false);
		}
		if (e.getSource() == pu_email_BTN){
			send_email_to_all visa = new send_email_to_all();
			visa.setVisible(true);
			setVisible(false);
		}
		if (e.getSource() == Back_BTN){
			firstwindow_admin a = new firstwindow_admin();
			a.setVisible(true);
			setVisible(false);
		}
	}

}
