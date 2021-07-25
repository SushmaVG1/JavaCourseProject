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

public class Index extends JFrame {

	private JPanel contentPane;

	public Index() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\win 10\\Downloads\\WhatsApp Image 2021-03-02 at 14.14.43.jpeg"));
		setTitle("THE EVENT CORP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1053, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Admin Portal");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLogInPage a = new AdminLogInPage();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(432, 213, 169, 25);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("User Portal");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserOptionsPage op = new UserOptionsPage();
				op.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(432, 289, 169, 25);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePageGUI h = new HomePageGUI();
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(12, 26, 97, 25);
		contentPane.add(btnNewButton_2);
	}
}
