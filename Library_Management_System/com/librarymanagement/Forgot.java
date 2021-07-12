package com.librarymanagement;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Forgot extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane1;
	private JTextField t1, t2, t3, t4, t5;
	private JButton b1, b2, b3;
	
	
	public static void main(String[] args) {
		new Forgot().setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		try {
			Cons conn = new Cons();
			if(ev.getSource() == b1) {
				String sql = "Select * from account where username=?";
				PreparedStatement st = conn.c.prepareStatement(sql);
				
				st.setString(1, t1.getText());
				ResultSet rs = st.executeQuery();
				
				while(rs.next()) {
					t2.setText(rs.getString("name1"));
					t3.setText(rs.getString("question"));
				}
				
			}
			if(ev.getSource() == b2) {
				String sql = "select * from account where answer = ?";
				PreparedStatement st = conn.c.prepareStatement(sql);
				
				st.setString(1, t4.getText());
				ResultSet rs = st.executeQuery();
				
				while(rs.next()) {
					t5.setText(rs.getString("password1"));
				}
			}
			if(ev.getSource() == b3) {
				this.setVisible(false);
				new LoginWindow().setVisible(true);
			}
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
	public Forgot() {
		setTitle("Forgot Password");
		setBounds(500, 200, 600, 500);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setBackground(Color.WHITE);
		contentPane1.setLayout(null);
		
		JLabel l1 = new JLabel("Username : ");
		l1.setFont(new Font("Tahoma", Font.BOLD, 13));
		l1.setBounds(109, 83, 87, 21);
		contentPane1.add(l1);
		
		JLabel l2 = new JLabel("Name : ");
		l2.setFont(new Font("Tahoma", Font.BOLD, 13));
		l2.setBounds(109, 122, 75, 21);
		contentPane1.add(l2);
		
		JLabel l3 = new JLabel("Your Security Question: ");
		l3.setFont(new Font("Tahoma", Font.BOLD, 13));
		l3.setBounds(109, 154, 174, 27);
		contentPane1.add(l3);
		
		JLabel l4 = new JLabel("Answer : ");
		l4.setFont(new Font("Tahoma", Font.BOLD, 13));
		l4.setBounds(109, 192, 104, 27);
		contentPane1.add(l4);
		
		JLabel l5 = new JLabel("Password : ");
		l5.setFont(new Font("Tahoma", Font.BOLD, 13));
		l5.setBounds(109, 224, 104, 27);
		contentPane1.add(l5);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 13));
		t1.setForeground(Color.BLUE);
		t1.setColumns(10);
		t1.setBounds(277, 88, 139, 20);
		contentPane1.add(t1);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 13));
		t2.setForeground(Color.BLUE);
		t2.setColumns(10);
		t2.setBounds(277, 123, 139, 20);
		contentPane1.add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 13));
		t3.setForeground(Color.BLUE);
		t3.setColumns(10);
		t3.setBounds(277, 161, 139, 20);
		contentPane1.add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 13));
		t4.setForeground(Color.BLUE);
		t4.setColumns(10);
		t4.setBounds(277, 193, 139, 20);
		contentPane1.add(t4);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.BOLD, 13));
		t5.setForeground(Color.BLUE);
		t5.setColumns(10);
		t5.setBounds(277, 225, 139, 20);
		contentPane1.add(t5);
		
		b1 = new JButton("Search");
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.setBounds(431, 83, 80, 29);
		b1.setForeground(Color.BLUE);
		b1.setForeground(Color.GREEN);
		contentPane1.add(b1);
		
		b2 = new JButton("Retrieve");
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma", Font.BOLD, 12));
		b2.setBounds(431, 190, 85, 29);
		b2.setForeground(Color.BLUE);
		b2.setForeground(Color.GREEN);
		contentPane1.add(b2);
		
		b3 = new JButton("Back");
		b3.addActionListener(this);
		b3.setFont(new Font("Tahoma", Font.BOLD, 12));
		b3.setBounds(233, 270, 101, 29);
		b3.setForeground(Color.BLUE);
		b3.setForeground(Color.RED);
		contentPane1.add(b3);
		
		JPanel pan = new JPanel();
		pan.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 2), "Forgot Password", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		pan.setBounds(47, 43, 500, 281);
		contentPane1.add(pan);
		
		
	}

}
