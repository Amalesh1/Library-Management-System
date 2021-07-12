package com.librarymanagement;

// Importing required packages

import javax.swing.*;
import javax.swing.border.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

// creating the class Return Book

public class ReturnBook extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	private JButton btn1, btn2, btn3;
	private JDateChooser dateChooser;
	
	// Creating the Constructor
	public ReturnBook() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\library.jfif");
		setIconImage(icon);
		setTitle("Smart Library 1.0");
		setBounds(500, 350, 700, 370);
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel l1 = new JLabel("Book Id");
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Serif", Font.BOLD, 15));
		l1.setBounds(30, 50, 90, 25);
		contentpane.add(l1);
		
		JLabel l2 = new JLabel("Roll No");
		l2.setForeground(Color.BLUE);
		l2.setFont(new Font("Serif", Font.BOLD, 15));
		l2.setBounds(300, 50, 90, 25);
		contentpane.add(l2);
		
		JLabel l3 = new JLabel("Book Name");
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Serif", Font.BOLD, 15));
		l3.setBounds(30, 85, 90, 25);
		contentpane.add(l3);
		
		JLabel l4 = new JLabel("Name");
		l4.setForeground(Color.BLUE);
		l4.setFont(new Font("Serif", Font.BOLD, 15));
		l4.setBounds(300, 85, 90, 25);
		contentpane.add(l4);
		
		JLabel l5 = new JLabel("Semester");
		l5.setForeground(Color.BLUE);
		l5.setFont(new Font("Serif", Font.BOLD, 15));
		l5.setBounds(30, 120, 90, 25);
		contentpane.add(l5);
		
		JLabel l6 = new JLabel("Dept");
		l6.setForeground(Color.BLUE);
		l6.setFont(new Font("Serif", Font.BOLD, 15));
		l6.setBounds(300, 120, 90, 25);
		contentpane.add(l6);
		
		JLabel l7 = new JLabel("Date Of Issue");
		l7.setForeground(Color.BLUE);
		l7.setFont(new Font("Serif", Font.BOLD, 15));
		l7.setBounds(30, 155, 110, 25);
		contentpane.add(l7);
		
		JLabel l8 = new JLabel("Return Date");
		l8.setForeground(Color.BLUE);
		l8.setFont(new Font("Serif", Font.BOLD, 15));
		l8.setBounds(300, 155, 90, 25);
		contentpane.add(l8);
		
		tf1 = new JTextField();
		tf1.setForeground(Color.RED);
		tf1.setFont(new Font("Tahoma", Font.BOLD, 14));
		tf1.setBounds(135, 50, 140, 25);
		contentpane.add(tf1);
		
		tf2 = new JTextField();
		tf2.setForeground(Color.RED);
		tf2.setFont(new Font("Serif", Font.BOLD, 14));
		tf2.setBounds(390, 50, 140, 25);
		contentpane.add(tf2);
		
		btn1 = new JButton("Search");
		btn1.setForeground(Color.BLUE);
		btn1.setBackground(Color.YELLOW);
		btn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn1.setBounds(550, 45, 95, 33);
		btn1.addActionListener(this);
		contentpane.add(btn1);
		
		tf3 = new JTextField();
		tf3.setForeground(Color.RED);
		tf3.setFont(new Font("Serif", Font.BOLD, 14));
		tf3.setBounds(135, 85, 140, 25);
		contentpane.add(tf3);
		
		tf4 = new JTextField();
		tf4.setForeground(Color.RED);
		tf4.setFont(new Font("Serif", Font.BOLD, 14));
		tf4.setBounds(390, 85, 140, 25);
		contentpane.add(tf4);
		
		tf5 = new JTextField();
		tf5.setForeground(Color.RED);
		tf5.setFont(new Font("Serif", Font.BOLD, 14));
		tf5.setBounds(135, 120, 140, 25);
		contentpane.add(tf5);
		
		tf6 = new JTextField();
		tf6.setForeground(Color.RED);
		tf6.setFont(new Font("Serif", Font.BOLD, 14));
		tf6.setBounds(390, 120, 140, 25);
		contentpane.add(tf6);
		
		tf7 = new JTextField();
		tf7.setForeground(Color.RED);
		tf7.setFont(new Font("Serif", Font.BOLD, 14));
		tf7.setBounds(135, 155, 140, 25);
		contentpane.add(tf7);
		
		dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(Color.BLUE, 0, true));
		dateChooser.setBounds(390, 155, 140, 25);
		contentpane.add(dateChooser);
		
		btn2 = new JButton("Return");
		btn2.setForeground(Color.BLUE);
		btn2.setBackground(Color.YELLOW);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn2.setBounds(150, 240, 95, 33);
		btn2.addActionListener(this);
		contentpane.add(btn2);
		
		btn3 = new JButton("Back");
		btn3.setForeground(Color.BLUE);
		btn3.setBackground(Color.YELLOW);
		btn3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn3.setBounds(400, 240, 95, 33);
		btn3.addActionListener(this);
		contentpane.add(btn3);
	}
	
	// Main Method
	public static void main(String[] args) {
		
		// Calling the constructor
		new ReturnBook().setVisible(true);
	}
	
	// creating remove method 
	public void remove() {
		try {
			Cons conn = new Cons();
			String query = "delete from issuebook where bookid = ?" ;
			PreparedStatement ps = conn.c.prepareStatement(query);
			ps.setString(1, tf1.getText());
			int rs = ps.executeUpdate();
			if(rs > 0) 
			{
				JOptionPane.showConfirmDialog(null, "Return Book ?");
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Error! Something Went Wrong");
			}
		}
		catch(SQLException exc)
		{
			JOptionPane.showMessageDialog(null, exc);
			exc.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
			if(evt.getSource() == btn1) {
				try {
					Cons conn = new Cons();
					String query = "select * from issuebook where bookid = ? and roll = ?";
					PreparedStatement ps = conn.c.prepareStatement(query);
					ps.setString(1, tf1.getText());
					ps.setString(2, tf2.getText());
					ResultSet rs = ps.executeQuery();
				
					while(rs.next()) {
						tf3.setText(rs.getString("bookname"));
						tf4.setText(rs.getString("studentname"));
						tf5.setText(rs.getString("semester"));
						tf6.setText(rs.getString("dept"));
						tf7.setText(rs.getString("dateofissue"));
					}
					ps.close();
					conn.c.close();
				}catch(Exception exc) {
					
				}
			}
			if(evt.getSource() == btn2) {
				try {
					Cons conn = new Cons();
					String query1 = "insert into returnbook (bookid, roll, bookname, studentname, semester, dept, dateofissue, returndate) values (?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement ps = conn.c.prepareStatement(query1);
					ps.setString(1, tf1.getText());
					ps.setString(2, tf2.getText());
					ps.setString(3, tf3.getText());
					ps.setString(4, tf4.getText());
					ps.setString(5, tf5.getText());
					ps.setString(6, tf6.getText());
					ps.setString(7, tf7.getText());
					ps.setString(8, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
				
					int rs = ps.executeUpdate();
					if(rs > 0) {
						JOptionPane.showMessageDialog(null, "Processing");
						remove();
					}else {
						JOptionPane.showMessageDialog(null, "Error!!!");
					}
				}catch(Exception exc) {
					
				}
			if(evt.getSource() == btn3) {
				this.setVisible(false);
				new Home().setVisible(true);
			}
			
		}
	}

}
