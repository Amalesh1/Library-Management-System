package com.librarymanagement;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton b1, b2;
	private JTable table;
	private JPanel contentPane;
	private JTextField search;
	
	
	
	
	
	public static void main(String[] args) {
		new StudentDetails().setVisible(true);
	}
	public void student() {
		try {
			
			Cons conn = new Cons();
			String sql = "select * from studentdetails";
			PreparedStatement ps = conn.c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			conn.c.close();
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	public StudentDetails() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\library.jfif");
		setIconImage(icon);
		setTitle("Smart Library");
		setBounds(400, 300, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollP = new JScrollPane();
		scrollP.setBounds(80, 130, 730, 300);
		contentPane.add(scrollP);
		
		search = new JTextField();
		search.setBackground(Color.LIGHT_GRAY);
		search.setForeground(Color.BLUE);
		search.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 14));
		search.setBounds(180, 70, 360, 34);
		contentPane.add(search);
		search.setColumns(10);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				int row = table.getSelectedRow();
				search.setText(table.getModel().getValueAt(row, 0).toString());
			}
		});
		table.setBackground(Color.CYAN);
		table.setForeground(Color.RED);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollP.setViewportView(table);;
		
		b1 = new JButton("SEARCH");
		b1.addActionListener(this);
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.BLUE);
		b1.setFont(new Font("Tahoma", Font.BOLD, 16));
		b1.setBounds(550, 68, 120, 35);
		contentPane.add(b1);
		
		b2 = new JButton("DELETE");
		b2.addActionListener(this);
		b2.setBackground(Color.YELLOW);
		b2.setForeground(Color.RED);
		b2.setFont(new Font("Tahoma", Font.BOLD, 16));
		b2.setBounds(690, 68, 120, 35);
		contentPane.add(b2);
		
		JLabel lbl = new JLabel("BACK");
		lbl.setForeground(Color.BLUE);
		lbl.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lbl.setBounds(80, 68, 80, 35);
		lbl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		contentPane.add(lbl);
		
		JLabel lbl1 = new JLabel("-----Student Details-----");
		lbl1.setForeground(Color.RED);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbl1.setBounds(280, 10, 350, 50);
		contentPane.add(lbl1);
		
		student();
	}
	@Override
	public void actionPerformed(ActionEvent Aevt) {
		try {
			Cons connection = new Cons();
			if(Aevt.getSource() == b1) {
				String query = "select * from studentdetails where concat(namee, roll) like ?";
				PreparedStatement ps = connection.c.prepareStatement(query);
				ps.setString(1, "%" + search.getText() + "%");
				ResultSet rs = ps.executeQuery();
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				
			}
			if(Aevt.getSource() == b2) {
				String query = "delete from studentdetails where namee = '" + search.getText() + "'";
				PreparedStatement ps = connection.c.prepareStatement(query);
				
				JDialog.setDefaultLookAndFeelDecorated(true);
				int response = JOptionPane.showConfirmDialog(null, "Do you want to remove the student?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.NO_OPTION) {
					
				}
				else if(response == JOptionPane.YES_OPTION)
				{
					@SuppressWarnings("unused")
					int i = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Successfully removed!");
				}
				else if(response == JOptionPane.CANCEL_OPTION)
				{
					
				}
			}
			
			
		}
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
		
	}


}
