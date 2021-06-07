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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class resultdelete extends JFrame implements ActionListener{
		
	Connection con = null;
	Statement stmt = null;
	
	JTextField Name_TXT= new JTextField(10);
	JTextField Card_num_TXT= new JTextField(10);
	JTextField Date_TXT= new JTextField(10);
	JTextField CVV_TXT= new JTextField(10);
	JTextField Valid_num_TXT= new JTextField(10);
	JTextField Get_money_TXT= new JTextField(10);
	JTextField Email_TXT = new JTextField(10);
	JTextField Mobile_TXT = new JTextField(10);
	
	
	JButton del_BTN = new JButton("Delete");
	JButton back_BTN = new JButton("Back");

	
	public resultdelete(){
		
		setLayout(null);
		setSize(600,400);
		setTitle("Result For The Delete");
		setLocationRelativeTo(null);
		setResizable(false);
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\c.jpg")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
		
		JLabel tit= new JLabel("Do you went delete visa card");
		tit.setBounds(200,5,230,30);
		tit.setForeground(Color.green);
		tit.setFont(new Font("siref",Font.BOLD,16));
		add(tit);
		
		JLabel Name_lbl= new JLabel("Full Name:");
		Name_lbl.setForeground(Color.orange);
		Name_lbl.setBounds(30,65,120,30);
		add(Name_lbl);
		
		
		Name_TXT.setBounds(120,65,120,30);
		Name_TXT.setEnabled(false);
		add(Name_TXT);
	
		JLabel Card_lbl= new JLabel("Card Number:");
		Card_lbl.setBounds(30,115,120,30);	
		Card_lbl.setForeground(Color.orange);
		add(Card_lbl);
		
		
		Card_num_TXT.setBounds(120,115,120,30);
		Card_num_TXT.setEnabled(false);
		add(Card_num_TXT);
	
		
		JLabel date_lbl= new JLabel("Expiration:");
		date_lbl.setBounds(30,165,120,30);
		date_lbl.setForeground(Color.orange);
		add(date_lbl);
		
		Date_TXT.setBounds(120,165,120,30);
		Date_TXT.setEnabled(false);
		add(Date_TXT);
	
		JLabel Email_lbl= new JLabel("Email:");
		Email_lbl.setBounds(30,215,120,30);
		add(Email_lbl);
		Email_lbl.setForeground(Color.orange);

		
		Email_TXT.setBounds(120,215,120,30);
		Email_TXT.setEnabled(false);
		add(Email_TXT);
		
		
		JLabel Valid_Num_lbl= new JLabel("Valid Num:");
		Valid_Num_lbl.setBounds(300,65,120,30);
		Valid_Num_lbl.setForeground(Color.orange);
		add(Valid_Num_lbl);
		
		Valid_num_TXT.setBounds(390,65,120,30);
		Valid_num_TXT.setEnabled(false);
		add(Valid_num_TXT);
	
		
		
		JLabel CVV_lbl= new JLabel("Security Code:");
		CVV_lbl.setBounds(300,115,120,30);
		CVV_lbl.setForeground(Color.orange);
		add(CVV_lbl);
	
		CVV_TXT.setBounds(390,115,120,30);
		CVV_TXT.setEnabled(false);
		add(CVV_TXT);	
	
		
		
		JLabel get_money_lbl= new JLabel("Get Money:");
		get_money_lbl.setBounds(300,165,120,30);
		add(get_money_lbl);
		get_money_lbl.setForeground(Color.orange);
    	get_money_lbl.setFont(new Font("siref",Font.BOLD,13));
	
    	Get_money_TXT.setBounds(390,165,120,30);
    	Get_money_TXT.setEnabled(false);
		add(Get_money_TXT);

		
		JLabel mobile_lbl= new JLabel("Mobile:");
		mobile_lbl.setBounds(300,215,120,30);
		add(mobile_lbl);
		mobile_lbl.setForeground(Color.orange);

		
		Mobile_TXT.setBounds(390,215,120,30);
		Mobile_TXT.setEnabled(false);
		add(Mobile_TXT);
		
		del_BTN.setBounds(475, 320, 80, 30);
		del_BTN.setBackground(Color.GREEN);
		del_BTN.setFont(new Font("siref",Font.BOLD,14));
		add(del_BTN);
		
		back_BTN.setBounds(30, 320, 70, 30);
		back_BTN.setBackground(Color.red);
		add(back_BTN);
	
		del_BTN.addActionListener(this);
		back_BTN.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	public void delete_Method(){
		
		try {
			
    	 	Class.forName("org.sqlite.JDBC");
    	 	con=DriverManager.getConnection("jdbc:sqlite:infromation.db");
		
    	 	stmt=con.createStatement();
    	 	
    	 	
		
    	 	String delete =  "delete from infromation where card_number ='" + Card_num_TXT.getText() + "' and CVV_code ='"+CVV_TXT.getText()+"' ";
    	 	
    	 	
    	 	JOptionPane.showMessageDialog(null, "delete Data is Successful");
    	 	
            stmt.executeQuery(delete);
            
            
            stmt.close();
            con.close();

	       } 
	
	    catch (Exception e) {
	    	}	
	}
	
	
	public static void main(String[] args) {
        new resultdelete();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back_BTN){
			Delete_VisaCard del = new Delete_VisaCard();
			del.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource() == del_BTN){
			delete_Method();
			
			Delete_VisaCard del = new Delete_VisaCard();
			del.setVisible(true);
			setVisible(false);
		}
	}

}
