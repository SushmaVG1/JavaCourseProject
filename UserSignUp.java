import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Font;
import java.awt.Toolkit;

@SuppressWarnings({ "serial", "unused" })

public class UserSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public UserSignUp() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\win 10\\Downloads\\WhatsApp Image 2021-03-02 at 14.14.43.jpeg"));
		setTitle("THE EVENT CORP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1192, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(436, 131, 56, 31);
		contentPane.add(lblNewLabel);

		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setBounds(436, 189, 56, 16);
		contentPane.add(lblEmailId);

		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setBounds(436, 249, 89, 16);
		contentPane.add(lblPhoneNo);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(436, 309, 75, 16);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(537, 129, 116, 34);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(537, 186, 116, 34);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(537, 246, 116, 34);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(537, 306, 116, 34);
		contentPane.add(textField_3);

		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name, email, phNo, password;
				name = textField.getText();
				email = textField_1.getText();
				phNo = textField_2.getText();
				password = textField_3.getText();
				if (!name.equals("") && !password.equals("") && !phNo.equals("") && !email.equals("")) {
					try {
						Client p = new Client(name, email, phNo, password);
						Main.arrayClient.add(p);
						try {
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
									"SYSTEM", "123");
							Statement stmt = con.createStatement();
							ResultSet rs = stmt.executeQuery("select * from client");
							String query = "insert into client values('" + name + "', '" + email + "' , '" + phNo
									+ "','" + password + "')";
							stmt.executeUpdate(query);
							Main.credentials.put(email, password);
							JOptionPane.showMessageDialog(null, "User registered.");
							con.close();
						} catch (Exception ep) {
							System.out.println(ep);
						}
					} catch (Exception ep) {
						JOptionPane.showMessageDialog(null, "Invalid entry");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Fill up all the fields");
				}
			}
		});
		btnNewButton.setBounds(485, 391, 97, 43);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserHome a = new UserHome();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(12, 13, 97, 25);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Enter user details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(460, 47, 219, 31);
		contentPane.add(lblNewLabel_1);
	}

}
