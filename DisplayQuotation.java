import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyleConstants.FontConstants;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;

import com.itextpdf.text.*;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Font.FontFamily;
import javax.swing.ScrollPaneConstants;;

@SuppressWarnings({ "serial", "unused" })

public class DisplayQuotation extends JFrame {

	private JPanel contentPane;

	public DisplayQuotation(String username, BookedEvent b) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\win 10\\Downloads\\WhatsApp Image 2021-03-02 at 14.14.43.jpeg"));
		setTitle("THE EVENT CORP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1173, 754);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scroll = new JScrollPane();
		scroll.setSize(216, 201);
		scroll.setLocation(131, 107);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);

		JTextArea textArea = new JTextArea();
		scroll.setViewportView(textArea);
		textArea.setText(b.event.display());

		JLabel lblNewLabel = new JLabel("Tentative quotation of your event");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(365, 33, 334, 40);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Confirm booking");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.arrayBookedEvent.add(b);
				Document d = new Document(PageSize.A4, 50, 50, 50, 50);
				PdfPTable header = new PdfPTable(2);
				try {
					header.setWidths(new int[] { 2, 24 });
				} catch (DocumentException e2) {
					e2.printStackTrace();
				}
				try {
					PdfWriter pdfWriter = PdfWriter.getInstance(d,
							new FileOutputStream("C:/Users/win 10/Desktop/" + username + ".pdf"));
				} catch (Exception ep) {
					System.out.println("File not found");
				}
				d.open();
				Phrase h = new Phrase(
						"\n*************************** THE EVENT CORP *************************\n\nThank you for trusting us to manage your event."
								+ "\nThe details of your event are as follows : \n\n");
				Paragraph paragraph = new Paragraph();
				Phrase h1 = new Phrase("\n*************************** THANK YOU *****************************");
				paragraph.add(b.display());
				try {
					d.add(h);
					d.add(paragraph);
					d.add(h1);
				} catch (DocumentException e1) {
					e1.printStackTrace();
				}
				d.close();
				JOptionPane.showMessageDialog(null,
						"Event sucessfully booked.\nWe will contact you soon for further information.");
				ThankYouPage t = new ThankYouPage();
				t.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(466, 625, 132, 41);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookEventPage p = new BookEventPage(username);
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(12, 13, 97, 25);
		contentPane.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(432, 107, 216, 201);
		contentPane.add(scrollPane);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText((String) null);
		scrollPane.setViewportView(textArea_1);
		textArea_1.setText(b.venue.display());

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(723, 107, 216, 201);
		contentPane.add(scrollPane_1);

		JTextArea textArea_2 = new JTextArea();
		scrollPane_1.setViewportView(textArea_2);
		textArea_2.setText((String) null);
		textArea_2.setText(b.photography.display());

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(131, 366, 216, 201);
		contentPane.add(scrollPane_2);

		JTextArea textArea_3 = new JTextArea();
		scrollPane_2.setViewportView(textArea_3);
		textArea_3.setText((String) null);
		textArea_3.setText(b.catering.display());

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(432, 366, 216, 201);
		contentPane.add(scrollPane_3);

		JTextArea textArea_4 = new JTextArea();
		textArea_4.setText((String) null);
		scrollPane_3.setViewportView(textArea_4);
		textArea_4.setText(b.theme.display());

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_4.setBounds(723, 366, 216, 201);
		contentPane.add(scrollPane_4);

		JTextArea textArea_5 = new JTextArea();
		textArea_5.setText((String) null);
		scrollPane_4.setViewportView(textArea_5);
		textArea_5.setText(b.display(1));

		JLabel lblNewLabel_1 = new JLabel("Event");
		lblNewLabel_1.setBounds(207, 78, 56, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblVenue = new JLabel("Venue");
		lblVenue.setBounds(507, 78, 56, 16);
		contentPane.add(lblVenue);

		JLabel lblTheme = new JLabel("Theme");
		lblTheme.setBounds(517, 337, 56, 16);
		contentPane.add(lblTheme);

		JLabel lblPhotography = new JLabel("Photography");
		lblPhotography.setBounds(780, 78, 104, 16);
		contentPane.add(lblPhotography);

		JLabel lblCatering = new JLabel("Catering");
		lblCatering.setBounds(202, 337, 79, 16);
		contentPane.add(lblCatering);

		JLabel lblEventDateAnd = new JLabel("Event date and Total charges");
		lblEventDateAnd.setBounds(733, 337, 190, 16);
		contentPane.add(lblEventDateAnd);
	}
}
