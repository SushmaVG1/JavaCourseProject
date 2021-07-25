import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings({ "serial", "unused" })

public class UserHome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public UserHome() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\win 10\\Downloads\\WhatsApp Image 2021-03-02 at 14.14.43.jpeg"));
		setTitle("THE EVENT CORP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1199, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserOptionsPage u = new UserOptionsPage();
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(12, 13, 97, 25);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserSignUp up = new UserSignUp();
				up.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(507, 415, 106, 59);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(456, 173, 87, 36);
		contentPane.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(456, 238, 87, 36);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(555, 180, 137, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(555, 245, 137, 29);
		contentPane.add(textField_1);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					boolean flag = Main.validateUser(textField.getText(), textField_1.getText());
					Client c = Main.getClient(1);
					if (flag == true) {
						BookEventPage bp = new BookEventPage(textField.getText());
						bp.setVisible(true);
						dispose();
					} else
						JOptionPane.showMessageDialog(null, "Username password doesn't match.");
				} catch (Exception ep) {

					JOptionPane.showMessageDialog(null, "Invalid credentials.\nSign up to proceed further.");
				}
			}
		});
		btnLogIn.setBounds(507, 309, 106, 59);
		contentPane.add(btnLogIn);
	}

}
