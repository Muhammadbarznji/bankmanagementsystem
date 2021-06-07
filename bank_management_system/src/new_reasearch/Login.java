package new_reasearch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener {
	
	Connection con = null;
	Statement stmt = null;
	
	JButton Login_BTN = new JButton("Login");
	JButton Exit_BTN = new JButton("Exit");
	
	 JTextField user_name_txt = new JTextField(15);
	 JPasswordField pass_word_txt = new JPasswordField(15);
	 
	
	public Login(){
		
		setLayout(null);
		setTitle("Login");
		setSize(700,350);
		getContentPane().setBackground(Color.black);
		setLocationRelativeTo(null);
		setResizable(false);
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\lo.jpg")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
		
		
		/*
		JLabel a = new JLabel("");
		a.setBounds(20, 55, 210, 200);
		a.setForeground(Color.WHITE);
		a.setFont(new Font("Webdings",Font.BOLD,190));
		add(a);
		*/
		
		
		JLabel userL = new JLabel("User Name:");
		userL.setBounds(270,110,115, 30);
		userL.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(userL);
		
		
		JLabel passL = new JLabel("  Password:");
		passL.setBounds(270,160,115, 30);
		passL.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(passL);
		
		
		user_name_txt.setBounds(387,110,235, 30);
		user_name_txt.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(user_name_txt);
		
		
		pass_word_txt.setBounds(387,160,235, 30);
		pass_word_txt.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(pass_word_txt);
		
		
		Login_BTN.setBounds(387,220,90,30);
		Login_BTN.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(Login_BTN);
		
		
		Exit_BTN.setBounds(532,220,90,30);
		Exit_BTN.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(Exit_BTN);
		
		
		Login_BTN.addActionListener(this);
		Exit_BTN.addActionListener(this);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void Login_user_pass(){
		
		try {
			
    	 	Class.forName("org.sqlite.JDBC");
    	 	con=DriverManager.getConnection("jdbc:sqlite:Login_DB.db");
		
    	 	stmt=con.createStatement();
    	 	
    	 	
    	 	String s =  "select * from INFO where user_name ='" + user_name_txt.getText() + "' and pass_word ='"+pass_word_txt.getText()+"' ";
    	 	
    	 	ResultSet result = stmt.executeQuery(s);
    	 	
    	 	if(result.next()){
    	 		 String user_name_str = user_name_txt.getText();
    	 		 String pass_word_str = pass_word_txt.getText();
	
    	 		if(user_name_str.equals("admin") && pass_word_str.equals("admin")){
    	 			firstwindow_admin first_admin = new firstwindow_admin();
        	 		first_admin.setVisible(true);
    	 		}
    	 		
    	 		else 
    	 		{
    	 			
    	 			firstwindow_user first_user = new firstwindow_user();
    	 			first_user.user_name_lbl_ii.setText(user_name_txt.getText());
        	 		first_user.setVisible(true);
    	 		}    	 		
    	 		
				stmt.close();
				con.close();
    	 		
    	 		setVisible(false);
    	 	}
    	 	
    	 	else
    	 	{
    	 		JOptionPane.showMessageDialog(null, "incorrect User_Name Or Password...!",null, JOptionPane.ERROR_MESSAGE);
    	 		pass_word_txt.setText(null);
    	 	}		
		} 
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == Login_BTN){
			
			if(user_name_txt.getText().equals("") || pass_word_txt.getText().equals("") ){
			JOptionPane.showMessageDialog(null, "Please enter your login infromation and try agin","WARNING", JOptionPane.WARNING_MESSAGE, null);
			}
			
			else{
			Login_user_pass();
			}
			
		}
		
		if(e.getSource() == Exit_BTN){
			setVisible(false);
		}
		
	}

}
