package new_reasearch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class resultsearch_user extends JFrame implements ActionListener{
		
	
	
	JTextField Name_TXT= new JTextField(10);
	JTextField Card_num_TXT= new JTextField(10);
	JTextField Date_TXT= new JTextField(10);
	JTextField CVV_TXT= new JTextField(10);
	JTextField Valid_num_TXT= new JTextField(10);
	JTextField Get_money_TXT= new JTextField(10);
	JTextField Email_TXT = new JTextField(10);
	JTextField Mobile_TXT = new JTextField(10);
	
	JLabel title= new JLabel("The Result Search under Card Number: "+Card_num_TXT.getText()+" is");
	
	JButton back_BTN = new JButton("Back");

	
	public resultsearch_user(){

		
		setLayout(null);
		setSize(600,400);
		setTitle("Result For The Search");
		setLocationRelativeTo(null);
		setResizable(false);
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\10.png")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
		
		JLabel tit= new JLabel("Result For The Srearch");
		tit.setBounds(200,5,200,30);
		tit.setForeground(Color.green);
		tit.setFont(new Font("siref",Font.BOLD,16));
		add(tit);
		
		JLabel Name_lbl= new JLabel("Full Name:");
		Name_lbl.setForeground(Color.orange);
		Name_lbl.setBounds(30,50,120,30);
		add(Name_lbl);
		
		
		Name_TXT.setBounds(120,50,120,30);	
		Name_TXT.setEnabled(false);
		add(Name_TXT);
	
		JLabel Card_lbl= new JLabel("Card Number:");
		Card_lbl.setBounds(30,100,120,30);	
		Card_lbl.setForeground(Color.orange);
		add(Card_lbl);
		
		
		Card_num_TXT.setBounds(120,100,120,30);
		Card_num_TXT.setEnabled(false);
		add(Card_num_TXT);
	
		
		JLabel date_lbl= new JLabel("Expiration:");
		date_lbl.setBounds(30,150,120,30);
		date_lbl.setForeground(Color.orange);
		add(date_lbl);
		
		Date_TXT.setBounds(120,150,120,30);
		Date_TXT.setEnabled(false);
		add(Date_TXT);
	
		JLabel Email_lbl= new JLabel("Email:");
		Email_lbl.setBounds(30,200,120,30);
		add(Email_lbl);
		Email_lbl.setForeground(Color.orange);

		
		Email_TXT.setBounds(120,200,120,30);
		Email_TXT.setEnabled(false);
		add(Email_TXT);
		
		
		JLabel Valid_Num_lbl= new JLabel("Valid Num:");
		Valid_Num_lbl.setBounds(300,50,120,30);
		Valid_Num_lbl.setForeground(Color.orange);
		add(Valid_Num_lbl);
		
		Valid_num_TXT.setBounds(390,50,120,30);
		Valid_num_TXT.setEnabled(false);
		add(Valid_num_TXT);
	
		
		
		JLabel CVV_lbl= new JLabel("Security Code:");
		CVV_lbl.setBounds(300,100,120,30);
		CVV_lbl.setForeground(Color.orange);
		add(CVV_lbl);
	
		CVV_TXT.setBounds(390,100,120,30);
		CVV_TXT.setEnabled(false);
		add(CVV_TXT);	
	
		
		
		JLabel get_money_lbl= new JLabel("Get Money:");
		get_money_lbl.setBounds(300,150,120,30);
		add(get_money_lbl);
		get_money_lbl.setForeground(Color.orange);
    	get_money_lbl.setFont(new Font("siref",Font.BOLD,13));
	
    	Get_money_TXT.setBounds(390,150,120,30);
    	Get_money_TXT.setEnabled(false);
		add(Get_money_TXT);

		
		JLabel mobile_lbl= new JLabel("Mobile:");
		mobile_lbl.setBounds(300,200,120,30);
		add(mobile_lbl);
		mobile_lbl.setForeground(Color.orange);

		
		Mobile_TXT.setBounds(390,200,120,30);
		Mobile_TXT.setEnabled(false);
		add(Mobile_TXT);
		
		
		back_BTN.setBounds(30, 320, 70, 30);
		add(back_BTN);
	
		back_BTN.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
		
	public static void main(String[] args) {
        new resultsearch_user();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back_BTN){
			search_user search = new search_user();
			search.setVisible(true);
			setVisible(false);
		}
	}

}
