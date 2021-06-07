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

public class firstupdate extends JFrame implements ActionListener{
	
	Connection con = null;
	Statement stmt = null;
	
	JTextField Card_TXT = new JTextField(10);
	JTextField CVV_TXT = new JTextField(10);
	

	
	JButton Update_BTN = new JButton("Click To Update");
	JButton Back_BTN = new JButton("Back");
	
	
	String Name_str = "";
	String Card_num_str = "";
	String date_str = "";
	String valid_num_srt = "";
	String CVV_str = "";
	String money_str = "";
	String Email_str = "";
	String Mobile_str = "";

	

	
	public firstupdate(){
		setLayout(null);
		setSize(600,380);
		setTitle("Update Account");
		setLocationRelativeTo(null);
		setResizable(false);
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\6.jpg")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
		
		JLabel Card_num_lbl = new JLabel("Card Number: ");
		Card_num_lbl.setForeground(Color.RED);
		Card_num_lbl.setBounds(100,100,120,30);
		add(Card_num_lbl);

		
		Card_TXT.setBounds(100,130,180,30);
		add(Card_TXT);

			
			
		
		JLabel CVV_lbl = new JLabel("CVV: ");
		CVV_lbl.setForeground(Color.RED);
		CVV_lbl.setBounds(300,100,120,30);	
		add(CVV_lbl);
		
		CVV_TXT.setBounds(300,130,80,30);
		add(CVV_TXT);	
				

			
			
		
		Update_BTN.setBounds(400, 130, 135, 30);
		Update_BTN.setBackground(Color.green);
		Update_BTN.setFont(new Font("siref",Font.BOLD,12));
		add(Update_BTN);
		
		Back_BTN.setBounds(30, 300, 80, 30);
		add(Back_BTN);
		Back_BTN.setBackground(Color.RED);
		
		Back_BTN.addActionListener(this);
		Update_BTN.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void update_method(){
		
		try {
			
    	 	Class.forName("org.sqlite.JDBC");
    	 	con=DriverManager.getConnection("jdbc:sqlite:infromation.db");
		
    	 	stmt=con.createStatement();
    	 	
    	 	
    	 	String s =  "select * from infromation where card_number ='" + Card_TXT.getText() + "' and CVV_code ='"+CVV_TXT.getText()+"' ";
    	 	
    	 	ResultSet result = stmt.executeQuery(s);
    	 	
    	 	if(result.next()){
    	 		
				Name_str = result.getString(1);
				Card_num_str = result.getString(2);
				date_str = result.getString(3);
				valid_num_srt = result.getString(4);
				CVV_str = result.getString(5);
				money_str = result.getString(6);
				Email_str = result.getString(7);
				Mobile_str = result.getString(8);
				
				update update = new update();
				update.Card_num_old_TXT.setText(Card_num_str);
				update.Security_code_old_TXT.setText(CVV_str);
				
				update.Name_TXT.setText(Name_str);
				update.Card_num_TXT.setText(Card_num_str);
				update.Date_TXT.setText(date_str);
				update.Valid_num_TXT.setText(valid_num_srt);
				update.Security_code_TXT.setText(CVV_str);
				update.Get_money_TXT.setText(money_str);
				update.Email_TXT.setText(Email_str);
				update.Mobile_TXT.setText(Mobile_str);
				
				update.setVisible(true);
    	 		
    	 		setVisible(false);
    	 	}
    	 	
    	 	else
    	 	{
    	 		JOptionPane.showMessageDialog(null, "incorrect Card Number Or CVV Code...!");
    	 		Card_TXT.setText(null);
    	 		CVV_TXT.setText(null);

    	 	}		
		} 
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
		
	}
	
	
	public static void main(String[] args) {
			new firstupdate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == Update_BTN){
			
			try
			{
			
			
				if(Card_TXT.getText().equals("") || CVV_TXT.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Please enter card number and CVV code","WARNING", JOptionPane.WARNING_MESSAGE, null);
				}
			
				else
				{
					update_method();
				}
			}
			
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString());
			}
		}
		
		
		if(e.getSource() == Back_BTN){
			firstwindow_admin first_user = new firstwindow_admin();
			first_user.setVisible(true);
			setVisible(false);
		}
	}

}
