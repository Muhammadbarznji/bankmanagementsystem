//https://www.google.com/settings/security/lesssecureapps

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
import java.util.*;

import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class send_email_to_all extends JFrame implements ActionListener{
	
	Connection con = null;
	Statement stmt = null;

	JButton Back_BTN = new JButton("Back");
	JTextField TO = new JTextField(10);
	JTextField SUB = new JTextField(10);
	JTextArea M_TEXT = new JTextArea(5,10);
	JScrollPane S_P = new JScrollPane(M_TEXT);
	JButton send = new JButton("Send");
	
	String Email_srt = "";

	public  send_email_to_all(){
		setLayout(null);
		setSize(630,400);
		setTitle("Send Email To All Customer");
		setLocationRelativeTo(null);
		setResizable(false);
		
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Benayi\\workspace\\ReSearch\\e1.jpg")))));
		}
		catch(Exception e)
		{
			System.out.println("image dosnt exist");
		}
	
		JLabel to = new JLabel("TO:");
		to.setBounds(30,30,120,30);
		add(to);
		
		
		JLabel TOO = new JLabel("Sent To All Email");
		TOO.setBounds(100,30,300,30);
		TOO.setFont(new Font("serif",Font.BOLD,15));
		add(TOO);
	/*	TO.setBounds(100,50,300,30);
		TO.setText("To All Email");
		TO.setEditable(false);
		add(TO); */
		
		JLabel sub = new JLabel("Subject:");
		sub.setBounds(30,80,120,30);
		add(sub);
		
		SUB.setBounds(100,80,400,30);
		add(SUB);
		
		JLabel M_text = new JLabel("Messages:");
		M_text.setBounds(30,130,120,30);
		add(M_text);
		
		S_P.setBounds(100, 130, 400, 180);
		add(S_P);
		
		send.setBounds(530, 320, 70, 30);
		send.setBackground(Color.green);
		add(send);
		
		Back_BTN.setBounds(15, 320, 70, 30);
		Back_BTN.setBackground(Color.red);
		add(Back_BTN);
		
		Back_BTN.addActionListener(this);
		send.addActionListener(this);
		setVisible(true);
	}
	
	
	public void setEmail(){

		try {
			
			Class.forName("org.sqlite.JDBC");
			con=DriverManager.getConnection("jdbc:sqlite:infromation.db");
			stmt=con.createStatement();
			
			String select = "select * from infromation";
			ResultSet result = stmt.executeQuery(select);
			
			while(result.next()){
				this.Email_srt = result.getString(7);
				sed_mail_to_all();
			}
		} 
		catch (Exception e) {
			System.err.println(e.getClass().getName()+" &&&&&& "+e.getMessage());
		}
		
	}
	
	
	public void sed_mail_to_all() {
		try{
            String host ="smtp.gmail.com" ;
            String user = "chatemail17@gmail.com";
            String pass = "hama2017";
            String to = this.Email_srt;
            String from = "chatemail17@gmail.com";
            String subject = SUB.getText();
            String messageText = M_TEXT.getText();
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            System.out.println(to.toString());
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           JOptionPane.showMessageDialog(null, "Send Message is Successfull");
        }
		
		catch(Exception ex)
        {
	           JOptionPane.showMessageDialog(null, "No Internet Conection....!");

        }
		
	}
   
	
	public static void main(String args[]){
        new send_email_to_all();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if (e.getSource() == Back_BTN){
			first_email mail = new first_email();
			mail.setVisible(true);
			setVisible(false);
		}
		if (e.getSource()==send){
			if (SUB.getText().equals("") || M_TEXT.getText().equals("")){
				JOptionPane.showMessageDialog(null, "check Field");
			}
			
		else {
			
			try 
			{
				setEmail();
				
				TO.setText("");
				SUB.setText("");
				M_TEXT.setText("");
			}
			
			catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.toString());
			}
			}
		}
	}
}
