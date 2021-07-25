import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

@SuppressWarnings({ "serial", "unused" })

public class UserOptionsPage extends JFrame {

	private JPanel contentPane;

	public UserOptionsPage() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\win 10\\Downloads\\WhatsApp Image 2021-03-02 at 14.14.43.jpeg"));
		setTitle("THE EVENT CORP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1166, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("View Services");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewServicesHome v = new ViewServicesHome();
				v.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(474, 263, 150, 37);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Book Event");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserHome u = new UserHome();
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(474, 337, 150, 37);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Index i = new Index();
				i.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(12, 13, 97, 25);
		contentPane.add(btnNewButton_3);

		JLabel lblNewLabel = new JLabel("Welcome to The Event Corp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(406, 42, 278, 46);
		contentPane.add(lblNewLabel);

		JButton btnViewEvents = new JButton("View Events");
		btnViewEvents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewEvents v = new ViewEvents();
				v.setVisible(true);
				dispose();
			}
		});
		btnViewEvents.setBounds(474, 183, 150, 37);
		contentPane.add(btnViewEvents);
	}

}
