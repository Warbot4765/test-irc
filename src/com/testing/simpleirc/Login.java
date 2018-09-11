package com.testing.simpleirc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;

public class Login extends JFrame {
	
	int height = 100;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField textPort;
	private JLabel Port;
	private JLabel Example1;
	private JLabel Example2;

	public Login() {
		setResizable(false);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 900);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(247, 180, 280, 32);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Username:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblName.setBounds(319, 145, 136, 26);
		contentPane.add(lblName);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(247, 350, 280, 32);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblAddress = new JLabel("IP Address:");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblAddress.setBounds(312, 315, 149, 26);
		contentPane.add(lblAddress);
		
		textPort = new JTextField();
		textPort.setColumns(10);
		textPort.setBounds(247, 520, 280, 32);
		contentPane.add(textPort);
		
		Port = new JLabel("Port:");
		Port.setForeground(Color.WHITE);
		Port.setFont(new Font("Tahoma", Font.PLAIN, 28));
		Port.setBounds(357, 485, 59, 26);
		contentPane.add(Port);
		
		Example1 = new JLabel("(eg. 178.434.2.159)");
		Example1.setForeground(Color.WHITE);
		Example1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		Example1.setBounds(297, 385, 180, 26);
		contentPane.add(Example1);
		
		Example2 = new JLabel("(eg. 1234)");
		Example2.setForeground(Color.WHITE);
		Example2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		Example2.setBounds(339, 555, 96, 26);
		contentPane.add(Example2);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String address = txtAddress.getText();
				int port = Integer.parseInt(textPort.getText());
				login(name, address, port);
			}

			
		});
		btnLogin.setBounds(316, 651, 141, 35);
		contentPane.add(btnLogin);
	}
	
	private void login(String name, String address, int port) {
		dispose();
		new Client(name, address, port);
			
	}
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
}
