package com.librarymanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Home extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JButton b1, b2, b3, b4, b5, b6;
	
	public Home() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\library.jfif");
		setIconImage(icon);
		setTitle("HOME");
		setBounds(400, 150, 1000, 700);
		contentpane = new JPanel();
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.ORANGE));
		menuBar.setBackground(Color.CYAN);
		menuBar.setBounds(0, 10, 1000, 35);
		contentpane.add(menuBar);
		
		JMenu mnExit = new JMenu("EXIT");
		mnExit.setFont(new Font("Serif", Font.ITALIC, 17));
		
		JMenuItem itemLogout = new JMenuItem("LOGOUT");
		itemLogout.setBackground(Color.GRAY);
		itemLogout.setForeground(Color.BLUE);
		itemLogout.addActionListener(this);
		mnExit.add(itemLogout);
		
		JMenuItem itExit = new JMenuItem("EXIT");
		itExit.setBackground(Color.GRAY);
		itExit.setForeground(Color.BLUE);
		itExit.addActionListener(this);
		mnExit.add(itExit);
		
		JMenu mnHelp = new JMenu("HELP");
		mnHelp.setFont(new Font("Serif", Font.ITALIC, 17));
		
		JMenuItem itemReadMe = new JMenuItem("READ ME");
		itemReadMe.setBackground(Color.GRAY);
		itemReadMe.setForeground(Color.BLUE);
		itemReadMe.addActionListener(this);
		mnHelp.add(itemReadMe);
		
		JMenuItem itemAbout = new JMenuItem("ABOUT US");
		itemAbout.setBackground(Color.GRAY);
		itemAbout.setForeground(Color.BLUE);
		itemAbout.addActionListener(this);
		mnHelp.add(itemAbout);
		
		JMenu mnRecord = new JMenu("RECORD");
		mnRecord.setFont(new Font("Serif", Font.ITALIC, 17));
		
		JMenuItem bookDet = new JMenuItem("Book Details");
		bookDet.setBackground(Color.GRAY);
		bookDet.setForeground(Color.BLUE);
		bookDet.addActionListener(this);
		mnRecord.add(bookDet);
		
		JMenuItem stuDet = new JMenuItem("Student Details");
		stuDet.setBackground(Color.GRAY);
		stuDet.setForeground(Color.BLUE);
		stuDet.addActionListener(this);
		mnRecord.add(stuDet);
		
		menuBar.add(mnRecord);
		menuBar.add(mnHelp);
		menuBar.add(mnExit);
		
		JLabel lb1 = new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lb1.setForeground(Color.RED);
		lb1.setFont(new Font("San-Serif", Font.BOLD, 30));
		lb1.setBounds(250, 30, 701, 80);
		contentpane.add(lb1);
		
		JLabel lb2 = new JLabel("");
		ImageIcon imgI = new ImageIcon(new ImageIcon("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\addBook.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		lb2.setIcon(imgI);
		lb2.setBounds(60, 140, 159, 152);
		contentpane.add(lb2);
		
		JLabel lb3 = new JLabel("");
		ImageIcon imgI1 = new ImageIcon(new ImageIcon("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\Stats.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		lb3.setIcon(imgI1);
		lb3.setBounds(300, 140, 154, 152);
		contentpane.add(lb3);
		
		JLabel lb4 = new JLabel("");
		ImageIcon imgI2 = new ImageIcon(new ImageIcon("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\Student.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		lb4.setIcon(imgI2);
		lb4.setBounds(540, 140, 154, 152);
		contentpane.add(lb4);
		
		JLabel lb5 = new JLabel("");
		ImageIcon imgI3 = new ImageIcon(new ImageIcon("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\book.png").getImage().getScaledInstance(150,  150, Image.SCALE_DEFAULT));
		lb5.setIcon(imgI3);
		lb5.setBounds(780, 140, 154, 152);
		contentpane.add(lb5);
		
		JLabel lb6 = new JLabel("");
		ImageIcon imgI4 = new ImageIcon(new ImageIcon("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\issueBook.png").getImage().getScaledInstance(150,  150, Image.SCALE_DEFAULT));
		lb6.setIcon(imgI4);
		lb6.setBounds(300, 400, 154, 152);
		contentpane.add(lb6);
		
		JLabel lb7 = new JLabel("");
		ImageIcon imgI5 = new ImageIcon(new ImageIcon("C:\\Users\\AMALESH ADHIKARY\\eclipse-workspace\\Library_Management\\icons\\About.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		lb7.setIcon(imgI5);
		lb7.setBounds(540, 400, 154, 152);
		contentpane.add(lb7);
		
		b1 = new JButton("ADD BOOKS");
		b1.addActionListener(this);
		b1.setBackground(Color.CYAN);
		b1.setForeground(Color.RED);
		b1.setBounds(60, 320, 139, 44);
		contentpane.add(b1);
		
		b2 = new JButton("STATISTICS");
		b2.addActionListener(this);
		b2.setBackground(Color.CYAN);
		b2.setForeground(Color.RED);
		b2.setBounds(300, 320, 139, 44);
		contentpane.add(b2);
		
		b3 = new JButton("ADD STUDENTS");
		b3.addActionListener(this);
		b3.setBackground(Color.CYAN);
		b3.setForeground(Color.RED);
		b3.setBounds(545, 320, 139, 44);
		contentpane.add(b3);
		
		b4 = new JButton("RETURN BOOKS");
		b4.addActionListener(this);
		b4.setBackground(Color.CYAN);
		b4.setForeground(Color.RED);
		b4.setBounds(785, 320, 139, 44);
		contentpane.add(b4);
		
		b5 = new JButton("ISSUE BOOKS");
		b5.addActionListener(this);
		b5.setBackground(Color.CYAN);
		b5.setForeground(Color.RED);
		b5.setBounds(305, 580, 139, 44);
		contentpane.add(b5);
		
		b6 = new JButton("ABOUT");
		b6.addActionListener(this);
		b6.setBackground(Color.CYAN);
		b6.setForeground(Color.RED);
		b6.setBounds(545, 580, 139, 44);
		contentpane.add(b6);
		
		JPanel pane = new JPanel();
		pane.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "SMART LIBRARY 1.0", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		pane.setBounds(20, 120, 945, 270);
		contentpane.add(pane);
		
		JPanel pane2 = new JPanel();
		pane2.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 2), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		pane2.setBounds(20, 395, 945, 250);
		contentpane.add(pane2);
	}
	public static void main(String[] args) {
		new Home().setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand();
		if(msg.equals("LOGOUT")) {
			setVisible(false);
			new LoginWindow().setVisible(true);
			
		}else if(msg.equals("EXIT")) {
			System.exit(ABORT);;
		}else if(msg.equals("READ ME")) {
//			new ReadMe().setVisible(true);
		}else if(msg.equals("ABOUT US")) {
			new About().setVisible(true);
		}
		else if(msg.equals("Book Details")) {
			setVisible(false);
			new BookDetails().setVisible(true);
		}else if(msg.equals("Student Details")) {
			setVisible(false);
			new StudentDetails().setVisible(true);
		}
		
		if(e.getSource() == b1) {
			this.setVisible(false);
			new AddBook().setVisible(true);
		}
		if(e.getSource() == b2) {
			this.setVisible(false);
			new Statistics().setVisible(true);
		}
		if(e.getSource() == b3) {
			this.setVisible(false);
			new AddStudent().setVisible(true);
		}
		if(e.getSource() == b4) {
			this.setVisible(false);
			new ReturnBook().setVisible(true);
		}
		if(e.getSource() == b5) {
			this.setVisible(false);
			new IssueBook().setVisible(true);
		}
		if (e.getSource() == b6) {
			this.setVisible(false);
			new About().setVisible(true);
		}
	}

}
