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

public class search_user extends JFrame implements ActionListener{
	
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
	
	
	JTextField Card_TXT = new JTextField(10);
	JTextField CVV_TXT = new JTextField(10);
	
	JButton Search_BTN = new JButton("Search");
	JButton Back_BTN = new JButton("Back");
	
	
	public search_user(){

		setLayout(null);
		setSize(600,380);
		setTitle("Search");
		setLocationRelativeTo(null);
		setResizable(false);
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\g.jpg")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
		
		
		JLabel Card_num_lbl = new JLabel("Card Number: ");
		Card_num_lbl.setBounds(100,100,120,30);
		add(Card_num_lbl);
	
		
		Card_TXT.setBounds(100,130,180,30);
		add(Card_TXT);
	
		JLabel CVV_num_lbl = new JLabel("CVV: ");
		CVV_num_lbl.setBounds(300,100,120,30);	
		add(CVV_num_lbl);
	

		CVV_TXT.setBounds(300,130,80,30);
		add(CVV_TXT);	
				
	
		Search_BTN.setBounds(400, 130, 110, 30);
		Search_BTN.setBackground(Color.green);
		Search_BTN.setFont(new Font("siref",Font.BOLD,14));
		add(Search_BTN);
	
		Back_BTN.setBounds(30, 300, 80, 30);
		Back_BTN.setBackground(Color.RED);
		add(Back_BTN);
		
		Back_BTN.addActionListener(this);
		Search_BTN.addActionListener(this);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public void Search_Method(){
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			con=DriverManager.getConnection("jdbc:sqlite:infromation.db");
			
			stmt=con.createStatement();
			
			
			String select = "select * from infromation where card_number = '"+Card_TXT.getText()+"' and CVV_code = '"+CVV_TXT.getText()+"' ";
			
			
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
    								
    			
    	 		setVisible(false);
    	 	}
    	 	
    	 	else
    	 	{
    	 		JOptionPane.showMessageDialog(null, "incorrect Card Number Or CVV Code...!");
    	 		Card_TXT.setText(null);
    	 		CVV_TXT.setText(null);

    	 	}		
			
			
			stmt.close();
			con.close();
			
			System.out.println();
		} 
		
		catch (Exception e) {
			System.err.println(e.getClass().getName()+" &&&&&& "+e.getMessage());
			
		}		
		
	}
	
	
	public static void main(String[] args) {
			new search_user();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Search_BTN){
			
			try
			{
			
			
				if(Card_TXT.getText().equals("") || CVV_TXT.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Please enter card number and CVV code","WARNING", JOptionPane.WARNING_MESSAGE, null);
				}
			
				else
				{
					Search_Method();
					
					resultsearch_user result = new resultsearch_user();
					result.setVisible(true);
			
					result.Name_TXT.setText(Name_str);
					result.Card_num_TXT.setText(Card_num_str);
					result.Date_TXT.setText(date_str);
					result.Valid_num_TXT.setText(valid_num_srt);
					result.CVV_TXT.setText(CVV_str);
					result.Get_money_TXT.setText(money_str);
					result.Email_TXT.setText(Email_str);
					result.Mobile_TXT.setText(Mobile_str);
					
					setVisible(false);
				}
			}
			
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString());
			}
		
		}
		
		
		
		if (e.getSource() == Back_BTN){
			
				firstwindow_user first_user = new firstwindow_user();
				first_user.setVisible(true);
			setVisible(false);
		}
	}

}
