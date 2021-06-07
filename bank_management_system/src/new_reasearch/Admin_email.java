package new_reasearch;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Admin_email extends JFrame implements ActionListener{

	JTextField TO = new JTextField(10);
	JTextField SUB = new JTextField(10);
	JTextArea M_TEXT = new JTextArea(5,10);
	JScrollPane S_P = new JScrollPane(M_TEXT);
	JButton send = new JButton("Send");
	JButton BTN_back = new JButton("Back");

	public  Admin_email(){
		setLayout(null);
		setSize(630,400);
		setTitle("Send Email");
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
		to.setFont(new Font("siref",Font.BOLD,13));
		add(to);
		
		TO.setBounds(100,30,300,30);
		add(TO);
		
		JLabel sub = new JLabel("Subject:");
		sub.setFont(new Font("siref",Font.BOLD,13));
		sub.setBounds(30,80,120,30);
		add(sub);
		
		SUB.setBounds(100,80,300,30);
		add(SUB);
		
		JLabel M_text = new JLabel("Messages:");
		M_text.setFont(new Font("siref",Font.BOLD,13));
		M_text.setBounds(30,130,120,30);
		add(M_text);
		
		S_P.setBounds(100, 130, 400, 180);
		add(S_P);
		
		send.setBounds(530, 320, 70, 30);
		send.setBackground(Color.green);
		add(send);
		
		BTN_back.setBounds(20,320,70,30);
		BTN_back.setBackground(Color.red);
		add(BTN_back);
		
		send.addActionListener(this);
		BTN_back.addActionListener(this);
		setVisible(true);
	}
	
	
	public void sed_mail(){
	
		try{
			
		
            String host ="smtp.gmail.com" ;
            String user = "chatemail17@gmail.com";
            String pass = "hama2017";
            
            String from = "chatemail17@gmail.com";
            String to = TO.getText();
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
        new Admin_email();

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==BTN_back){
			first_email back = new first_email();
			back.setVisible(true);
			setVisible(false);
		}
		if (e.getSource()==send){
			if (TO.getText().equals("") || SUB.getText().equals("") || M_TEXT.getText().equals("")){
				JOptionPane.showMessageDialog(null, "check Field");
			}
			
		else {
			try 
			{
				sed_mail();	
				
				TO.setText("");
				SUB.setText("");
				M_TEXT.setText("");
			}
			catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
		}		
	}}
}
