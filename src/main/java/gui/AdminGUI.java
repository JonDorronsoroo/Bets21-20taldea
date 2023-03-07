package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AdminGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnCreateQuote = new JButton("Create Quote");
	private JButton btnCreateEvent = new JButton("Create Event");
	private JLabel lblSelectOption = new JLabel("Select Option");
	private JFrame nirePantaila;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI frame = new AdminGUI();
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
	public AdminGUI() {
		nirePantaila = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCreateQuote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a=new CreateQuoteGUI();
				a.setVisible(true);
				nirePantaila.setVisible(false);
			}
		});
		btnCreateQuote.setBounds(10, 67, 416, 54);
		contentPane.add(btnCreateQuote);
		btnCreateEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new CreateEventGUI();
				a.setVisible(true);
				nirePantaila.setVisible(false);
			}
		});

		btnCreateEvent.setBounds(10, 131, 416, 54);
		contentPane.add(btnCreateEvent);
		lblSelectOption.setHorizontalAlignment(SwingConstants.CENTER);

		lblSelectOption.setBounds(169, 33, 112, 13);
		contentPane.add(lblSelectOption);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("English");
		rdbtnNewRadioButton.setBounds(86, 200, 103, 21);
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
		rdbtnNewRadioButton_1.setBounds(194, 200, 103, 21);
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
		rdbtnNewRadioButton_2.setBounds(299, 200, 103, 21);
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
		lblSelectOption.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
		btnCreateEvent.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateEvent"));
		btnCreateQuote.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuote"));

	}
}
