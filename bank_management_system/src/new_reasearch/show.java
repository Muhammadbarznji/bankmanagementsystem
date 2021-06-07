package new_reasearch;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.TableColumn;

public class show extends JFrame implements ActionListener {
	Vector columnNames = new Vector();
	Vector data = new Vector();
	JButton back_btn = new JButton("Back");
	public show(){
		try {
		Class.forName("org.sqlite.JDBC");
		Connection con = DriverManager.getConnection("jdbc:sqlite:infromation.db");
		String sql = "Select * from infromation";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery( sql );
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		for (int i = 1; i <= columns; i++) {
		columnNames.addElement( md.getColumnName(i) );
		}
		while (rs.next()) {
		Vector row = new Vector(columns);
		for (int i = 1; i <= columns; i++){
		row.addElement( rs.getObject(i) );
		}
		data.addElement( row );
		}
		rs.close();
		stmt.close();
		}
		catch(Exception e){
		System.out.println(e);
		}
		JTable table = new JTable(data, columnNames);
		table.setEnabled(false);
		
		TableColumn col;
		for (int i = 0; i < table.getColumnCount(); i++) {
		col = table.getColumnModel().getColumn(i);
		col.setMaxWidth(800);
		}
		
		JScrollPane scrollPane = new JScrollPane( table );
		setLayout( null);
		setBackground(Color.WHITE);
		setTitle("Show Data");
		getContentPane().setBackground(Color.cyan);
		add(scrollPane);
		scrollPane.setBounds(20, 30, 750, 400);
		
		add(back_btn);
		back_btn.setBackground(Color.red);
		back_btn.setBounds(10, 435, 80, 30);
		
		
		back_btn.addActionListener(this);
		
		setSize(800,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}	
	public static void main(String[] args) {
new show();
}
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == back_btn){
		firstwindow_admin b_k = new firstwindow_admin();
		b_k.setVisible(true);
		setVisible(false);
	}
}

}

