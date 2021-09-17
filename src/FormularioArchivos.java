import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import botones.RoundButton;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FormularioArchivos extends JFrame {

	private JPanel contentPane;
	private JTextField txtDesc;
	private JTextField txtPrice;
	private static String fileName = "doc.txt";
	private static File file = new File(fileName);
	private static JLabel lblError;
	private static LineBorder lineB = new LineBorder(Color.blue, 2, true);
	private static ImageIcon img = new ImageIcon("icons/martaMolina.png");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioArchivos frame = new FormularioArchivos();
					frame.setIconImage(img.getImage());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormularioArchivos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1373, 878);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 109, 119)));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(237, 246, 249));
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Descripci\u00F3n del art\u00EDculo:");
		lblNewLabel.setForeground(new Color(0, 109, 119));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(105, 93, 235, 49);
		contentPane.add(lblNewLabel);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(new Color(0, 109, 119));
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(105, 190, 235, 49);
		contentPane.add(lblPrecio);
		
		JLabel lblAlta = new JLabel("Alta");
		lblAlta.setForeground(Color.WHITE);
		lblAlta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAlta.setBounds(1078, 304, 53, 49);
		contentPane.add(lblAlta);

		txtDesc = new JTextField();
		txtDesc.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				lblError.setText("");
			}
		});
		
		JLabel lblVisualizar = new JLabel("Visualizar productos");
		lblVisualizar.setForeground(Color.WHITE);
		lblVisualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVisualizar.setBounds(1005, 743, 205, 49);
		contentPane.add(lblVisualizar);
		txtDesc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDesc.setBounds(345, 93, 881, 49);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				lblError.setText("");
			}
		});
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPrice.setColumns(10);
		txtPrice.setBounds(345, 190, 881, 49);
		contentPane.add(txtPrice);

		JButton btnAlta = new RoundButton();
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String description = txtDesc.getText();
				String price = txtPrice.getText();
				if (checkFields(description, price).length() == 0) {
					write(description, price);
					lblError.setForeground(Color.GREEN);
					lblError.setText("Producto registrado.");
				} else {
					lblError.setForeground(Color.RED);
					lblError.setText(checkFields(description, price));
				}

			}
		});
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlta.setBounds(957, 304, 279, 49);
		contentPane.add(btnAlta);

		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(345, 304, 590, 49);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblError);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(105, 390, 1130, 319);
		contentPane.add(textArea);

		JButton btnVisualizar = new RoundButton();
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				read();
			}
		});
		btnVisualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVisualizar.setBounds(957, 743, 279, 49);
		contentPane.add(btnVisualizar);
		
		

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
		try {
			Double.parseDouble(price);
		} catch (Exception e) {
			return "Por favor, introduce sólo números en Precio";
		}
		return "";

	}
}
