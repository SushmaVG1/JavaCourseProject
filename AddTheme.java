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

public class AddTheme extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public AddTheme() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\win 10\\Downloads\\WhatsApp Image 2021-03-02 at 14.14.43.jpeg"));
		setTitle("THE EVENT CORP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1163, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(581, 198, 160, 42);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Enter the theme details to be added");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(453, 68, 313, 52);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Add Theme");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!textField.getText().equals("") && !textField_1.getText().equals("")) {
					String name = textField.getText();
					try {
						float charges = Float.parseFloat(textField_1.getText());
						if (charges < 1000) {
							JOptionPane.showMessageDialog(null, "Minimum charges has to be 1000");
						} else {
							Theme t = new Theme(name, charges);
							Main.arrayTheme.add(t);
							try {
								Class.forName("oracle.jdbc.driver.OracleDriver");
								Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
										"SYSTEM", "123");
								Statement stmt = con.createStatement();
								ResultSet rs = stmt.executeQuery("select * from theme");
								String query = "insert into theme values('" + name + "'," + charges + ")";
								stmt.executeUpdate(query);
								JOptionPane.showMessageDialog(null, "Theme added");
								con.close();
							} catch (Exception ep) {
								System.out.println(ep);
							}
						}
					} catch (Exception ep) {
						JOptionPane.showMessageDialog(null, "Charges should be in number");
					}
				} else
					JOptionPane.showMessageDialog(null, "Fill up all the fields");
			}
		});
		btnNewButton.setBounds(508, 396, 117, 25);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ServicesHome s = new ServicesHome();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(12, 13, 87, 25);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(458, 198, 123, 42);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Charges");
		lblNewLabel_2.setBounds(453, 288, 128, 33);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(581, 279, 160, 42);
		contentPane.add(textField_1);
	}

}
