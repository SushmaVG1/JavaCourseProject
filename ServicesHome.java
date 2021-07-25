import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings({ "serial", "unused" })

public class ServicesHome extends JFrame {

	private JPanel contentPane;

	public ServicesHome() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\win 10\\Downloads\\WhatsApp Image 2021-03-02 at 14.14.43.jpeg"));
		setTitle("THE EVENT CORP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1160, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Venue");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddVenue v = new AddVenue();
				v.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(351, 104, 196, 105);
		contentPane.add(btnNewButton);

		JButton btnPhotography = new JButton("Photography");
		btnPhotography.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPhotography ap = new AddPhotography();
				ap.setVisible(true);
				dispose();
			}
		});
		btnPhotography.setBounds(644, 104, 196, 105);
		contentPane.add(btnPhotography);

		JButton btnTheme = new JButton("Theme");
		btnTheme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddTheme at = new AddTheme();
				at.setVisible(true);
				dispose();
			}
		});
		btnTheme.setBounds(351, 255, 196, 120);
		contentPane.add(btnTheme);

		JButton btnCaterer = new JButton("Catering");
		btnCaterer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddCaterer ac = new AddCaterer();
				ac.setVisible(true);
				dispose();
			}
		});
		btnCaterer.setBounds(644, 255, 196, 120);
		contentPane.add(btnCaterer);

		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminOptionsPage a = new AdminOptionsPage();
				a.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(12, 29, 97, 25);
		contentPane.add(btnBack);

		JLabel lblNewLabel = new JLabel("Add Service Provider");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(505, 13, 196, 50);
		contentPane.add(lblNewLabel);
	}

}
