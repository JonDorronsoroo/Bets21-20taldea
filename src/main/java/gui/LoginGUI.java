package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.User;

import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private final JLabel loginLabel = new JLabel("LOGIN");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JFrame nirePantaila;
	private JLabel lblNewLabel = new JLabel("Select Option:");
	private JButton registerButton = new JButton("Register");
	private JLabel userNameLabel = new JLabel("UserName:");
	private JLabel passwordLabel = new JLabel("Password:");
	private JButton signUpNewButton = new JButton("Log In");
	private JButton continueButton = new JButton("Continue");

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
		setBounds(100, 100, 450, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame b = new RegisterGUI();
				b.setVisible(true);
				nirePantaila.setVisible(false);
			}
		});
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		registerButton.setBounds(105, 164, 108, 41);
		contentPane.add(registerButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(215, 98, 165, 19);
		contentPane.add(passwordField);

		JFormattedTextField userNameTextField = new JFormattedTextField();
		userNameTextField.setBounds(215, 56, 165, 19);
		contentPane.add(userNameTextField);

		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a= new FindQuestionsGUI();
				a.setVisible(true);
				nirePantaila.setVisible(false);
			}
		});
		continueButton.setBounds(183, 212, 108, 41);
		contentPane.add(continueButton);

		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameLabel.setBounds(121, 59, 102, 13);
		contentPane.add(userNameLabel);

		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLabel.setBounds(123, 101, 82, 13);
		contentPane.add(passwordLabel);
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		loginLabel.setBounds(10, 10, 126, 36);
		contentPane.add(loginLabel);

		signUpNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userNameTextField.getText();
				String pass = passwordField.getText();
				BLFacade facade = MainGUI.getBusinessLogic();
				User emaitza = facade.isLogin(userName, pass);
				if (emaitza != null) {
					if (emaitza.isAdmin()) {
						JFrame a = new AdminGUI();
						a.setVisible(true);
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

		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(0, 292, 163, 13);
		contentPane.add(lblNewLabel);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("English");
		rdbtnNewRadioButton.setBounds(169, 288, 82, 21);
		contentPane.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("en"));
				System.out.println("Locale: " + Locale.getDefault());
				redibujar();
			}

		});
		buttonGroup.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Euskera");
		rdbtnNewRadioButton_1.setBounds(253, 288, 91, 21);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("eus"));
				System.out.println("Locale: " + Locale.getDefault());
				redibujar();
			}
		});
		contentPane.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Castellano");
		rdbtnNewRadioButton_2.setBounds(346, 288, 103, 21);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("es"));
				System.out.println("Locale: " + Locale.getDefault());
				redibujar();
			}
		});
		contentPane.add(rdbtnNewRadioButton_2);
		buttonGroup.add(rdbtnNewRadioButton_2);
	}

	private void redibujar() {
		userNameLabel.setText(ResourceBundle.getBundle("Etiquetas").getString("Username"));
		passwordLabel.setText(ResourceBundle.getBundle("Etiquetas").getString("Password"));
		registerButton.setText(ResourceBundle.getBundle("Etiquetas").getString("Register"));
		continueButton.setText(ResourceBundle.getBundle("Etiquetas").getString("Continue"));
		signUpNewButton.setText(ResourceBundle.getBundle("Etiquetas").getString("LoginGUI.check"));
		lblNewLabel.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
	}

}
