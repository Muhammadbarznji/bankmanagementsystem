package new_reasearch;

import java.awt.Color;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javax.swing.text.Document;
import javax.swing.text.MaskFormatter;

public class add_VisaCard extends JFrame implements ActionListener{
		
	Connection con = null;
	Statement stmt = null;
	PreparedStatement prs = null;
	
	JTextField Name_TXT= new JTextField(10);
	//JTextField Card_num_TXT= new JTextField(10);
	//JTextField = new JTextField(10);
	//JTextField CVV_TXT= new JTextField(10);
	//JTextField Valid_num_TXT= new JTextField(10);
	//JTextField Get_money_TXT= new JTextField(10);
	JTextField Email_TXT= new JTextField(10);
	//JTextField Mobile_TXT= new JTextField(10);

	JButton back_BTN = new JButton("back");
	JButton Save_BTN = new JButton("Save");
	
	JFormattedTextField Valid_TXT;
	JFormattedTextField Date_TXT;
	JFormattedTextField Card_num_TXT;
	JFormattedTextField CVV_TXT ;
	JFormattedTextField Mobile_TXT ;
	JFormattedTextField Get_money_TXT ;


	
	
	public add_VisaCard(){
		
		setLayout(null);
		setSize(600,400);
		setTitle("Add VisaCard");
		setLocationRelativeTo(null);
		setResizable(false);
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\s.jpg")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
		
		JLabel lbl= new JLabel("Add VisaCard");
		lbl.setForeground(Color.RED);
		lbl.setBounds(210,10,150,30);
		lbl.setFont(new Font("siref",Font.BOLD,16));
		add(lbl);
		
		
		JLabel Name_lbl= new JLabel("Full Name:");
		Name_lbl.setBounds(30,70,120,30);
		add(Name_lbl);
		
		
		Name_TXT.setBounds(120,70,120,30);	
		add(Name_TXT);
	
		JLabel Card_lbl= new JLabel("Card Number:");
		Card_lbl.setBounds(30,120,120,30);	
		add(Card_lbl);
		
		
		
		 try {
				MaskFormatter a = new MaskFormatter("################");
				Card_num_TXT = new JFormattedTextField(a);
				 Card_num_TXT.setBounds(120,120,120,30);
				add(Card_num_TXT);
				

			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());	
         };
				
		JLabel date_lbl= new JLabel("Expiration:");
		date_lbl.setBounds(30,170,120,30);
		add(date_lbl);
		
	
	     try {
				MaskFormatter a = new MaskFormatter("## / ####");
				Date_TXT = new JFormattedTextField(a);
				Date_TXT.setBounds(120,170,120,30);
				add(Date_TXT);

			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());	
			};
			
		JLabel Email_lbl= new JLabel("Email:");
		Email_lbl.setBounds(30,220,120,30);
		add(Email_lbl);
		
		Email_TXT.setBounds(120,220,120,30);
		add(Email_TXT);
		
		JLabel Valid_Num_lbl= new JLabel("Valid Num:");
		Valid_Num_lbl.setBounds(300,70,120,30);
		add(Valid_Num_lbl);
		
		
        
        try {
			MaskFormatter a = new MaskFormatter("## / ####");
			 Valid_TXT = new JFormattedTextField(a);
			add(Valid_TXT);
	        Valid_TXT.setBounds(390,70,120,30);

		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());	
			};
		
		
		JLabel CVV_lbl= new JLabel("Security Code:");
		CVV_lbl.setBounds(300,120,120,30);
		add(CVV_lbl);
	
	
		
		 try {
				MaskFormatter a = new MaskFormatter("####");
				CVV_TXT = new JFormattedTextField(a);
				CVV_TXT.setBounds(390,120,120,30);
				add(CVV_TXT);	
				

			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());	
			};
		
		
		JLabel get_money_lbl= new JLabel("Get Money:");
		get_money_lbl.setBounds(300,170,120,30);
		add(get_money_lbl);
    	get_money_lbl.setFont(new Font("siref",Font.BOLD,13));
	

		 try {
				MaskFormatter a = new MaskFormatter("#########");
				Get_money_TXT = new JFormattedTextField();	
		    	Get_money_TXT.setBounds(390,170,120,30);
				add(Get_money_TXT);

			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());	
			};
     
		JLabel mobile_lbl= new JLabel("Mobile:");
		mobile_lbl.setBounds(300,220,120,30);
		add(mobile_lbl);
		
	
		
		 try {
				MaskFormatter a = new MaskFormatter("#### - ### - ####");
				Mobile_TXT = new JFormattedTextField(a);	
				Mobile_TXT.setBounds(390,220,120,30);
				add(Mobile_TXT);

			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());	
			};
			
			
		Save_BTN.setBounds(480, 320, 70, 30);
		Save_BTN.setBackground(Color.GREEN);
		Save_BTN.setFont(new Font("siref",Font.BOLD,14));
		add(Save_BTN); 
		
		
		back_BTN.setBounds(30, 320, 90, 30);
		add(back_BTN);
		back_BTN.setBackground(Color.red);

		Save_BTN.addActionListener(this);
		back_BTN.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	public void Table(){
		
	try {
			
			Class.forName("org.sqlite.JDBC");
			con=DriverManager.getConnection("jdbc:sqlite:infromation.db");
			
			stmt=con.createStatement();
			
			String table = "create table infromation (full_name nvarchar(50), card_number  nvarchar(50) not null primary key, expiration nvarchar(50), vaild_number nvarchar(50), CVV_code nvarchar(50), get_money nvarchar(50), email nvarchar(50), mobile nvarchar(50))";
			
			stmt.executeUpdate(table);
			
			System.out.println("Create Table is Successful");			
		} 
		
		catch (Exception e) {
			
			}
		
	}
	
	public void Add_Visa_card_Method(){
		
		Table();
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			con=DriverManager.getConnection("jdbc:sqlite:infromation.db");
			
			String Add = "insert into infromation (full_name , card_number , expiration , vaild_number, CVV_code, get_money, email, mobile) values(?,?,?,?,?,?,?,?)";
			
			prs = con.prepareStatement(Add);
			prs.setString(1, Name_TXT.getText());
			prs.setString(2, Card_num_TXT.getText());
			prs.setString(3, Date_TXT.getText());
			prs.setString(4, Valid_TXT.getText());
			prs.setString(5, CVV_TXT.getText());
			prs.setString(6, Get_money_TXT.getText());
			prs.setString(7, Email_TXT.getText());
			prs.setString(8, Mobile_TXT.getText());
			prs.execute();
			
			JOptionPane.showMessageDialog(null, "Insert Data to Database is Successful");
			
			prs.close();
			con.close();
		} 
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());	
			}
	}
	
	
	public static void main(String[] args) {
        new add_VisaCard();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		
		if (e.getSource()== back_BTN){
			add a = new add();
			a.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource() == Save_BTN){
			

			if(Name_TXT.getText().equals("") || Card_num_TXT.getText().equals("") || Date_TXT.getText().equals("") || CVV_TXT.getText().equals("") || Valid_TXT.getText().equals("") || Get_money_TXT.getText().equals("") || Email_TXT.getText().equals("") || Mobile_TXT.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Please enter all infromation and try agin","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else if(Card_num_TXT.getText().length() < 16){
				JOptionPane.showMessageDialog(null, "the card number must be 16 number","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else if(Card_num_TXT.getText().length() > 16){
				JOptionPane.showMessageDialog(null, "the card number must be 16 number","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else if(CVV_TXT.getText().length() < 4){
				JOptionPane.showMessageDialog(null, "the CVV number must be 4 number","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else if(CVV_TXT.getText().length() > 4){
				JOptionPane.showMessageDialog(null, "the CVV number must be 4 number","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			else if(Mobile_TXT.getText().length() < 17){
				JOptionPane.showMessageDialog(null, "the mobile number must 10 number","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else if(Mobile_TXT.getText().length() > 17){
				JOptionPane.showMessageDialog(null, "the mobile number must 10 number","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else{
			
			Add_Visa_card_Method();
			
			Name_TXT.setText("");
			Card_num_TXT.setText("");
			Date_TXT.setText("");
			CVV_TXT.setText("");
			Valid_TXT.setText("");
			Get_money_TXT.setText("");
			Mobile_TXT.setText("");
			Email_TXT.setText("");
			
			}
		}
	}

}
