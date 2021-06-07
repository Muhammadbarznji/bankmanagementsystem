package new_reasearch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class update_user extends JFrame implements ActionListener{
	
	
	Connection con = null;
	Statement stmt = null;
	
	
	JTextField Name_TXT= new JTextField(10);
	//JTextField Card_num_TXT= new JTextField(10);
	//JTextField Date_TXT= new JTextField(10);
	//JTextField Security_code_TXT= new JTextField(10);
	//JTextField Valid_num_TXT= new JTextField(10);
	//JTextField Get_money_TXT= new JTextField(10);
	JTextField Email_TXT= new JTextField(10);
	//JTextField Mobile_TXT= new JTextField(10);
	JTextField Card_num_old_TXT= new JTextField(10);
	JTextField Security_code_old_TXT= new JTextField(10);
	
	JFormattedTextField Valid_num_TXT;
	JFormattedTextField Date_TXT;
	JFormattedTextField Card_num_TXT;
	JFormattedTextField Security_code_TXT ;
	JFormattedTextField Mobile_TXT ;
	JFormattedTextField Get_money_TXT ;


	JButton Save_BTN = new JButton("Save");
	JButton Reset_BTN = new JButton("Reset");
	JButton Back_BTN = new JButton("Back");
	

	public update_user(){
		setLayout(null);
		setSize(600,400);
		setTitle("Update");
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\10.png")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
		
		/*
		
		JLabel Card_num_old_lbl= new JLabel("Your Old Card Number:");
		Card_num_old_lbl.setBounds(40,40,130,30);
		Card_num_old_lbl.setForeground(Color.red);
		add(Card_num_old_lbl);
		
		Card_num_old_TXT.setBounds(180,45,120,20);
		Card_num_old_TXT.enable(false);
		add(Card_num_old_TXT);
		
		JLabel Security_code_old_lbl= new JLabel("Your Old Cvv Number:");
		Security_code_old_lbl.setForeground(Color.red);
		Security_code_old_lbl.setBounds(320,40,130,30);
		add(Security_code_old_lbl);
		
		
		Security_code_old_TXT.setBounds(450,45,60,20);
		Security_code_old_TXT.enable(false);
		add(Security_code_old_TXT);
		
		*/
		
		
		JLabel title= new JLabel("Update Your Account");
		title.setBounds(200,5,200,30);
		title.setForeground(Color.green);
		title.setFont(new Font("siref",Font.BOLD,16));
		add(title);
		
		
		JLabel Name_lbl= new JLabel("Full Name:");
		Name_lbl.setBounds(30,90,120,30);
		Name_lbl.setForeground(Color.orange);
		add(Name_lbl);
		
		Name_TXT.setBounds(120,90,120,30);	
		add(Name_TXT);
		
		JLabel Card_lbl= new JLabel("Card Number:");
		Card_lbl.setBounds(30,140,120,30);	
		Card_lbl.setForeground(Color.orange);
		add(Card_lbl);
		
		 try {
				MaskFormatter a = new MaskFormatter("################");
				Card_num_TXT = new JFormattedTextField(a);
				 Card_num_TXT.setBounds(120,140,120,30);
				add(Card_num_TXT);
				

			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "aaaaa");	
      };
		
		
		
		JLabel Date_lbl= new JLabel("Expiration:");
		Date_lbl.setBounds(30,190,120,30);
		Date_lbl.setForeground(Color.orange);
		add(Date_lbl);
		
	     try {
				MaskFormatter a = new MaskFormatter("## / ####");
				Date_TXT = new JFormattedTextField(a);
				Date_TXT.setBounds(120,190,120,30);
				add(Date_TXT);

			} catch (ParseException e) {
				e.printStackTrace();
			};
		
		
		JLabel Email_lbl= new JLabel("Email:");
		Email_lbl.setBounds(30,240,120,30);
		add(Email_lbl);
		Email_lbl.setForeground(Color.orange);

		
		Email_TXT.setBounds(120,240,120,30);
		add(Email_TXT);
		
		
		JLabel Valid_num_lbl= new JLabel("Valid Num:");
		Valid_num_lbl.setBounds(300,90,120,30);
		Valid_num_lbl.setForeground(Color.orange);
		add(Valid_num_lbl);
		
        try {
			MaskFormatter a = new MaskFormatter("## / ####");
			Valid_num_TXT = new JFormattedTextField(a);
			add(Valid_num_TXT);
			Valid_num_TXT.setBounds(390,90,120,30);

		} catch (ParseException e) {
			e.printStackTrace();
		};
		
		
		JLabel Security_code_lbl= new JLabel("Security Code:");
		Security_code_lbl.setBounds(300,140,120,30);
		Security_code_lbl.setForeground(Color.orange);
		add(Security_code_lbl);
		
		 try {
				MaskFormatter a = new MaskFormatter("####");
				Security_code_TXT = new JFormattedTextField(a);
				Security_code_TXT.setBounds(390,140,120,30);
				add(Security_code_TXT);	
				

			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "aaaaa");	
     };
		
		
		JLabel Get_money_lbl= new JLabel("Get Money:");
		Get_money_lbl.setBounds(300,190,120,30);
		Get_money_lbl.setForeground(Color.ORANGE);
		Get_money_lbl.setFont(new Font("siref",Font.BOLD,13));
		add(Get_money_lbl);
		
		 try {
				MaskFormatter a = new MaskFormatter("####");
				Get_money_TXT = new JFormattedTextField();	
		    	Get_money_TXT.setBounds(390,190,120,30);
				add(Get_money_TXT);

			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "aaaaa");	
			};
		
		JLabel mobile_lbl= new JLabel("Mobile:");
		mobile_lbl.setBounds(300,240,120,30);
		add(mobile_lbl);
		mobile_lbl.setForeground(Color.orange);

		 try {
				MaskFormatter a = new MaskFormatter("#### - ### - ####");
				Mobile_TXT = new JFormattedTextField(a);	
				Mobile_TXT.setBounds(390,240,120,30);
				add(Mobile_TXT);

			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "aaaaa");	
			};
		
		Save_BTN.setBounds(480, 320, 70, 30);
		Save_BTN.setBackground(Color.GREEN);
		Save_BTN.setFont(new Font("siref",Font.BOLD,14));
		add(Save_BTN);
		
		//!!!!!!!!!!!!!!!!
		Reset_BTN.setBounds(400, 235, 75, 30);
		Reset_BTN.setBackground(Color.red);
		Reset_BTN.setFont(new Font("siref",Font.BOLD,14));
		//add(Reset_BTN);
		
		Back_BTN.setBounds(30, 320, 70, 30);
		add(Back_BTN);
		
		
		Save_BTN.addActionListener(this);
		Reset_BTN.addActionListener(this);
		Back_BTN.addActionListener(this);
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public void update_Method(){
		
		try {
			
    	 	Class.forName("org.sqlite.JDBC");
    	 	con=DriverManager.getConnection("jdbc:sqlite:infromation.db");
		
    	 	stmt=con.createStatement();
    	 	
    	 	String Card_num_Str = Card_num_old_TXT.getText();
    	 	String CVV_Code_Ste = Security_code_old_TXT.getText();
		
    	 	
    	 	String update = "update infromation set full_name ='"+Name_TXT.getText()+"', card_number ='"+Card_num_TXT.getText()+"', expiration ='"+Date_TXT.getText()+"', vaild_number ='"+Valid_num_TXT.getText()+"', CVV_code ='"+Security_code_TXT.getText()+"', get_money ='"+Get_money_TXT.getText()+"', email ='"+Email_TXT.getText()+"', mobile ='"+Mobile_TXT.getText()+"'  where card_number ='" + Card_num_old_TXT.getText() + "' and CVV_code ='"+Security_code_old_TXT.getText()+"' ";
		
            stmt.executeQuery(update);
            JOptionPane.showMessageDialog(null, "UPDATE Data is Successful");
    	 	
	       } 
	
	    catch (Exception e) {
		         System.err.println(e.getClass().getName()+" &&&&&& "+e.getMessage());
	        }			
	}
	
	
	public static void main(String[] args) {
			new update_user();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == Back_BTN){
			firstupdate_user F_update = new firstupdate_user();
			F_update.setVisible(true);
			setVisible(false);
		}
		
		
		if(e.getSource() == Save_BTN){

			if(Name_TXT.getText().equals("") || Card_num_TXT.getText().equals("") || Date_TXT.getText().equals("") || Security_code_TXT.getText().equals("") || Valid_num_TXT.getText().equals("") || Get_money_TXT.getText().equals("") || Email_TXT.getText().equals("") || Mobile_TXT.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Not Found!","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else if(Card_num_TXT.getText().length() < 16){
				JOptionPane.showMessageDialog(null, "Not Found! 15","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else if(Card_num_TXT.getText().length() > 16){
				JOptionPane.showMessageDialog(null, "Not Found! 17","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else if(Security_code_TXT.getText().length() < 4){
				JOptionPane.showMessageDialog(null, "Not Found! 5","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else if(Security_code_TXT.getText().length() > 4){
				JOptionPane.showMessageDialog(null, "Not Found! 5","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else if(Valid_num_TXT.getText().length() > 10){
				JOptionPane.showMessageDialog(null, "Not Found! 10","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else if(Valid_num_TXT.getText().length() > 10){
				JOptionPane.showMessageDialog(null, "Not Found! 10","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else if(Mobile_TXT.getText().length() < 17){
				JOptionPane.showMessageDialog(null, "Not Found! 7","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else if(Mobile_TXT.getText().length() > 17){
				JOptionPane.showMessageDialog(null, "Not Found! 7","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else{
				
				try 
				{
					update_Method();
					
					Name_TXT.setText(null);
					Card_num_TXT.setText(null);
					Date_TXT.setText(null);
					Security_code_TXT.setText(null);
					Valid_num_TXT.setText(null);
					Get_money_TXT.setText(null);
					Email_TXT.setText(null);
					Mobile_TXT.setText(null);
					
				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.toString());
				}
				
			}
			
		}
		
		
	}

}
