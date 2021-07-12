package com.librarymanagement;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

import net.proteanit.sql.DbUtils;

public class BookDetails extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JTable table;
	private JTextField search;
	private JButton b1, b2;
	
	public BookDetails() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\library.jfif");
		setIconImage(icon);
		setTitle("Smart Library 1.0");
		setBounds(400, 300, 850, 450);
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(34, 133, 770, 242);
		contentpane.add(scrollpane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				int row = table.getSelectedRow();
				search.setText(table.getModel().getValueAt(row, 0).toString());
				
			}
		});
		table.setBackground(Color.GRAY);
		table.setForeground(Color.BLUE);
		table.setFont(new Font("Serif", Font.BOLD, 16));
		scrollpane.setViewportView(table);
		
		b1 = new JButton("Search");
		b1.addActionListener(this);
		b1.setBorder(new LineBorder(Color.GREEN, 2, true));
		b1.setForeground(Color.BLUE);
		b1.setBounds(564, 69, 120, 33);
		contentpane.add(b1);
		
		b2 = new JButton("Delete");
		b2.addActionListener(this);
		b2.setBorder(new LineBorder(Color.GREEN, 2, true));
		b2.setForeground(Color.BLUE);
		b2.setBounds(690, 69, 120, 33);
		contentpane.add(b2);
		
		search = new JTextField();
		search.setBackground(Color.WHITE);
		search.setForeground(Color.RED);
		search.setFont(new Font("Tahoma", Font.BOLD, 14));
		search.setBounds(150, 72, 400, 28);
		search.setColumns(10);
		contentpane.add(search);
		
		JLabel l1 = new JLabel("BOOK DETAILS");
		l1.setForeground(Color.GREEN);
		l1.setBackground(Color.GRAY);
		l1.setFont(new Font("Tahoma", Font.BOLD, 18));
		l1.setBounds(350, 10, 250, 50);
		contentpane.add(l1);
		
		JLabel l2 = new JLabel("Back");
		l2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me1) {
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		l2.setForeground(Color.RED);
		l2.setBounds(97, 69, 72, 33);
		contentpane.add(l2);
		Book();
	}
	
	public void Book() {
		try {
			Cons conn = new Cons();
			String sql= "select * from book";
			PreparedStatement ps = conn.c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			conn.c.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new BookDetails().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		try {
			Cons conn = new Cons();
			if(evt.getSource() == b2) {
				String sql = "delete from book where bookname= '" + search.getText() +"'";
				PreparedStatement ps = conn.c.prepareStatement(sql);
				
				JDialog.setDefaultLookAndFeelDecorated(true);
				int response = JOptionPane.showConfirmDialog(null, "Do you want remove this book?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					@SuppressWarnings("unused")
					int rs = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Successfully Deleted");
				}
				else if(response == JOptionPane.NO_OPTION) {
					
				}
				else if(response == JOptionPane.CLOSED_OPTION) {
					
				}
				ps.close();
				
			}
			if(evt.getSource() == b1) {
				String sql = "select * from book where concat(bookname, bookid) like ?";
				PreparedStatement st = conn.c.prepareStatement(sql);
				st.setString(1, "%" + search.getText() + "%");
				ResultSet rs = st.executeQuery();
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
