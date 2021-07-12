package com.librarymanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JButton bt1, bt2;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	

	public static void main(String[] args) {
		new Signup().setVisible(true);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Signup() {
		setBounds(600, 250, 605, 406);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setForeground(Color.BLUE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(59, 86, 92, 24);
		contentPanel.add(lblUsername);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setForeground(Color.BLUE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(59, 123, 92, 24);
		contentPanel.add(lblName);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(59, 160, 92, 24);
		contentPanel.add(lblPassword);
		
		JLabel lblAnswer = new JLabel("Answer : ");
		lblAnswer.setForeground(Color.BLUE);
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnswer.setBounds(59, 234, 92, 24);
		contentPanel.add(lblAnswer);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String [] {"Your Nickname?", "Your Lucky Number?", "Your childhood superhero?", "Your Childhood Name?"}));
		comboBox.setBounds(265, 202, 145, 20);
		contentPanel.add(comboBox);
		
		JLabel lblSecuQues = new JLabel("Security Question : ");
		lblSecuQues.setForeground(Color.BLUE);
		lblSecuQues.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSecuQues.setBounds(59, 197, 140, 24);
		contentPanel.add(lblSecuQues);
		
		textField = new JTextField();
		textField.setBounds(265, 91, 140, 20);
		textField.setColumns(10);
		contentPanel.add(textField);
		
		textField1 = new JTextField();
		textField1.setBounds(265, 129, 140, 20);
		textField1.setColumns(10);
		contentPanel.add(textField1);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(265, 167, 140, 20);
		contentPanel.add(textField2);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(265, 239, 140, 20);
		contentPanel.add(textField3);
		
		bt1 = new JButton("Sign Up");
		bt1.addActionListener(this);
		bt1.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt1.setBounds(140, 299, 100, 30);
		bt1.setBackground(Color.GREEN);
		bt1.setForeground(Color.RED);
		contentPanel.add(bt1);
		
		bt2 = new JButton("Back");
		bt2.addActionListener(this);
		bt2.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt2.setBackground(Color.YELLOW);
		bt2.setForeground(Color.BLUE);
		bt2.setBounds(300, 299, 100, 30);
		contentPanel.add(bt2);
		
		JPanel panel1 = new JPanel();
		panel1.setForeground(Color.ORANGE);
		panel1.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 2), "Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel1.setBounds(31, 46, 476, 294);
		panel1.setBackground(Color.WHITE);
		contentPanel.add(panel1);
	}
	@Override
	public void actionPerformed(ActionEvent evt1) {
		try {
			Cons con = new Cons();
			
			if(evt1.getSource() == bt1) {
				String sql = "insert into account (username, name1, password1, answer, question) values(?, ?, ?, ?, ?)";
				PreparedStatement st = con.c.prepareStatement(sql);
				
				st.setString(1, textField.getText());
				st.setString(2, textField1.getText());
				st.setString(3, textField2.getText());
				st.setString(4, textField3.getText());
				st.setString(5, (String) comboBox.getSelectedItem());
				
				int i = st.executeUpdate();
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "Account created Succesfully");
				}
				textField.setText("");
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
			}
			if(evt1.getSource() == bt2) {
				this.setVisible(false);
				new LoginWindow().setVisible(true);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
