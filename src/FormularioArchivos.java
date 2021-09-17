import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FormularioArchivos extends JFrame {

	private JPanel contentPane;
	private JTextField txtDesc;
	private JTextField txtPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioArchivos frame = new FormularioArchivos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioArchivos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1473, 896);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Descripci\u00F3n del art\u00EDculo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(93, 93, 235, 49);
		contentPane.add(lblNewLabel);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(105, 190, 235, 49);
		contentPane.add(lblPrecio);

		txtDesc = new JTextField();
		txtDesc.setBounds(345, 93, 881, 49);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(345, 190, 881, 49);
		contentPane.add(txtPrice);

		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String description = txtDesc.getText();
				String price = txtPrice.getText();
				escribir(description, price);
			}
		});
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlta.setBounds(345, 304, 208, 49);
		contentPane.add(btnAlta);

		JLabel lblNewLabel_1 = new JLabel("Resultado");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(661, 304, 241, 49);
		contentPane.add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(105, 420, 1130, 374);
		contentPane.add(textArea);

	}

	public static void escribir(String descrip, String price) {
		FileWriter fWriter;
		System.out.println(descrip);
		try {
			fWriter = new FileWriter("doc.txt", true);
			fWriter.append(descrip + " " + price);
			fWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
