import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings({ "serial", "unused" })

public class AdminLogInPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public AdminLogInPage() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\win 10\\Downloads\\WhatsApp Image 2021-03-02 at 14.14.43.jpeg"));
		setTitle("THE EVENT CORP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1212, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Index i = new Index();
				i.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(12, 25, 97, 25);
		contentPane.add(btnNewButton_3);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(470, 132, 118, 35);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(579, 132, 157, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(470, 211, 118, 35);
		contentPane.add(lblPassword);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(579, 211, 157, 35);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setBounds(550, 318, 97, 25);
		contentPane.add(btnNewButton);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Admin a = new Admin();
				boolean flag = a.validateAdmin(textField.getText(), textField_1.getText());
				if (flag == true) {
					AdminOptionsPage p = new AdminOptionsPage();
					p.setVisible(true);
					dispose();
				}
			}
		});
	}
}
