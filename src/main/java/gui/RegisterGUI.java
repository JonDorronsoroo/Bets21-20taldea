package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import businessLogic.BLFacade;
import domain.User;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;

public class RegisterGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textUserName;
	private JTextField textEmail;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JTextField textPhoneNumber;
	private JTextField textAge;
	private JLabel lblName = new JLabel("Name:");
	private JLabel lblUsername = new JLabel("UserName:");
	private JLabel lblEmail = new JLabel("Email:");
	private JLabel lblPassword = new JLabel("Password:");
	private JLabel lblConfirmPassword = new JLabel("ConfirmPassword:");
	private JLabel lblPhoneNumber = new JLabel("PhoneNumber:");
	private JLabel lblAge = new JLabel("Age");
	private JLabel lblError = new JLabel("Error");
	private JLabel lblOption = new JLabel("Select Option:");
	private JFrame nirePantaila;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	protected JButton btnRegister = new JButton("Register");
	private String lagunError = "";

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
		nirePantaila = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textName = new JTextField();
		textName.setBounds(217, 9, 147, 19);
		contentPane.add(textName);
		textName.setColumns(10);

		textUserName = new JTextField();
		textUserName.setColumns(10);
		textUserName.setBounds(217, 38, 147, 19);
		contentPane.add(textUserName);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(217, 67, 147, 19);
		contentPane.add(textEmail);

		passwordField = new JPasswordField();
		passwordField.setBounds(217, 96, 147, 19);
		contentPane.add(passwordField);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(217, 125, 147, 19);
		contentPane.add(confirmPasswordField);

		textPhoneNumber = new JTextField();
		textPhoneNumber.setBounds(217, 154, 147, 19);
		contentPane.add(textPhoneNumber);
		textPhoneNumber.setColumns(10);

		textAge = new JTextField();
		textAge.setBounds(217, 183, 147, 19);
		contentPane.add(textAge);
		textAge.setColumns(10);

		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(59, 13, 148, 13);
		contentPane.add(lblName);
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);

		lblUsername.setBounds(69, 41, 138, 13);
		contentPane.add(lblUsername);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);

		lblEmail.setBounds(79, 70, 128, 13);
		contentPane.add(lblEmail);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);

		lblPassword.setBounds(77, 99, 130, 13);
		contentPane.add(lblPassword);
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);

		lblConfirmPassword.setBounds(20, 128, 191, 13);
		contentPane.add(lblConfirmPassword);
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);

		lblPhoneNumber.setBounds(20, 157, 191, 13);
		contentPane.add(lblPhoneNumber);

		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(70, 272, 356, 19);
		lblError.setVisible(false);
		contentPane.add(lblError);

		lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setBounds(93, 186, 122, 13);
		contentPane.add(lblAge);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				String username = textUserName.getText();
				String email = textEmail.getText();
				String pass = passwordField.getText();
				String confPass = confirmPasswordField.getText();
				String phoneNumber = textPhoneNumber.getText();
				try {
					int age = Integer.parseInt(textAge.getText());

					BLFacade facade = MainGUI.getBusinessLogic();
					String emaitza = facade.canRegister(username, email, pass, confPass, age);
					User u = new User(name, username, email, pass, confPass, phoneNumber, age, false);
					switch (emaitza) {
					case "Ondo":
//					JFrame a= new LoggedGUI();
//					a.setVisible(true);
						facade.storeUser(u);
						nirePantaila.setVisible(false);
						break;
					case "Error userName":
						lblError.setText(ResourceBundle.getBundle("Etiquetas").getString("ErrorUsername"));
						lagunError = "ErrorUsername";
						lblError.setVisible(true);
						break;
					case "Error email":
						lblError.setText(ResourceBundle.getBundle("Etiquetas").getString("ErrorEmail"));
						lagunError = "ErrorEmail";
						lblError.setVisible(true);
						break;
					case "Error pass":
						lblError.setText(ResourceBundle.getBundle("Etiquetas").getString("ErrorPass"));
						lagunError = "ErrorPass";
						lblError.setVisible(true);
						break;
					case "Error age":
						lblError.setText(ResourceBundle.getBundle("Etiquetas").getString("ErrorAge"));
						lagunError = "ErrorAge";
						lblError.setVisible(true);
						break;

					}
				} catch (Exception a) {
					a.printStackTrace();
				}

			}
		});
		btnRegister.setBounds(153, 221, 141, 41);
		contentPane.add(btnRegister);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("English");
		rdbtnNewRadioButton.setBounds(123, 297, 103, 21);
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
		rdbtnNewRadioButton_1.setBounds(228, 297, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("eus"));
				System.out.println("Locale: " + Locale.getDefault());
				redibujar();
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Castellano");
		rdbtnNewRadioButton_2.setBounds(333, 297, 103, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("es"));
				System.out.println("Locale: " + Locale.getDefault());
				redibujar();
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_2);
		lblOption.setHorizontalAlignment(SwingConstants.RIGHT);

		lblOption.setBounds(0, 301, 113, 13);
		contentPane.add(lblOption);

	}

	private void redibujar() {
		btnRegister.setText(ResourceBundle.getBundle("Etiquetas").getString("Register"));
		if (lagunError != "") {
			lblError.setText(ResourceBundle.getBundle("Etiquetas").getString(lagunError));
		}
		lblName.setText(ResourceBundle.getBundle("Etiquetas").getString("Name"));
		lblUsername.setText(ResourceBundle.getBundle("Etiquetas").getString("Username"));
		lblEmail.setText(ResourceBundle.getBundle("Etiquetas").getString("Email"));
		lblPassword.setText(ResourceBundle.getBundle("Etiquetas").getString("Password"));
		lblConfirmPassword.setText(ResourceBundle.getBundle("Etiquetas").getString("ConfirmPassword"));
		lblPhoneNumber.setText(ResourceBundle.getBundle("Etiquetas").getString("PhoneNumber"));
		lblAge.setText(ResourceBundle.getBundle("Etiquetas").getString("Age"));
		lblOption.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
	}
}
