package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.User;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private final JLabel loginLabel = new JLabel("LOGIN");
	private JFrame nirePantaila;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		nirePantaila = this;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton registerButton = new JButton("Register");
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		registerButton.setBounds(105, 164, 108, 41);
		contentPane.add(registerButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(215, 98, 165, 19);
		contentPane.add(passwordField);

		JFormattedTextField userNameTextField = new JFormattedTextField();
		userNameTextField.setBounds(215, 56, 165, 19);
		contentPane.add(userNameTextField);

		JButton continueButton = new JButton("Continue");
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		continueButton.setBounds(183, 212, 108, 41);
		contentPane.add(continueButton);

		JLabel userNameLabel = new JLabel("UserName:");
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameLabel.setBounds(121, 59, 102, 13);
		contentPane.add(userNameLabel);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLabel.setBounds(123, 101, 82, 13);
		contentPane.add(passwordLabel);
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		loginLabel.setBounds(10, 10, 126, 36);
		contentPane.add(loginLabel);
		JButton signUpNewButton = new JButton("Sign Up");
		signUpNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userNameLabel.getText();
				String pass = passwordLabel.getText();
				BLFacade facade = MainGUI.getBusinessLogic();
				User emaitza = facade.isLogin(userName, pass);
				if (emaitza != null) {
					if (emaitza.isAdmin()) {
//						JFrame a = new AdminGUI();
//						a.setVisible(true);	
						nirePantaila.setVisible(false);
					} else {
//						JFrame b = new LoggedGUI();
//						b.setVisible(true);	
						nirePantaila.setVisible(false);
					}

				} else {
					userNameTextField.removeAll();
					passwordField.removeAll();
				}

			}
		});
		signUpNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		signUpNewButton.setBounds(253, 164, 108, 41);
		contentPane.add(signUpNewButton);
	}

}
