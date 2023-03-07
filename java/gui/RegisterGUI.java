package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class RegisterGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textUserName;
	private JTextField textEmail;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JTextField textPhoneNumber;
	private JTextField textAge;
	private JLabel lblUsername;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JLabel lblPhoneNumber;
	private JLabel lblAge;
	private JFrame nirePantaila;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
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
	public RegisterGUI() {
		nirePantaila=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textName = new JTextField();
		textName.setBounds(170, 10, 147, 19);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textUserName = new JTextField();
		textUserName.setColumns(10);
		textUserName.setBounds(170, 38, 147, 19);
		contentPane.add(textUserName);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(170, 67, 147, 19);
		contentPane.add(textEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 96, 147, 19);
		contentPane.add(passwordField);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(170, 125, 147, 19);
		contentPane.add(confirmPasswordField);
		
		textPhoneNumber = new JTextField();
		textPhoneNumber.setBounds(170, 154, 147, 19);
		contentPane.add(textPhoneNumber);
		textPhoneNumber.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(170, 183, 147, 19);
		contentPane.add(textAge);
		textAge.setColumns(10);
		
		
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setBounds(92, 13, 45, 13);
		contentPane.add(lblName);
		
		lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(84, 41, 53, 13);
		contentPane.add(lblUsername);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(92, 70, 45, 13);
		contentPane.add(lblEmail);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(84, 99, 53, 13);
		contentPane.add(lblPassword);
		
		lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(38, 128, 99, 13);
		contentPane.add(lblConfirmPassword);
		
		lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(59, 157, 78, 13);
		contentPane.add(lblPhoneNumber);
		
		lblAge = new JLabel("Age:");
		lblAge.setBounds(92, 186, 45, 13);
		contentPane.add(lblAge);
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=textUserName.getText();
				String email=textEmail.getText();
				String pass=passwordField.getText();
				String confPass=confirmPasswordField.getText();
				int age=Integer.parseInt(textAge.getText());
				BLFacade facade=MainGUI.getBusinessLogic();
				String emaitza=facade.canRegister(username, email, pass, confPass, age);
				switch(emaitza) {
				case "Ondo":
//					JFrame a= new LoggedGUI();
//					a.setVisible(true);
					nirePantaila.setVisible(false);
				case "Error userName":
					
				}
					
				
			}
		});
		btnRegister.setBounds(136, 212, 141, 41);
		contentPane.add(btnRegister);
		
		JLabel lblError = new JLabel("New label");
		lblError.setEnabled(false);
		lblError.setBounds(352, 226, 45, 13);
		contentPane.add(lblError);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("English");
		rdbtnNewRadioButton.setBounds(92, 297, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("English");
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Locale.setDefault(new Locale("en"));
					System.out.println("Locale: "+Locale.getDefault());
				}
			});
		}
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Euskera");
		rdbtnNewRadioButton_1.setBounds(191, 297, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Castellano");
		rdbtnNewRadioButton_2.setBounds(294, 297, 103, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JLabel lblOption = new JLabel("Select option:");
		lblOption.setBounds(10, 301, 103, 13);
		contentPane.add(lblOption);
		
	}
}
