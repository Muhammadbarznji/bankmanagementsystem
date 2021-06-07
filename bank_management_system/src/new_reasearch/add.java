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

public class add extends JFrame implements ActionListener {

	JButton Add_User_BTN = new JButton("Add User");
	JButton Add_VisaCard_BTN = new JButton("Add Visa Card");
	JButton Back_BTN = new JButton("Back");

	
  public add(){
	
	  setLayout(null);
		setSize(600,300);
		setTitle("Add");
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\k.jpg")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
		
  
		Add_User_BTN.setBounds(160, 100, 130, 40);
		add(Add_User_BTN);
		Add_User_BTN.setFont(new Font("siref",Font.BOLD,14));

		
		Add_VisaCard_BTN.setBounds(330, 100, 135, 40);
		add(Add_VisaCard_BTN);
		Add_VisaCard_BTN.setFont(new Font("siref",Font.BOLD,14));

		Back_BTN.setBounds(30, 230, 90, 30);
		Back_BTN.setBackground(Color.red);
		add(Back_BTN);
		
		Back_BTN.addActionListener(this);
		Add_User_BTN.addActionListener(this);
		Add_VisaCard_BTN.addActionListener(this);
		
		setVisible(true);
	  
  }	
	
		public static void main(String[] args) {
			new add();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Add_User_BTN){
			add_user user = new add_user();
			user.setVisible(true);
			setVisible(false);
		}
		
		if (e.getSource() == Add_VisaCard_BTN){
			add_VisaCard visa = new add_VisaCard();
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
