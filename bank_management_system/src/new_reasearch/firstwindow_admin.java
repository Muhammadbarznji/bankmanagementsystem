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

public class firstwindow_admin extends JFrame implements ActionListener{
	
	DecimalFormat myformat = new DecimalFormat("###,##0.00");
	
	JButton Ex_Change_BTN = new JButton("Click To ExChange");
	JButton Search_BTN = new JButton("Search");
	JButton Update_BTN = new JButton("Update");
	JButton Logout_BTN = new JButton("Logout");
	JButton Add_BTN = new JButton("ADD");
	JButton Delete_BTN = new JButton("Delete");
	JButton show_BTN = new JButton("Show");
	JButton send_BTN = new JButton("Email");

	JTextField t1 = new JTextField(10);
	JTextField t2 = new JTextField(10);
	
	JComboBox c1 = new JComboBox<>();
	JComboBox c2 = new JComboBox<>();
	
	currencies c = new currencies();

	public firstwindow_admin(){
		setLayout(null);
		setSize(630,400);
		setTitle("Currence Bank Admin");
		setLocationRelativeTo(null);
		setResizable(false);
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\7.jpg")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
		
		Add_BTN.setBounds(20, 30, 80, 30);
		add(Add_BTN);
		
		Search_BTN.setBounds(120, 30, 80, 30);
		add(Search_BTN);
		
		
		Update_BTN.setBounds(220, 30, 80, 30);
		add(Update_BTN);
		
		Delete_BTN.setBounds(320, 30, 80, 30);
		add(Delete_BTN);
		
		show_BTN.setBounds(420, 30, 80, 30);
		add(show_BTN);
		
		send_BTN.setBounds(520, 30, 80, 30);
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
		
		
		Ex_Change_BTN.setBounds(240,200,140,30);
		add(Ex_Change_BTN);
		
		
		t2.setBounds(240,240,140,30);
		add(t2);
		
		
		Logout_BTN.setBounds(480, 310, 100, 30);
		Logout_BTN.setBackground(Color.red);
		Logout_BTN.setFont(new Font("siref",Font.BOLD,15));
		add(Logout_BTN);
		
		
		
		Ex_Change_BTN.addActionListener(this);
		Add_BTN.addActionListener(this);
		Search_BTN.addActionListener(this);
		Update_BTN.addActionListener(this);
		Logout_BTN.addActionListener(this);
		Delete_BTN.addActionListener(this);
		show_BTN.addActionListener(this);
		send_BTN.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new firstwindow_admin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		try{
		
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
		
		}
		catch (Exception ee) {
			JOptionPane.showMessageDialog(null, ee.getMessage());
		}
		 
		 
		 if(e.getSource() == Add_BTN){
			 add add = new add();
			 add.setVisible(true);
			 setVisible(false);
		 }
		 
		 //ActionListener For Search Button
		 if (e.getSource() == Search_BTN){
			 search Search = new search();
			 Search.setVisible(true);
			 setVisible(false);
		 }
		 
		 //ActionListener For Update Button
		 if (e.getSource() == Update_BTN){
			 firstupdate Update = new firstupdate();
			 Update.setVisible(true);
			 setVisible(false);
		 }
		 
		 if(e.getSource() == Delete_BTN){
			 delete del = new delete();
			 del.setVisible(true);
			 setVisible(false);
		 }
		 
		 if (e.getSource()== send_BTN){
			 first_email mail = new first_email();
			 mail.setVisible(true);
			 setVisible(false);
			 
		 }
		 if (e.getSource()== show_BTN){
			 show show = new show();
			 show.setVisible(true);
			 setVisible(false);
			 
		 }
		 if(e.getSource() == Logout_BTN){
			 Login loging = new Login();
			 loging.setVisible(true);
			 setVisible(false);
		 }
			 
	}}


