package new_reasearch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.jws.soap.SOAPBinding.Use;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class delete_user extends JFrame implements ActionListener {
	
	Connection con = null;
	Statement stmt = null;

	JTextField UserName_TXT= new JTextField(10);
	JPasswordField PassWord_TXT = new JPasswordField(15);

	JButton Delete_BTN = new JButton("Delete");
	JButton Back_BTN = new JButton("Back");
	

	 public delete_user(){
			
		  setLayout(null);
			setSize(630,400);
			setTitle("Delete User");
			setLocationRelativeTo(null);
			setResizable(false);
			try {
				setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\jj.jpg")))));
			}
			catch(Exception e)
			{
				System.out.println("image dosnt exist");
			}
			
		JLabel lbl= new JLabel("Delete User");
		lbl.setForeground(Color.RED);
		lbl.setBounds(240,10,150,30);		
		lbl.setFont(new Font("siref",Font.BOLD,20));
		add(lbl);
			
			
		JLabel name = new JLabel("User Name:");
		name.setBounds(36,155,120,30);
		add(name);
		
		UserName_TXT.setBounds(120,155,120,30);
		name.setFont(new Font("siref",Font.BOLD,14));
		add(UserName_TXT);

		JLabel pass = new JLabel("Password:");
		pass.setBounds(270,155,120,30);
		add(pass);
		
		PassWord_TXT.setBounds(345,155,120,30);
		pass.setFont(new Font("siref",Font.BOLD,14));
		add(PassWord_TXT);

		Delete_BTN.setBounds(490, 155, 100, 30);
		Delete_BTN.setFont(new Font("siref",Font.BOLD,14));
		Delete_BTN.setBackground(Color.green);
		add(Delete_BTN);
		
		
		Back_BTN.setBounds(30, 300, 80, 30);
		Back_BTN.setBackground(Color.RED);
		add(Back_BTN);
		
		Delete_BTN.addActionListener(this);
		Back_BTN.addActionListener(this);
		
		setVisible(true);
		
		
	 }
		
	 
		public void delete_Method(){
			
			try {
				
	    	 	Class.forName("org.sqlite.JDBC");
	    	 	con=DriverManager.getConnection("jdbc:sqlite:Login_DB.db");
			
	    	 	stmt=con.createStatement();
	    	 	
	    	 	
			
	    	 	String delete =  "delete from INFO where user_name ='" + UserName_TXT.getText() + "' and pass_word ='"+PassWord_TXT.getText()+"' ";
	    	 	
	    	 	
	    	 	JOptionPane.showMessageDialog(null, "delete Data is Successful");
	    	 	
	            stmt.executeQuery(delete);
	            
	            stmt.close();
	            con.close();

		       } 
		
		    catch (Exception e) {
		    	JOptionPane.showMessageDialog(null,e.getMessage());
		    	}
			
		}
	 
	
	public static void main(String[] args) {
		new delete_user();
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
				if(UserName_TXT.getText().equals("") || PassWord_TXT.getText().equals("") ){
				JOptionPane.showMessageDialog(null, "Please enter sign infromation and try agin","WARNING", JOptionPane.WARNING_MESSAGE, null);
				}
			
				else
				{
					delete_Method();
					UserName_TXT.setText("");
					PassWord_TXT.setText("");
				}
			}
			
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
			
		}
	}

}
