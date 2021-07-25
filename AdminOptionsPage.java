import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings({ "serial", "unused" })

public class AdminOptionsPage extends JFrame {

	private JPanel contentPane;

	public AdminOptionsPage() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\win 10\\Downloads\\WhatsApp Image 2021-03-02 at 14.14.43.jpeg"));
		setTitle("THE EVENT CORP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1212, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Remove Service Provider");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemoveServices r = new RemoveServices();
				r.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(546, 233, 202, 46);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Add Service Provider");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ServicesHome h = new ServicesHome();
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(546, 141, 202, 46);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("View Upcoming Events");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewBookedEvents v = new ViewBookedEvents();
				v.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(546, 392, 202, 46);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Index i = new Index();
				i.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(12, 26, 97, 25);
		contentPane.add(btnNewButton_3);

		JButton btnViewClientDetails = new JButton("View Client Details");
		btnViewClientDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewClientDetails v = new ViewClientDetails();
				v.setVisible(true);
				dispose();
			}
		});
		btnViewClientDetails.setBounds(546, 311, 202, 46);
		contentPane.add(btnViewClientDetails);
	}
}
