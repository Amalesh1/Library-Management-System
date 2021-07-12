package com.librarymanagement;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

public class LoginWindow extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -961548924220167352L;
	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton b1, b2, b3;
	
	public LoginWindow() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\library.jfif");
		setIconImage(icon);
		setTitle("Smart Library 1.0");
		setBackground(Color.LIGHT_GRAY);
		setBounds(600, 300, 600, 400);
		setTitle("Login Form");

		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("Username");
		l1.setBounds(124, 89, 95, 26);
		panel.add(l1);
		
		JLabel l2 = new JLabel("Password");
		l2.setBounds(124, 124, 95, 26);
		panel.add(l2);
		
		textField = new JTextField();
		textField.setBounds(200, 89, 200, 26);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 124, 200, 26);
		panel.add(passwordField);
		
		b1 = new JButton("Register");
		b1.addActionListener(this);
		b1.setForeground(Color.BLUE);
		b1.setBackground(Color.GREEN);
		b1.setBounds(310, 181, 90, 35);
		panel.add(b1);
		
		b2 = new JButton("Login");
		b2.addActionListener(this);
		
		b2.setForeground(Color.BLUE);
		b2.setBackground(Color.ORANGE);
		b2.setBounds(200, 181, 90, 35);
		panel.add(b2);
		
		b3 = new JButton("Forgot Password");
		b3.addActionListener(this);
		
		b3.setForeground(Color.BLUE);
		b3.setBackground(Color.YELLOW);
		b3.setBounds(230, 250, 150, 35);
		panel.add(b3);
		
		JLabel l3 = new JLabel("Trouble in login");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setForeground(Color.RED);
		l3.setBounds(124, 250, 200, 35);
		panel.add(l3);
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == b1) {
			setVisible(false);
			Signup su = new Signup();
			su.setVisible(true);
		}
		if(ae.getSource() == b2) {
			try {
				Cons con = new Cons();
				String sql = "select * from account where username=? and password1=?";
				PreparedStatement st = con.c.prepareStatement(sql);
				
				st.setString(1, textField.getText());
				st.setString(2, passwordField.getText());
				
				ResultSet rs = st.executeQuery();
				if(rs.next()) {
					this.setVisible(false);
					new Loading().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Login");
				}
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(ae.getSource() == b3) {
			setVisible(false);
			Forgot forgot = new Forgot();
			forgot.setVisible(true);
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public  void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

}
