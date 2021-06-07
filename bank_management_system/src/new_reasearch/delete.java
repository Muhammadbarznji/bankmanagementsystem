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

public class delete extends JFrame implements ActionListener {

	JButton Delete_User_BTN = new JButton("Delete User");
	JButton Delete_VisaCard_BTN = new JButton("Delete Visa Card");
	JButton Back_BTN = new JButton("Back");

	
  public delete(){
	
	  setLayout(null);
		setSize(600,300);
		setTitle("Delete");
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\k.jpg")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
		
  
		Delete_User_BTN.setBounds(160, 100, 140, 40);
		add(Delete_User_BTN);
		Delete_User_BTN.setFont(new Font("siref",Font.BOLD,14));

		
		Delete_VisaCard_BTN.setBounds(330, 100, 150, 40);
		add(Delete_VisaCard_BTN);
		Delete_VisaCard_BTN.setFont(new Font("siref",Font.BOLD,14));

		Back_BTN.setBounds(30, 230, 90, 30);
		Back_BTN.setBackground(Color.red);
		add(Back_BTN);
		
		Back_BTN.addActionListener(this);
		Delete_User_BTN.addActionListener(this);
		Delete_VisaCard_BTN.addActionListener(this);
		
		setVisible(true);
	  
  }	
	
		public static void main(String[] args) {
			new delete();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Delete_User_BTN){
			delete_user user = new delete_user();
			user.setVisible(true);
			setVisible(false);
		}
		if (e.getSource() == Delete_VisaCard_BTN){
			Delete_VisaCard visa = new Delete_VisaCard();
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
