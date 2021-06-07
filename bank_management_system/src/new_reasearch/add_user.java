package new_reasearch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

public class add_user extends JFrame implements ActionListener {
	
	
	Connection con = null;
	Statement stmt = null;
	PreparedStatement prs = null;

	JTextField UserName_TXT= new JTextField(10);
	JPasswordField PassWord_TXT = new JPasswordField(15);


	JButton Add_BTN = new JButton("ADD");
	JButton back_BTN = new JButton("back");

	 public add_user(){
			
		  setLayout(null);
			setSize(630,400);
			setTitle("Add user");
			setLocationRelativeTo(null);
			setResizable(false);
			try {
				setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\8.jpg")))));
			}
			catch(Exception e)
			{
				System.out.println("image dosnt exist");
			}
			
			
		JLabel lbl= new JLabel("Add User");
		lbl.setForeground(Color.RED);
		lbl.setBounds(240,10,150,30);		
		lbl.setFont(new Font("siref",Font.BOLD,20));
		add(lbl);
			
		JLabel name = new JLabel("User Name:");
		name.setBounds(36,130,120,30);
		add(name);
		
		UserName_TXT.setBounds(120,130,120,30);
		name.setFont(new Font("siref",Font.BOLD,14));
		add(UserName_TXT);

		JLabel pass = new JLabel("Password:");
		pass.setBounds(270,130,120,30);
		add(pass);
		
		PassWord_TXT.setBounds(345,130,120,30);
		pass.setFont(new Font("siref",Font.BOLD,14));
		add(PassWord_TXT);

		Add_BTN.setBounds(490, 130, 80, 30);
		Add_BTN.setFont(new Font("siref",Font.BOLD,14));
		Add_BTN.setBackground(Color.green);
		add(Add_BTN);
		
		back_BTN.setBounds(30, 320, 90, 30);
		back_BTN.setBackground(Color.red);
		add(back_BTN);

		Add_BTN.addActionListener(this);
		back_BTN.addActionListener(this);
		
		setVisible(true);
		
			
	 }
			
	 
	 public void add_user_method(){
			
			try {
				
				Class.forName("org.sqlite.JDBC");
				con=DriverManager.getConnection("jdbc:sqlite:Login_DB.db");
				
				String add = "insert into INFO (user_name , pass_word) values(?,?)";
				
				prs = con.prepareStatement(add);
				prs.setString(1, UserName_TXT.getText());
				prs.setString(2, PassWord_TXT.getText());
				prs.execute();
				
				JOptionPane.showMessageDialog(null, "Add user to Database is Successful");
				
				prs.close();
				stmt.close();
				con.close();
			} 
			
			catch (Exception e) {
				
			}
		}
	 
	
	public static void main(String[] args) {
		new add_user();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()== back_BTN){
			add a = new add();
			a.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource() == Add_BTN){
			
			try
			{
				if(UserName_TXT.getText().equals("") || PassWord_TXT.getText().equals("") ){
				JOptionPane.showMessageDialog(null, "User Name or Password is empty!","WARNING", JOptionPane.WARNING_MESSAGE, null);
				}
			
				else
				{
					add_user_method();
					UserName_TXT.setText("");
					PassWord_TXT.setText("");
				}
				
			}
			
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage()+"AAA++");
			}
			
		}
		
	}

}
