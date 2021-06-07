package new_reasearch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Delete_VisaCard extends JFrame implements ActionListener{
	
	Connection con = null;
	Statement stmt = null;
	
	String Name_str = "";
	String Card_num_str = "";
	String date_str = "";
	String valid_num_srt = "";
	String CVV_str = "";
	String money_str = "";
	String Email_str = "";
	String Mobile_str = "";
	
	
	JTextField Card_number_TXT = new JTextField(10);
	JTextField CVV_code_TXT = new JTextField(10);
	
	
	JButton Delete_BTN = new JButton("Delete");
	JButton Back_BTN = new JButton("Back");
	
	
	public Delete_VisaCard(){
		setLayout(null);
		setSize(600,380);
		setTitle("Delete");
		setLocationRelativeTo(null);
		setResizable(false);
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\jj.jpg")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
		
		
		JLabel Card_num_lbl = new JLabel("Card Number: ");
		Card_num_lbl.setBounds(100,130,120,30);
		add(Card_num_lbl);
	
	
		Card_number_TXT.setBounds(100,160,180,30);
		add(Card_number_TXT);

	
	
		JLabel CVV_num_lbl = new JLabel("CVV: ");
		CVV_num_lbl.setBounds(300,130,120,30);	
		add(CVV_num_lbl);
	
	
		CVV_code_TXT.setBounds(300,160,80,30);
		add(CVV_code_TXT);	
				
	
		Delete_BTN.setBounds(400, 160, 110, 30);
		Delete_BTN.setBackground(Color.green);
		Delete_BTN.setFont(new Font("siref",Font.BOLD,14));
		add(Delete_BTN);
		Back_BTN.setBounds(30, 300, 80, 30);
		Back_BTN.setBackground(Color.RED);
		add(Back_BTN);
		
		Back_BTN.addActionListener(this);
		Delete_BTN.addActionListener(this);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public void Search_Method_for_delete(){
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			con=DriverManager.getConnection("jdbc:sqlite:infromation.db");
			
			stmt=con.createStatement();
			
			
			String select = "select * from infromation where card_number = '"+Card_number_TXT.getText()+"' and CVV_code = '"+CVV_code_TXT.getText()+"' ";
			
			
			ResultSet result = stmt.executeQuery(select);
			
			
			 if(result.next()){
	    	 		
	            	
 				
 				Name_str = result.getString(1);
 				Card_num_str = result.getString(2);
 				date_str = result.getString(3);
 				valid_num_srt = result.getString(4);
 				CVV_str = result.getString(5);
 				money_str = result.getString(6);
 				Email_str = result.getString(7);
 				Mobile_str = result.getString(8);
 				
				resultdelete result1 = new resultdelete();
				result1.setVisible(true);
		
				result1.Name_TXT.setText(Name_str);
				result1.Card_num_TXT.setText(Card_num_str);
				result1.Date_TXT.setText(date_str);
				result1.Valid_num_TXT.setText(valid_num_srt);
				result1.CVV_TXT.setText(CVV_str);
				result1.Get_money_TXT.setText(money_str);
				result1.Email_TXT.setText(Email_str);
				result1.Mobile_TXT.setText(Mobile_str);
				
				setVisible(false);
 								
 	 	}
 	 	
 	 	else
 	 	{
 	 		JOptionPane.showMessageDialog(null, "incorrect Card Number Or CVV Code...!");
 	 		Card_number_TXT.setText(null);
 	 		CVV_code_TXT.setText(null);

 	 	}		
			
			
			stmt.close();
			con.close();
		} 
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			
		}		
		
	}
	
			
	public static void main(String[] args) {
			new Delete_VisaCard();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Back_BTN){
			delete del = new delete();
			del.setVisible(true);
			setVisible(false);
			
		}
		
		if(e.getSource() == Delete_BTN){
			
			try
			{
				
				if(Card_number_TXT.getText().equals("") || CVV_code_TXT.getText().equals("") ){
				JOptionPane.showMessageDialog(null, "Please enter Card number and CVV number","WARNING", JOptionPane.WARNING_MESSAGE, null);
				}
			
				else
				{
					Search_Method_for_delete();
				}
			}
			
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
			
		}
	
	}

}
