package com.librarymanagement;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class Loading extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JProgressBar progressBar;
	Connection conn;
	int i = 0, num=0;
	

	public Loading() {
		super("Processing");

		
		setBounds(600, 500, 550, 400);
		contentpane = new JPanel();
		
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel label = new JLabel("SMART LIBRARY 1.0");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Serif", Font.BOLD, 22));
		label.setBounds(150, 50, 500, 35);
		contentpane.add(label);
		
		progressBar = new JProgressBar();
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
		progressBar.setStringPainted(true);
		progressBar.setBounds(130, 115, 300, 25);
		contentpane.add(progressBar);
		
		JLabel label1 = new JLabel("Please Wait..........");
		label1.setForeground(Color.ORANGE);
		label1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label1.setBounds(200,  165, 150, 20);
		contentpane.add(label1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 550, 350);
		contentpane.add(panel);
		
		
	}
	public static void main(String[] args) {
		Loading ldng = new Loading();
		ldng.setVisible(true);
		ldng.iterate();
	}
	public void iterate() {
		while(i<=100) {
			progressBar.setValue(i);
			i=i+1;
			try {
				Thread.sleep(100);
			}
			catch(Exception exc){
				
			}
		}
		this.setVisible(false);
		new Home().setVisible(true);
		
	}

}
