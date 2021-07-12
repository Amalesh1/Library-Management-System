package com.librarymanagement;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

@SuppressWarnings("serial")
public class AddStudent extends JFrame implements ActionListener{
	
	private JPanel contentpane;
	private JButton bt1, bt2;
	private JTextField t1, t2, t3, t4, t5;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox, comboBox1;
	
	public void random() {
		Random rd = new Random();
		t3.setText("" + rd.nextInt(10000 + 1));
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddStudent() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\library.jfif");
		setIconImage(icon);
		setTitle("Smart Library");
		setBounds(700, 300, 550, 450);
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel l1 = new JLabel("Name: ");
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(60, 50, 100, 20);
		contentpane.add(l1);
		
		JLabel l2 = new JLabel("Roll: ");
		l2.setForeground(Color.BLUE);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(60, 80, 100, 20);
		contentpane.add(l2);
		
		JLabel l3 = new JLabel("Library Id no: ");
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(60, 110, 100, 20);
		contentpane.add(l3);
		
		JLabel l4 = new JLabel("Email: ");
		l4.setForeground(Color.BLUE);
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setBounds(60, 140, 100, 20);
		contentpane.add(l4);
		
		JLabel l5 = new JLabel("Phone: ");
		l5.setForeground(Color.BLUE);
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		l5.setBounds(60, 170, 100, 20);
		contentpane.add(l5);
		
		JLabel l6 = new JLabel("Dept: ");
		l6.setForeground(Color.BLUE);
		l6.setFont(new Font("Tahoma", Font.BOLD, 14));
		l6.setBounds(60, 200, 100, 20);
		contentpane.add(l6);
		
		JLabel l7 = new JLabel("Semester: ");
		l7.setForeground(Color.BLUE);
		l7.setFont(new Font("Tahoma", Font.BOLD, 14));
		l7.setBounds(60, 230, 100, 20);
		contentpane.add(l7);
		
		t1 = new JTextField();
		t1.setForeground(Color.ORANGE);
		t1.setFont(new Font("Serif", Font.BOLD, 14));
		t1.setBounds(180, 50, 200, 22);
		contentpane.add(t1);
		
		t2 = new JTextField();
		t2.setForeground(Color.ORANGE);
		t2.setFont(new Font("Serif", Font.BOLD, 14));
		t2.setBounds(180, 80, 200, 22);
		contentpane.add(t2);
		
		t3 = new JTextField();
		t3.setForeground(Color.ORANGE);
		t3.setFont(new Font("Serif", Font.BOLD, 14));
		t3.setBounds(180, 110, 200, 22);
		contentpane.add(t3);
		
		t4 = new JTextField();
		t4.setForeground(Color.ORANGE);
		t4.setFont(new Font("Serif", Font.BOLD, 14));
		t4.setBounds(180, 140, 200, 22);
		contentpane.add(t4);
		
		t5 = new JTextField();
		t5.setForeground(Color.ORANGE);
		t5.setFont(new Font("Serif", Font.BOLD, 14));
		t5.setBounds(180, 170, 200, 22);
		contentpane.add(t5);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CSE", "ECE", "ME", "CE", "EE"}));
		comboBox.setBounds(180, 200, 200, 22);
		contentpane.add(comboBox);
		
		comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
		comboBox1.setBounds(180, 230, 200, 22);
		contentpane.add(comboBox1);
		
		bt1 = new JButton("ADD STUDENT");
		bt1.addActionListener(this);
		bt1.setBackground(Color.GREEN);
		bt1.setForeground(Color.BLUE);
		bt1.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt1.setBounds(100, 300, 150, 40);
		contentpane.add(bt1);
		
		bt2 = new JButton("Back");
		bt2.addActionListener(this);
		bt2.setBackground(Color.YELLOW);
		bt2.setForeground(Color.BLUE);
		bt2.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt2.setBounds(300, 300, 100, 40);
		contentpane.add(bt2);
		
		random();
	}
	public static void main(String[] args) {
		
		new AddStudent().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Cons connect = new Cons();
			if(e.getSource() == bt1) {
				String sql = "insert into studentdetails(namee, roll, libidno, email, phone, dept, semester) values(?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement st = connect.c.prepareStatement(sql);
				
				st.setString(1, t1.getText());
				st.setString(2, t2.getText());
				st.setString(3, t3.getText());
				st.setString(4, t4.getText());
				st.setString(5, t5.getText());
				st.setString(6, (String) comboBox.getSelectedItem());
				st.setString(7, (String) comboBox1.getSelectedItem());
				
				int rs = st.executeUpdate();
				if(rs > 0) {
					JOptionPane.showMessageDialog(null, "Student Added Successfully");
				}
				else {
					JOptionPane.showMessageDialog(null, "Error!! Contact a Technician");
				}
			}
			
		}catch(Exception ev) {
			ev.printStackTrace();
		}
		
	}

}
