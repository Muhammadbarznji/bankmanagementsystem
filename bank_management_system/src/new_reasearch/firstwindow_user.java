package new_reasearch;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.omg.PortableInterceptor.USER_EXCEPTION;

public class firstwindow_user extends JFrame implements ActionListener{
	
	DecimalFormat myformat = new DecimalFormat("###,##0.00");
	
	JButton Ex_Change_BTN = new JButton("Click To ExChange");
	JButton Search_BTN = new JButton("Search");
	JButton Update_BTN = new JButton("Update");
	JButton send_BTN = new JButton("Email");
	JButton Logout_BTN = new JButton("Logout");
	
	JTextField t1 = new JTextField(10);
	JTextField t2 = new JTextField(10);
	
	JComboBox c1 = new JComboBox<>();
	JComboBox c2 = new JComboBox<>();
	
	currencies c = new currencies();	

	JLabel user_name_lbl_i = new JLabel("User Name:");
	JLabel user_name_lbl_ii = new JLabel();
		
	public firstwindow_user(){
		setLayout(null);
		setSize(630,400);
		setTitle("Currence Bank");
		setLocationRelativeTo(null);
		setResizable(false);
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\7.jpg")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
		
		
		Update_BTN.setBounds(150, 30, 80, 30);
		add(Update_BTN);
		
		Search_BTN.setBounds(250, 30, 80, 30);
		add(Search_BTN);
		
		send_BTN.setBounds(350, 30, 80, 30);
		add(send_BTN);
		
		
		JLabel l2 = new JLabel("Ammount");
		l2.setBounds(50,150,70,30);
		l2.setForeground(Color.RED);
		l2.setFont(new Font("siref",Font.BOLD,14));
		add(l2);
		
		t1.setBounds(120,150,70,30);
		add(t1);
		
		
		JLabel l3 = new JLabel("From");
		l3.setBounds(200,150,70,30);
		l3.setForeground(Color.RED);
		l3.setFont(new Font("siref",Font.BOLD,14));
		add(l3);
		
		c1.addItem("Money");
		c1.addItem("IQD");
		c1.addItem("USD");
		c1.addItem("EURO");
		c1.setBounds(240,150,140,30);
		add(c1);
		
		
		JLabel l1 = new JLabel("To");
		l1.setBounds(390,150,70,30);
		l1.setForeground(Color.RED);
		l1.setFont(new Font("siref",Font.BOLD,14));
		add(l1);
		
		c2.addItem("Money");
		c2.addItem("IQD");
		c2.addItem("USD");
		c2.addItem("EURO");
		c2.setBounds(420,150,130,30);
		add(c2);
		
		
		Ex_Change_BTN.setBounds(235,200,140,30);
		add(Ex_Change_BTN);
		
		
		t2.setBounds(235,240,140,30);
		add(t2);
		
		user_name_lbl_i.setBounds(20, 310, 70, 30);
		user_name_lbl_i.setFont(new Font("siref",Font.BOLD,12));
		user_name_lbl_i.setForeground(Color.RED);
		add(user_name_lbl_i);
		
		user_name_lbl_ii.setBounds(90, 310, 100, 30);
		user_name_lbl_ii.setForeground(Color.red);
		add(user_name_lbl_ii);
		
		Logout_BTN.setBounds(480, 310, 100, 30);
		Logout_BTN.setBackground(Color.red);
		Logout_BTN.setFont(new Font("siref",Font.BOLD,15));
		add(Logout_BTN);
		
		
		
		Ex_Change_BTN.addActionListener(this);
		Search_BTN.addActionListener(this);
		Update_BTN.addActionListener(this);
		send_BTN.addActionListener(this);
		Logout_BTN.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new firstwindow_user();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Ex_Change_BTN){
			if (c1.getSelectedIndex()==1 &&c2.getSelectedIndex()==2 ){
				String get = t1.getText();
				double iqd = c.getcurrencies("IQD","USD");
				double a = Double.parseDouble(get);
				double s= a/iqd;
				t2.setText(myformat.format(s));
			}}
		 if (e.getSource() == Ex_Change_BTN){
			if (c1.getSelectedIndex()==1 && c2.getSelectedIndex()==3 ){
				String get = t1.getText();
				double euro = c.getcurrencies("IQD","EUR");
				double a = Double.parseDouble(get);
				double s= a/euro;
				t2.setText(myformat.format(s));
			}}
			
		 	if (e.getSource() == Ex_Change_BTN){
		if (c1.getSelectedIndex()==2 && c2.getSelectedIndex()==1 ){
			String get = t1.getText();
			double usd = c.getcurrencies("USD","IQD");
			double a = Double.parseDouble(get);
			double s= a*usd;
			t2.setText(myformat.format(s));
		}}
		 if (e.getSource() == Ex_Change_BTN){
		 if (c1.getSelectedIndex()==2 && c2.getSelectedIndex()==3 ){
			String get = t1.getText();
			double euro = c.getcurrencies("USD","EUR");
			double a = Double.parseDouble(get);
			double s= a*euro;
			t2.setText(myformat.format(s));
		}}
		 if (e.getSource() == Ex_Change_BTN){
	      if (c1.getSelectedIndex()==3 && c2.getSelectedIndex()==1 ){
		String get = t1.getText();
		double iqd = c.getcurrencies("EUR","IQD");
		double a = Double.parseDouble(get);
		double s= a*iqd;
		t2.setText(myformat.format(s));
	}}
		 if (e.getSource() == Ex_Change_BTN){
		      if (c1.getSelectedIndex()==3 && c2.getSelectedIndex()==2 ){
			String get = t1.getText();
			double usd = c.getcurrencies("EUR","USD");
			double a = Double.parseDouble(get);
			double s= a*usd;
			t2.setText(myformat.format(s));
		}}
		 
		 
		 //ActionListener For Search Button
		 if (e.getSource() == Search_BTN){ 
			 search_user Search = new search_user();
			 Search.setVisible(true);
			 setVisible(false);
		 }
		 
		 //ActionListener For Update Button
		 if (e.getSource() == Update_BTN){
			 firstupdate_user Update = new firstupdate_user();
			 Update.setVisible(true);
			 setVisible(false);
		 }
		 
		 if(e.getSource() == Logout_BTN){
			 Login loging = new Login();
			 loging.setVisible(true);
			 setVisible(false);
		 }
		 
		 if(e.getSource() == send_BTN){
			 User_email email = new User_email();
			 email.setVisible(true);
			 setVisible(false);
		 }
			 
	}}
