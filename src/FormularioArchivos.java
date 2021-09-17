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
		lblNewLabel.setBounds(93, 93, 235, 49);
		contentPane.add(lblNewLabel);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(105, 190, 235, 49);
		contentPane.add(lblPrecio);

		txtDesc = new JTextField();
		txtDesc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDesc.setBounds(345, 93, 881, 49);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPrice.setColumns(10);
		txtPrice.setBounds(345, 190, 881, 49);
		contentPane.add(txtPrice);

		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String description = txtDesc.getText();
				String price = txtPrice.getText();
				write(description, price);
			}
		});
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlta.setBounds(345, 304, 208, 49);
		contentPane.add(btnAlta);

		JLabel lblNewLabel_1 = new JLabel("Resultado");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(661, 304, 241, 49);
		contentPane.add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(105, 444, 1130, 374);
		contentPane.add(textArea);

		JButton btnAlta_1 = new JButton("Visualizar productos");
		btnAlta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				read();
			}
		});
		btnAlta_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlta_1.setBounds(345, 384, 279, 49);
		contentPane.add(btnAlta_1);

	}

	public static void write(String descrip, String price) {
		try {
			if (file.createNewFile() == true) {
			}
			FileWriter fWriter;
			System.out.println(descrip);
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
			if(file.exists()) {
				Scanner sc = new Scanner(file);
				while(sc.hasNext()) {
					fileTxt+= sc.nextLine();
				}	
				sc.close();
			}else {
				fileTxt="Todavía no hay registros :)";
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileTxt;
	}
}
