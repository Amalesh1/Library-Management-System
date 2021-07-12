package com.librarymanagement;

import javax.swing.*;
import java.sql.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class AddBook extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JTextField t1, t2, t3, t4, t5, t6;
	private JButton b1, b2;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddBook() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\library.jfif");
		setIconImage(icon);
		setTitle("Smart Library 1.0");
		setBounds(600, 300, 520, 450);
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel l1 = new JLabel("Book Name ");
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(63, 60, 120, 22);
		contentpane.add(l1);
		
		JLabel l2 = new JLabel("ISBN");
		l2.setForeground(Color.BLUE);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(63, 90, 120, 22);
		contentpane.add(l2);
		
		JLabel l3 = new JLabel("Publisher");
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(63, 120, 120, 22);
		contentpane.add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setForeground(Color.BLUE);
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setBounds(63, 150, 120, 22);
		contentpane.add(l4);
		
		JLabel l5 = new JLabel("Pages");
		l5.setForeground(Color.BLUE);
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		l5.setBounds(63, 180, 120, 22);
		contentpane.add(l5);
		
		JLabel l6 = new JLabel("Book id");
		l6.setForeground(Color.BLUE);
		l6.setFont(new Font("Tahoma", Font.BOLD, 14));
		l6.setBounds(63, 210, 120, 22);
		contentpane.add(l6);
		
		JLabel l7 = new JLabel("Edition");
		l7.setForeground(Color.BLUE);
		l7.setFont(new Font("Tahoma", Font.BOLD, 14));
		l7.setBounds(63, 240, 120, 22);
		contentpane.add(l7);
		
		t1 = new JTextField();
		t1.setForeground(Color.GREEN);
		t1.setFont(new Font("san-serif", Font.BOLD, 14));
		t1.setBounds(180, 62, 180, 20);
		contentpane.add(t1);
		
		t2 = new JTextField();
		t2.setForeground(Color.GREEN);
		t2.setFont(new Font("san-serif", Font.BOLD, 14));
		t2.setBounds(180, 92, 180, 20);
		contentpane.add(t2);
		
		t3 = new JTextField();
		t3.setForeground(Color.GREEN);
		t3.setFont(new Font("san-serif", Font.BOLD, 14));
		t3.setBounds(180, 122, 180, 20);
		contentpane.add(t3);
		
		t4 = new JTextField();
		t4.setForeground(Color.GREEN);
		t4.setFont(new Font("san-serif", Font.BOLD, 14));
		t4.setBounds(180, 152, 180, 20);
		contentpane.add(t4);
		
		t5 = new JTextField();
		t5.setForeground(Color.GREEN);
		t5.setFont(new Font("san-serif", Font.BOLD, 14));
		t5.setBounds(180, 182, 180, 20);
		contentpane.add(t5);
		
		t6 = new JTextField();
		t6.setForeground(Color.GREEN);
		t6.setFont(new Font("san-serif", Font.BOLD, 14));
		t6.setBounds(180, 212, 180, 20);
		contentpane.add(t6);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox.setBounds(180, 242, 180, 20);
		contentpane.add(comboBox);
		
		b1 = new JButton("ADD");
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma", Font.BOLD, 15));
		b1.setBounds(102, 300, 105, 33);
		b1.setBackground(Color.CYAN);
		b1.setForeground(Color.BLUE);
		contentpane.add(b1);
		
		b2 = new JButton("BACK");
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma", Font.BOLD, 15));
		b2.setBounds(250, 300, 105, 33);
		b2.setBackground(Color.CYAN);
		b2.setForeground(Color.BLUE);
		contentpane.add(b2);
		
		random();
	}
	
	public void random() {
		Random rd = new Random();
		t6.setText("" + rd.nextInt(1000 + 1));
	}
	public static void main(String[] args) {
		new AddBook().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		try {
			Cons conn = new Cons();
			if(ev.getSource() == b1) {
				String sql = "insert into book(bookname, isbn, publisher, price, pagess, bookid, editionn) values (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement ps = conn.c.prepareStatement(sql);
				
				ps.setString(1, t1.getText());
				ps.setString(2, t2.getText());
				ps.setString(3, t3.getText());
				ps.setString(4, t4.getText());
				ps.setString(5, t5.getText());
				ps.setString(6, t6.getText());
				ps.setString(7, (String)comboBox.getSelectedItem());
				
				int rs = ps.executeUpdate();
				if(rs > 0) {
					JOptionPane.showMessageDialog(null, "Book Added Successfully");
				}
				else {
					JOptionPane.showMessageDialog(null, "Error!! Please try again");
					
				}
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				
				ps.close();
			}
			if(ev.getSource() == b2) {
				this.setVisible(false);
				new Home().setVisible(true);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
