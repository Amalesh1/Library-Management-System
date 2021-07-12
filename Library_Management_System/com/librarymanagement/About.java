package com.librarymanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn1;
	private JPanel panel;
	public About() {
		setBounds(500, 300, 750, 500);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\library.jfif");
		setIconImage(icon);
		setTitle("Smart Library");
		
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel l = new JLabel("");
		ImageIcon i1 = new ImageIcon("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\library.jfif");
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		l = new JLabel(i3);
		l.setBounds(305, 13, 100, 100);
		panel.add(l);
		
		JLabel l1 = new JLabel("Library Management System");
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Tahoma", Font.BOLD, 23));
		l1.setBounds(190, 120, 500, 40);
		panel.add(l1);
		
		JLabel l2 = new JLabel("Smart Library V-1.0");
		l2.setForeground(Color.BLUE);
		l2.setFont(new Font("Tahoma", Font.BOLD, 20));
		l2.setBounds(245, 160, 400, 30);
		panel.add(l2);
		
		JLabel l3 = new JLabel("Developed By : Amalesh Adhikary");
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Tahoma", Font.BOLD, 18));
		l3.setBounds(204, 210, 400, 30);
		panel.add(l3);
		
		JLabel l4 = new JLabel("Date : 11th July 2021");
		l4.setForeground(Color.BLUE);
		l4.setFont(new Font("Tahoma", Font.BOLD, 18));
		l4.setBounds(245, 260, 400, 30);
		panel.add(l4);
		
		JLabel l5 = new JLabel("Contact : amaleshadhikary499@gmail.com");
		l5.setForeground(Color.BLUE);
		l5.setFont(new Font("Tahoma", Font.BOLD, 17));
		l5.setBounds(184, 310, 400, 30);
		panel.add(l5);
		
		btn1 = new JButton("Back");
		btn1.setForeground(Color.RED);
		btn1.setBackground(Color.CYAN);
		btn1.setFont(new Font("Serif", Font.BOLD, 15));
		btn1.setBounds(300, 380, 100, 30);
		btn1.addActionListener(this);
		panel.add(btn1);
	}
	public static void main(String[] args) {
		
		new About().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btn1) {
			this.setVisible(false);
			new Home().setVisible(true);
		}
		
	}

}
