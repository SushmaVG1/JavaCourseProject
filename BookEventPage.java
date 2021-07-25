import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.time.*;

@SuppressWarnings({ "serial", "unused" })

public class BookEventPage extends JFrame {

	private JPanel contentPane;
	int eventIndex, photographyIndex, venueIndex, themeIndex, cateringIndex;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BookEventPage(String username) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\win 10\\Downloads\\WhatsApp Image 2021-03-02 at 14.14.43.jpeg"));
		setTitle("THE EVENT CORP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventIndex = comboBox.getSelectedIndex();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(Main.eventName()));
		comboBox.setBounds(524, 98, 190, 22);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserHome uh = new UserHome();
				uh.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(12, 13, 97, 25);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Choose Event");
		lblNewLabel.setBounds(372, 100, 106, 19);
		contentPane.add(lblNewLabel);

		JLabel lblChooseVenue = new JLabel("Choose Venue");
		lblChooseVenue.setBounds(372, 145, 106, 19);
		contentPane.add(lblChooseVenue);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				venueIndex = comboBox_1.getSelectedIndex();
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(Main.venueName()));
		comboBox_1.setBounds(524, 143, 190, 22);
		contentPane.add(comboBox_1);

		JLabel lblChoosePhotography = new JLabel("Choose Photography");
		lblChoosePhotography.setBounds(372, 196, 132, 19);
		contentPane.add(lblChoosePhotography);

		JLabel lblChooseAtering = new JLabel("Choose Catering");
		lblChooseAtering.setBounds(372, 246, 106, 19);
		contentPane.add(lblChooseAtering);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cateringIndex = comboBox_2.getSelectedIndex();
			}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(Main.photographyName()));
		comboBox_2.setBounds(524, 194, 190, 22);
		contentPane.add(comboBox_2);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				photographyIndex = comboBox_3.getSelectedIndex();
			}
		});
		comboBox_3.setModel(new DefaultComboBoxModel(Main.cateringName()));
		comboBox_3.setBounds(524, 244, 190, 22);
		contentPane.add(comboBox_3);

		JLabel lblChooseTheme = new JLabel("Choose Theme");
		lblChooseTheme.setBounds(372, 295, 106, 19);
		contentPane.add(lblChooseTheme);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				themeIndex = comboBox_4.getSelectedIndex();
			}
		});
		comboBox_4.setModel(new DefaultComboBoxModel(Main.themeName()));
		comboBox_4.setBounds(524, 293, 190, 22);
		contentPane.add(comboBox_4);

		JLabel lblEventDate = new JLabel("Event Date");
		lblEventDate.setBounds(372, 371, 106, 19);
		contentPane.add(lblEventDate);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBox_5.setBounds(524, 369, 51, 22);
		contentPane.add(comboBox_5);

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBox_6.setBounds(573, 369, 60, 22);
		contentPane.add(comboBox_6);

		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(
				new String[] { "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
		comboBox_7.setBounds(633, 369, 79, 22);
		contentPane.add(comboBox_7);

		JLabel lblNewLabel_1 = new JLabel("Welcome " + username);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(372, 29, 342, 41);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Book Event");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Event ev = Main.arrayEvent.get(eventIndex).getEvent();
				Venue v = Main.arrayVenue.get(venueIndex).getVenue();
				Catering ca = Main.arrayCatering.get(cateringIndex).getCatering();
				Photography ph = Main.arrayPhotography.get(photographyIndex).getPhotography();
				Theme th = Main.arrayTheme.get(themeIndex).getTheme();
				int day = Integer.parseInt(comboBox_5.getSelectedItem().toString());
				int month = Integer.parseInt(comboBox_6.getSelectedItem().toString()) - 1;
				int year = Integer.parseInt(comboBox_7.getSelectedItem().toString()) - 1900;
				@SuppressWarnings("deprecation")
				Date date = new Date(year, month, day);
				Date today = new Date();
				if (today.before(date)) {
					BookedEvent b = new BookedEvent(ev, v, ph, ca, th, date);
					DisplayQuotation q = new DisplayQuotation(username, b);
					q.setVisible(true);
					dispose();
				} else
					JOptionPane.showMessageDialog(null, "Invalid date.");
			}
		});
		btnNewButton_1.setBounds(478, 497, 120, 25);
		contentPane.add(btnNewButton_1);

	}

}
