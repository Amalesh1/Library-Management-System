package com.librarymanagement;

// Including Required Packages
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Statistics extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTable table;
	private JTable table1;
	
	// Creating a constructor 
	public Statistics (){
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\library.jfif");
		setIconImage(icon);
		setTitle("Smart Library 1.0");
		setBounds(400, 200, 800, 670);
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel l = new JLabel("Statistics");
		l.setForeground(Color.RED);
		l.setFont(new Font("Tahoma", Font.BOLD, 20));
		l.setBounds(350, 14, 150, 20);
		panel.add(l);
		
		JScrollPane scrlpane = new JScrollPane();
		scrlpane.setBounds(40, 55, 710, 230);
		panel.add(scrlpane);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.BLUE);
		table.setFont(new Font("Serif", Font.PLAIN, 15));
		scrlpane.setViewportView(table);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 2, true), "Details of Book Issued", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(26, 36, 737, 264);
		panel.add(panel1);
		
		JLabel l1 = new JLabel("Back");
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Georgia", Font.BOLD, 15));
		l1.setBounds(690, 13, 96, 27);
		l1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		panel.add(l1);
		
		JScrollPane scrlPane1 = new JScrollPane();
		scrlPane1.setBounds(40, 360, 710, 230);
		panel.add(scrlPane1);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 2, true), "Details of Book Returned", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(26, 342, 737, 264);
		panel.add(panel2);
		
		table1 = new JTable();
		table1.setBackground(Color.LIGHT_GRAY);
		table1.setForeground(Color.BLUE);
		table1.setFont(new Font("Serif" , Font.PLAIN, 15));
		scrlPane1.add(table1);
		
		bookIssued();
		bookReturned();
	}
	
	private void bookReturned() {
		try {
			
			Cons conn = new Cons();
			String query = "select * from returnbook";
			PreparedStatement ps = conn.c.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			table1.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

	private void bookIssued() {
		
		try {
			Cons connect = new Cons();
			String query = "select * from issuebook";
			PreparedStatement ps;
			ps = connect.c.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
	
		// Creating a object of Statistics
		Statistics st = new Statistics();
		st.setVisible(true);

	}
	
}
