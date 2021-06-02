package Mysql;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 28));
		lblNewLabel.setBounds(133, 28, 164, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name:");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 23));
		lblNewLabel_1.setBounds(58, 97, 285, 47);
		contentPane.add(lblNewLabel_1);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 16));
		user.setBounds(58, 139, 307, 33);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 23));
		lblNewLabel_2.setBounds(58, 211, 262, 41);
		contentPane.add(lblNewLabel_2);
		
		pass = new JTextField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pass.setBounds(58, 262, 307, 33);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from register where UserName='"+user.getText()+"' and Password='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
						JOptionPane.showMessageDialog(null,"Login Successfully");
					else
						JOptionPane.showMessageDialog(null,"Incorrect User Name OR Password");
					con.close();
				}
				catch(Exception e) {System.out.print(e);}
			}
		});
		btnNewButton.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		btnNewButton.setBounds(58, 315, 103, 33);
		contentPane.add(btnNewButton);
	}
}
