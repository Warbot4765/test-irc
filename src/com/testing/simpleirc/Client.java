package com.testing.simpleirc;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

// editing comment in eclipse
public class Client extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea history;
	private JPanel contentPane;
	private String name, address;
	private int port;
	private JTextField txtMessage;
	private DatagramSocket socket;
	private InetAddress ip;
	
	public Client(String name, String address, int port) {
		setTitle("IRC Client: One line of text at a time!" + "Use !help");
		this.name = name;
		this.address = address;
		this.port = port;
		boolean connect = openConnection(address, port);
		if (!connect) {
		System.err.println("The ZUCC does not approve!");	
		console("The ZUCC does not approve!");
		}
		createWindow();
		console("ZUCCessfelly Connected!");
	}
	
	private String receive() {
		
		DatagramPacket packet = new DatagramPacket()
	}
	
	private boolean openConnection(String address, int port) {
		try {
			socket = new DatagramSocket(port);
			ip = InetAddress.getByName(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		} catch (SocketException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
private void createWindow() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(2000, 1300);
	setLocationRelativeTo(null);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	GridBagLayout gbl_contentPane = new GridBagLayout();
	gbl_contentPane.columnWidths = new int[]{36, 1877, 71, 9}; //SUM=2000 ish
	gbl_contentPane.rowHeights = new int[]{89, 1209, 0, 102}; //SUM=1400 ish
	gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
	gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE, 0.0};
	contentPane.setLayout(gbl_contentPane);
	
	history = new JTextArea();
	history.setEditable(false);
	history.setForeground(new Color(255, 255, 255));
	history.setBackground(Color.GRAY);
	history.setFont(new Font("Calibri", Font.PLAIN, 30));
	history.setLineWrap(true);
	GridBagConstraints scrollConstraints = new GridBagConstraints();
	scrollConstraints.gridwidth = 3;
	scrollConstraints.insets = new Insets(0, 0, 5, 5);
	JScrollPane scroll = new JScrollPane(history);
	scrollConstraints.fill = GridBagConstraints.BOTH;
	scrollConstraints.gridx = 0;
	scrollConstraints.gridy = 0;
	scrollConstraints.gridwidth = 3;
	scrollConstraints.gridheight = 2;
	contentPane.add(scroll, scrollConstraints);
	
	txtMessage = new JTextField();
	txtMessage.setForeground(Color.WHITE);
	txtMessage.addKeyListener(new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				send(txtMessage.getText());
			}
		}
	});
	txtMessage.setBackground(Color.BLACK);
	GridBagConstraints gbc_txtMessage = new GridBagConstraints();
	gbc_txtMessage.gridwidth = 2;
	gbc_txtMessage.insets = new Insets(0, 0, 5, 5);
	gbc_txtMessage.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtMessage.gridx = 0;
	gbc_txtMessage.gridy = 2;
	gbc_txtMessage.gridwidth = 2;
	contentPane.add(txtMessage, gbc_txtMessage);
	txtMessage.setColumns(10);
	
	JButton btnNewButton = new JButton("Send");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txtMessage.requestFocus();
			send(txtMessage.getText());
		}
	});
	GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
	gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
	gbc_btnNewButton.gridx = 2;
	gbc_btnNewButton.gridy = 2;
	contentPane.add(btnNewButton, gbc_btnNewButton);
	

	txtMessage.transferFocus();
	setVisible(true);
	setResizable(true);
	history.requestFocus();
	history.transferFocus();
	txtMessage.requestFocus();
	}

	private void send(String message) {
		if (message.equals("")) return;
		if (message.equals("!fucku")) {
			history.append(name + " " + "thinks that you are EPICE!"
					+ "\n\r" + "�������./��/)\r\n" + 
					"������..,/�../\r\n" + 
					"������./�./\r\n" + 
					"����./��/���/���`��\r\n" + 
					"���./�/�/�./��./��\\\r\n" + 
					"��..(�(�����. �~/���)\r\n" + 
					"���\\�����..��../\r\n" + 
					"���.��\\���. _.��\r\n" + 
					"����\\����..(\r\n" + 
					"����..\\����.\\" + "\n\r");
			txtMessage.setText(null);
			}
		else {
			if (message.equals("!help")) {
				history.append("Current commands are:" + "\r\n" + "!fucku" + "\r\n" + "!cls" + "\r\n" + "!help" + "\r\n");
				txtMessage.setText(null);
				
		}
			else {
				if (message.equals("!cls")) {
					history.setText(null);
					txtMessage.setText(null);
				}
				else {
				console(name + ":" + " " + message);
				txtMessage.setText(null);
				}	
			}
			
		}
		
	}

	public void console(String message) {
		history.append(message + "\n\r");
		
	
	 
	}
	
}










