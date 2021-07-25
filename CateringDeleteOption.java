import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;

@SuppressWarnings({ "serial", "unused" })

public class CateringDeleteOption extends JFrame {

	private JPanel contentPane;

	@SuppressWarnings({ "unchecked", "rawtypes" })

	public CateringDeleteOption() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\win 10\\Downloads\\WhatsApp Image 2021-03-02 at 14.14.43.jpeg"));
		setTitle("THE EVENT CORP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 670);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Main.cateringName()));
		comboBox.setBounds(313, 224, 314, 57);
		comboBox.setBackground(SystemColor.controlLtHighlight);
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("Catering services available");
		lblNewLabel.setBounds(307, 109, 296, 57);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.arrayCatering.remove(comboBox.getSelectedIndex());
				String data = "" + comboBox.getItemAt(comboBox.getSelectedIndex());
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM",
							"123");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from catering");
					String query = "delete from catering where name = '" + data + "'";
					stmt.executeUpdate(query);
					con.close();
					JOptionPane.showMessageDialog(null, "Sucessfully deleted.");
					AdminOptionsPage h = new AdminOptionsPage();
					h.setVisible(true);
					dispose();
				} catch (Exception ep) {
					System.out.println(ep);
				}
			}
		});
		btnNewButton.setBounds(424, 373, 97, 46);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(12, 13, 97, 25);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemoveServices h = new RemoveServices();
				h.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
	}
}
