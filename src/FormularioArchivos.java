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
import java.io.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FormularioArchivos extends JFrame {

	private JPanel contentPane;
	private JTextField txtDesc;
	private JTextField txtPrice;
	private static String fileName = "doc.txt";
	private static File file = new File(fileName);
	private static JLabel lblError;

	

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
		setBounds(100, 100, 1373, 878);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Descripci\u00F3n del art\u00EDculo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(105, 93, 235, 49);
		contentPane.add(lblNewLabel);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(105, 190, 235, 49);
		contentPane.add(lblPrecio);

		txtDesc = new JTextField();
		txtDesc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDesc.setBounds(345, 93, 881, 49);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPrice.setColumns(10);
		txtPrice.setBounds(345, 190, 881, 49);
		contentPane.add(txtPrice);

		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String description = txtDesc.getText();
				String price = txtPrice.getText();
				if (checkFields(description, price).length() == 0) {
					write(description, price);
				} else {
					lblError.setText(checkFields(description, price));
					lblError.setBounds(345, 304, 590, 49);
					
				}

			}
		});
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlta.setBounds(957, 304, 279, 49);
		contentPane.add(btnAlta);

		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblError);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(105, 390, 1130, 319);
		contentPane.add(textArea);

		JButton btnAlta_1 = new JButton("Visualizar productos");
		btnAlta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				read();
			}
		});
		btnAlta_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlta_1.setBounds(957, 743, 279, 49);
		contentPane.add(btnAlta_1);

	}

	public static void write(String descrip, String price) {
		try {
			if (file.createNewFile() == true) {
			}
			FileWriter fWriter;
			fWriter = new FileWriter("doc.txt", true);
			fWriter.append(descrip + " " + price);
			fWriter.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static String read() {
		String fileTxt = "";
		try {
			if (file.exists()) {
				Scanner sc = new Scanner(file);
				while (sc.hasNext()) {
					fileTxt += sc.nextLine();
				}
				sc.close();
			} else {
				fileTxt = "Todavía no hay registros :)";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileTxt;
	}

	public static String checkFields(String descrip, String pric) {
		String description = descrip.trim();
		String price = pric.trim();
		if (description.length() == 0 || price.length() == 0) {
			return "No puede dejar los campos en blanco";
		}

		return "";

	}
}
