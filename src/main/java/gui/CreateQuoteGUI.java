package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Event;
import domain.Question;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class CreateQuoteGUI extends JFrame {

	private JPanel contentPane;
	private JTextField Data_textField;
	private JTextField forecast_textField;
	private JTextField balioa_textField;

	private DefaultComboBoxModel GertaeraZerrenda = new DefaultComboBoxModel();
	private DefaultComboBoxModel GalderaZerrenda = new DefaultComboBoxModel();
	private JTextField QuoteNumber_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateQuoteGUI frame = new CreateQuoteGUI();
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
	public CreateQuoteGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Aukeratu galdera:");
		lblNewLabel.setBounds(23, 104, 95, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(23, 75, 17, -11);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Data:");
		lblNewLabel_2.setBounds(23, 33, 46, 14);
		contentPane.add(lblNewLabel_2);

		Data_textField = new JTextField();
		Data_textField.setBounds(128, 30, 86, 20);
		contentPane.add(Data_textField);
		Data_textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Forecast:");
		lblNewLabel_3.setBounds(23, 164, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Balioa:");
		lblNewLabel_4.setBounds(23, 189, 46, 14);
		contentPane.add(lblNewLabel_4);

		forecast_textField = new JTextField();
		forecast_textField.setBounds(128, 161, 86, 20);
		contentPane.add(forecast_textField);
		forecast_textField.setColumns(10);

		balioa_textField = new JTextField();
		balioa_textField.setBounds(128, 186, 86, 20);
		contentPane.add(balioa_textField);
		balioa_textField.setColumns(10);

		JButton erakutsiGertaerak_btn = new JButton("Erakutsi gertaerak");
		erakutsiGertaerak_btn.setBounds(224, 31, 146, 18);
		contentPane.add(erakutsiGertaerak_btn);

		JButton CreateQuote_btn = new JButton("Sortu kuota");
		CreateQuote_btn.setBounds(156, 222, 128, 28);
		contentPane.add(CreateQuote_btn);

		
		erakutsiGertaerak_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatua = new SimpleDateFormat("dd-MM-yyyy");
				try {
					Date eventDate = formatua.parse(Data_textField.getText());
					BLFacade facade = MainGUI.getBusinessLogic();
					Vector<Event> gertaerak = facade.getEvents(eventDate);
					for (Event e1 : gertaerak) {
						GertaeraZerrenda.addElement(e1);
					}

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// Hacer algo con el texto ingresado en el campo de texto
			}
		});

		JComboBox event_comboBox = new JComboBox();
		event_comboBox.setBounds(128, 61, 146, 28);
		event_comboBox.setModel(GertaeraZerrenda);
		contentPane.add(event_comboBox);

		event_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				Event gertaera = (Event) event_comboBox.getSelectedItem();
				Vector<Question> galderak = facade.getEventQuestion(gertaera);
				for (Question q1 : galderak) {
					GalderaZerrenda.addElement(q1);
				}

			}
		});

		JComboBox question_comboBox = new JComboBox();
		question_comboBox.setBounds(128, 97, 146, 28);
		question_comboBox.setModel(GalderaZerrenda);
		contentPane.add(question_comboBox);

		JLabel lblAukeratuGertaera = new JLabel("Aukeratu gertaera:");
		lblAukeratuGertaera.setBounds(23, 75, 95, 14);
		contentPane.add(lblAukeratuGertaera);

		QuoteNumber_textField = new JTextField();
		QuoteNumber_textField.setColumns(10);
		QuoteNumber_textField.setBounds(128, 136, 86, 20);
		contentPane.add(QuoteNumber_textField);

		JLabel lblNewLabel_3_1 = new JLabel("Forecast:");
		lblNewLabel_3_1.setBounds(23, 164, 46, 14);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("QuoteNumber:");
		lblNewLabel_3_2.setBounds(23, 139, 86, 14);
		contentPane.add(lblNewLabel_3_2);

		CreateQuote_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quoteNumber = Integer.parseInt(QuoteNumber_textField.getText());
				double balio = Double.parseDouble(balioa_textField.getText());
				String forecast = balioa_textField.getText();
				BLFacade facade = MainGUI.getBusinessLogic();
				Question galdera = (Question) question_comboBox.getSelectedItem();
				facade.createQuote(quoteNumber, forecast, balio, galdera);

			}
		});
	}
}
