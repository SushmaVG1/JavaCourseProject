import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial", "unused" })

public class AddCaterer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public AddCaterer() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\win 10\\Downloads\\WhatsApp Image 2021-03-02 at 14.14.43.jpeg"));
		setTitle("THE EVENT CORP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1129, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(565, 160, 154, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Enter the catering service details to be added");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(415, 60, 375, 52);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ServicesHome s = new ServicesHome();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(12, 13, 97, 25);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Name ");
		lblNewLabel_1.setBounds(427, 160, 71, 35);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(427, 228, 71, 35);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(565, 228, 154, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(565, 300, 154, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(565, 371, 154, 35);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setBounds(427, 304, 97, 26);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Email ID");
		lblNewLabel_4.setBounds(427, 380, 97, 26);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Charges");
		lblNewLabel_5.setBounds(427, 451, 97, 25);
		contentPane.add(lblNewLabel_5);

		textField_4 = new JTextField();
		textField_4.setBounds(565, 446, 154, 35);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("Add catering service");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name, address, phNo, email;
				float charges;
				name = textField.getText();
				address = textField_1.getText();
				phNo = textField_2.getText();
				email = textField_3.getText();
				if (!name.equals("") && !address.equals("") && !phNo.equals("") && !email.equals("")) {
					try {
						charges = Float.parseFloat(textField_4.getText());
						if (charges < 5000)
							JOptionPane.showMessageDialog(null, "Minimum charges has to be Rs. 5000");
						else {
							Catering p = new Catering(name, address, phNo, email, charges);
							Main.arrayCatering.add(p);
							try {
								Class.forName("oracle.jdbc.driver.OracleDriver");
								Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
										"SYSTEM", "123");
								Statement stmt = con.createStatement();
								ResultSet rs = stmt.executeQuery("select * from catering");
								String query = "insert into catering values('" + name + "', '" + address + "' , '"
										+ email + "','" + phNo + "', " + charges + ")";
								stmt.executeUpdate(query);
								JOptionPane.showMessageDialog(null, "Catering service added");
								con.close();
							} catch (Exception ep) {
								System.out.println(ep);
							}
						}
					} catch (Exception ep) {
						JOptionPane.showMessageDialog(null, "Charges should be in number");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Fill up all the fields");
				}
			}
		});
		btnNewButton.setBounds(508, 523, 154, 25);
		contentPane.add(btnNewButton);
	}

}
