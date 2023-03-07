package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import javax.swing.JRadioButton;

public class CreateEventGUI extends JFrame {

	private JPanel contentPane;
	private JTextField eventNumber_field;
	private JTextField evenDate_field1;
	private JTextField description_field;
	private JLabel eventNumber_label = new JLabel("Event Number:");
	private JLabel eventDate_label = new JLabel("Event Date");
	private JLabel description_label = new JLabel("Description:");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblOption = new JLabel("Select Option:");
	private JButton createButton = new JButton("Create");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateEventGUI frame = new CreateEventGUI();
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
	public CreateEventGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		eventNumber_field = new JTextField();
		eventNumber_field.setBounds(187, 49, 96, 19);
		contentPane.add(eventNumber_field);
		eventNumber_field.setColumns(10);

		evenDate_field1 = new JTextField();
		evenDate_field1.setToolTipText("");
		evenDate_field1.setText("dd-MM-yyyy");
		evenDate_field1.setColumns(10);
		evenDate_field1.setBounds(187, 87, 96, 19);
		evenDate_field1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				evenDate_field1.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				evenDate_field1.setText("dd-MM-yyyy");
			}
		});
		contentPane.add(evenDate_field1);

		description_field = new JTextField();
		description_field.setHorizontalAlignment(SwingConstants.LEFT);
		description_field.setColumns(10);
		description_field.setBounds(187, 116, 145, 64);
		contentPane.add(description_field);
		eventNumber_label.setHorizontalAlignment(SwingConstants.RIGHT);

		eventNumber_label.setBounds(26, 52, 128, 13);
		contentPane.add(eventNumber_label);
		eventDate_label.setHorizontalAlignment(SwingConstants.RIGHT);

		eventDate_label.setBounds(26, 90, 128, 13);
		contentPane.add(eventDate_label);
		description_label.setHorizontalAlignment(SwingConstants.RIGHT);

		description_label.setBounds(26, 141, 128, 13);
		contentPane.add(description_label);

		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatua = new SimpleDateFormat("dd-MM-yyyy");
				try {
					int eventNumber = Integer.parseInt(eventNumber_field.getText());
					Date eventDate = formatua.parse(evenDate_field1.getText());
					String description = description_field.getText();
					BLFacade facade = MainGUI.getBusinessLogic();
					facade.createEvent(eventNumber, description, eventDate);

				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		createButton.setBounds(163, 207, 85, 21);
		contentPane.add(createButton);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("English");
		rdbtnNewRadioButton.setBounds(160, 272, 103, 21);
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
		rdbtnNewRadioButton_1.setBounds(265, 272, 88, 21);
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
		rdbtnNewRadioButton_2.setBounds(355, 272, 103, 21);
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
		lblOption.setBounds(10, 276, 128, 13);
		contentPane.add(lblOption);
	}

	private void redibujar() {
		createButton.setText(ResourceBundle.getBundle("Etiquetas").getString("Create"));
		lblOption.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
		description_label.setText(ResourceBundle.getBundle("Etiquetas").getString("Description"));
		eventDate_label.setText(ResourceBundle.getBundle("Etiquetas").getString("EventDate"));
		eventNumber_label.setText(ResourceBundle.getBundle("Etiquetas").getString("EventNumber"));

	}
}
