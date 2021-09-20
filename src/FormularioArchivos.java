
/**
 * @author Marta Molina Aguilera
 * <p>Esta aplicación tiene cómo objetivo permitir al usuario ser capaz de introducir 
 * productos en un archivo .txt y visualizarlo en la misma pantalla si así lo desea.</p>
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;

import extensiones.NewScrollBar;
import extensiones.RoundButton;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Dimension;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import java.io.*;
import java.util.Scanner;

public class FormularioArchivos extends JFrame {

	private static JPanel contentPane;
	private static JTextField txtDesc, txtPrice;
	private static String fileName = "doc.txt";
	private static File file = new File(fileName);
	private static ImageIcon img = new ImageIcon("imgs/martaMolina.png");
	private static ImageIcon rectangle1 = new ImageIcon("imgs/rectangle1.png");
	private static ImageIcon rectangle2 = new ImageIcon("imgs/rectangle2.png");
	private static JLabel lblError, lblDesc, lblPrecio, lblAlta, lblGafas, lblClip1, lblClip2, lblClip3, lblClip4,
			lblVisualizar;
	private static JTextArea textArea;
	private static JScrollPane scrollPane;
	private static JButton btnAlta, btnVisualizar;
	private static JLabel lblRectangle1, lblRectangle2;
	private static JFrame frame;

	/**
	 * Main que crea, lanza el frame/ventana, lo hace visible y cambia el icono del
	 * mismo mostrado en la esquina superior y en la barra de tareas.
	 * 
	 * @param args
	 * @throws Exception e: Se genera esta excepción si hubiera algún error al
	 *                   lanzar el frame.
	 */
	public static void main(String[] args) {
		// Lanza la ventana y la hace visible
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FormularioArchivos();
					// Cambia el icono de la ventana
					frame.setTitle("Marta MA - Formulario archivos");
					frame.setIconImage(img.getImage());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de FormularioArchivos Aplica los atributos estéticos a la ventana
	 * y los eventsListeners a cada elemento que los precise.
	 * 
	 * @param title: Título de la ventana
	 * 
	 */
	public FormularioArchivos() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				for (int i = 0; i < 2; ++i) {
					if (i == 0) {
						relocateElements();
					} else {
						if (textArea.getText().length() > 0) {
							String text = textArea.getText();
							textArea.setText(text);
						} else {
							textArea.setText(" ");
						}
					}
				}
			}
		});

		// Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 70, 980, 939);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 109, 119)));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(131, 197, 190));
		contentPane.setLayout(null);

		// Mover elemento cuando se redimensione la ventana, traer el textArea al
		// frente.
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
				for (int i = 0; i < 2; ++i) {
					if (i == 0) {
						relocateElements();
					} else {
						if (textArea.getText().length() > 0) {
							String text = textArea.getText();
							textArea.setText(text);
						} else {
							textArea.setText(" ");
						}
					}
				}
			}
		});

		// Imagen - Gafas
		lblGafas = new JLabel("");
		Image gafas = new ImageIcon("imgs/gafas.png").getImage().getScaledInstance(343, 249,
				java.awt.Image.SCALE_SMOOTH);
		lblGafas.setIcon(new ImageIcon(gafas));
		lblGafas.setBounds(621, 198, 343, 249);
		contentPane.add(lblGafas);

		// Imagen - Clip1
		lblClip1 = new JLabel("");
		Image newclip = new ImageIcon("imgs/clip.png").getImage().getScaledInstance(25, 25,
				java.awt.Image.SCALE_SMOOTH);
		lblClip1.setIcon(new ImageIcon(newclip));
		lblClip1.setBounds(75, 385, 25, 25);
		contentPane.add(lblClip1);

		// Imagen - Clip2
		lblClip2 = new JLabel("");
		lblClip2.setIcon(new ImageIcon(newclip));
		lblClip2.setBounds(820, 385, 25, 25);
		contentPane.add(lblClip2);

		// Imagen - Clip3
		lblClip3 = new JLabel("");
		lblClip3.setIcon(new ImageIcon(newclip));
		lblClip3.setBounds(820, 30, 25, 25);
		contentPane.add(lblClip3);

		// Imagen - Clip4
		lblClip4 = new JLabel("");
		lblClip4.setIcon(new ImageIcon(newclip));
		lblClip4.setBounds(75, 30, 25, 25);
		contentPane.add(lblClip4);

		// Label - Descripción
		lblDesc = new JLabel("Descripción del artículo");
		lblDesc.setForeground(new Color(0, 109, 119));
		lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDesc.setBounds(250, 30, 235, 49);
		contentPane.add(lblDesc);

		// Label - Precio
		lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(new Color(0, 109, 119));
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(250, 135, 235, 49);
		contentPane.add(lblPrecio);

		// Label sobre botón - Alta
		lblAlta = new JLabel("Alta");
		lblAlta.setForeground(Color.WHITE);
		lblAlta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAlta.setBounds(440, 280, 53, 49);
		contentPane.add(lblAlta);

		// Label sobre botón
		lblVisualizar = new JLabel("Visualizar productos");
		lblVisualizar.setForeground(Color.WHITE);
		lblVisualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVisualizar.setBounds(370, 820, 205, 49);
		contentPane.add(lblVisualizar);

		// Campo de texto - Descripción del artículo
		Border bordertxtFields = BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(214, 231, 255), 2),
				BorderFactory.createLineBorder(new Color(235, 243, 255), 10));
		txtDesc = new JTextField();
		txtDesc.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				lblError.setText("");
			}
		});
		txtDesc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDesc.setBorder(bordertxtFields);
		txtDesc.setBackground(new Color(235, 243, 255));
		txtDesc.setForeground(new Color(0, 109, 119));
		txtDesc.setMargin(new Insets(2, 22, 2, 22));
		txtDesc.setColumns(10);
		txtDesc.setBounds(248, 80, 441, 49);
		contentPane.add(txtDesc);

		// Campo de texto - Precio
		txtPrice = new JTextField();
		txtPrice.setBorder(bordertxtFields);
		txtPrice.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				lblError.setText("");
			}
		});
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPrice.setBackground(new Color(235, 243, 255));
		txtPrice.setForeground(new Color(0, 109, 119));
		txtPrice.setColumns(10);
		txtPrice.setBounds(248, 185, 441, 49);
		contentPane.add(txtPrice);

		// Label - Error/ Resultado, no se muestra hasta que se ejecute alguna acción
		lblError = new JLabel("");
		lblError.setForeground(new Color(223, 135, 104));
		lblError.setBounds(252, 235, 590, 40);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblError);

		// Área de texto
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setMargin(new Insets(5, 15, 5, 15));
		textArea.setBackground(new Color(235, 243, 255));
		textArea.setForeground(new Color(0, 109, 119));
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(105, 420, 700, 370);
		contentPane.add(textArea);

		// Area de scroll para el área de texto
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUI(new NewScrollBar());
		scrollPane.setBorder(bordertxtFields);
		scrollPane.getViewport().setOpaque(true);
		scrollPane.setBounds(105, 420, 700, 370);
		contentPane.add(scrollPane);

		// Botón - Alta
		btnAlta = new RoundButton();
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String description = txtDesc.getText();
				String price = txtPrice.getText();
				if (checkFields(description, price).length() == 0) {
					write(description, price);
					lblError.setForeground(new Color(131, 197, 190));
					lblError.setText("Producto registrado.");
					txtDesc.setText("");
					txtPrice.setText("");
				} else {
					lblError.setForeground(new Color(223, 135, 104));
					lblError.setText(checkFields(description, price));
				}

			}
		});
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlta.setBounds(320, 280, 279, 49);
		contentPane.add(btnAlta);

		// Botón - Visualizar
		btnVisualizar = new RoundButton();
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.setText(read());
			}
		});
		btnVisualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVisualizar.setBounds(320, 820, 279, 49);
		contentPane.add(btnVisualizar);

		lblRectangle1 = new JLabel("");
		Image newRecImg1 = rectangle1.getImage().getScaledInstance(800, 339, java.awt.Image.SCALE_SMOOTH);
		lblRectangle1.setIcon(new ImageIcon(newRecImg1));
		lblRectangle1.setBounds(60, 15, 800, 339);
		contentPane.add(lblRectangle1);

		lblRectangle2 = new JLabel("");
		lblRectangle2.setBounds(60, 370, 800, 520);
		Image newRecImg2 = rectangle2.getImage().getScaledInstance(800, 520, java.awt.Image.SCALE_SMOOTH);
		lblRectangle2.setIcon(new ImageIcon(newRecImg2));
		contentPane.add(lblRectangle2);

	}

	/**
	 * Recoloca los elementos de la pantalla en el momento que la ventana pasa a
	 * completa, o parcial.
	 */
	private static void relocateElements() {
		Dimension screen = frame.getSize();
		int screenW = screen.width;
		int screenH = screen.height;

		if (screenW > 980) {
			if (screenH > 1000) {
				lblGafas.setBounds((screenW / 2 - 980 / 2) + 621, screenH / 2 + 198, 343, 249);
			} else {
				lblGafas.setBounds((screenW / 2 - 980 / 2) + 621, 198, 343, 249);
			}
			textArea.setBounds((screenW / 2 - 980 / 2) + 105, 420, 700, 370);
			scrollPane.setBounds((screenW / 2 - 980 / 2) + 105, 420, 700, 370);
			lblClip1.setBounds((screenW / 2 - 980 / 2) + 75, 385, 25, 25);
			lblClip2.setBounds((screenW / 2 - 980 / 2) + 820, 385, 25, 25);
			lblClip3.setBounds((screenW / 2 - 980 / 2) + 75, 30, 25, 25);
			lblClip4.setBounds((screenW / 2 - 980 / 2) + 820, 30, 25, 25);
			lblDesc.setBounds((screenW / 2 - 980 / 2) + 250, 30, 235, 49);
			lblPrecio.setBounds((screenW / 2 - 980 / 2) + 250, 135, 235, 49);
			lblAlta.setBounds((screenW / 2 - 980 / 2) + 440, 280, 53, 49);
			lblVisualizar.setBounds((screenW / 2 - 980 / 2) + 370, 820, 205, 49);
			txtDesc.setBounds((screenW / 2 - 980 / 2) + 248, 80, 441, 49);
			txtPrice.setBounds((screenW / 2 - 980 / 2) + 248, 185, 441, 49);
			lblError.setBounds((screenW / 2 - 980 / 2) + 252, 235, 590, 40);
			btnAlta.setBounds((screenW / 2 - 980 / 2) + 320, 280, 279, 49);
			btnVisualizar.setBounds((screenW / 2 - 980 / 2) + 320, 820, 279, 49);
			lblRectangle1.setBounds((screenW / 2 - 980 / 2) + 60, 15, 800, 339);
			lblRectangle2.setBounds((screenW / 2 - 980 / 2) + 60, 370, 800, 520);
		} else {
			lblGafas.setBounds(621, 198, 343, 249);
			lblClip1.setBounds(75, 385, 25, 25);
			lblClip2.setBounds(820, 385, 25, 25);
			lblClip3.setBounds(820, 30, 25, 25);
			lblClip4.setBounds(75, 30, 25, 25);
			lblDesc.setBounds(250, 30, 235, 49);
			lblPrecio.setBounds(250, 135, 235, 49);
			lblAlta.setBounds(440, 280, 53, 49);
			lblVisualizar.setBounds(370, 820, 205, 49);
			txtDesc.setBounds(248, 80, 441, 49);
			txtPrice.setBounds(248, 185, 441, 49);
			lblError.setBounds(252, 235, 590, 40);
			scrollPane.setBounds(105, 420, 700, 370);
			textArea.setBounds(105, 420, 700, 370);
			btnAlta.setBounds(320, 280, 279, 49);
			btnVisualizar.setBounds(320, 820, 279, 49);
			lblRectangle1.setBounds(60, 15, 800, 339);
			lblRectangle2.setBounds(60, 370, 800, 520);
		}
	}

	/**
	 * Comprueba que el archivo en el que se guardarán los datos existe. Escribe el
	 * par de datos recibido en este seguido de un salto de línea.
	 * 
	 * @param descrip: Recibe el texto introducido en el TextField de "txtDesc".
	 * @param price:   Recibe el texto introducido en el TextField de "txtPrice".
	 * @throws IOException e1: Es lanzado si el FileWriter genera alguna ecepción.
	 */
	public static void write(String descrip, String price) {
		try {
			if (file.createNewFile() == true) {
			}
			FileWriter fWriter;
			fWriter = new FileWriter("doc.txt", true);
			fWriter.append("- " + descrip + " -> " + price + "\r\n");
			fWriter.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Este método comprueba que exista el archivo "file" declarado en la parte
	 * superior del código, si es así lee el contenido del mismo mediante el uso de
	 * un Scanner y guarda el contenido en la variable "fileTxt:". Si no existiera,
	 * devolvería por el área de texto un mensaje de que no existen registros.
	 * 
	 * @return fileTxt: Variable de tipo String en la que es guardado el texto leído
	 *         del archivo pertinente.
	 * @throws FileNotFoundException e: es lanzado en caso de que este archivo no
	 *                               exista.
	 */
	public static String read() {
		String fileTxt = "";
		try {
			int num = 1;
			if (file.exists()) {
				Scanner sc = new Scanner(file);
				while (sc.hasNext()) {
					fileTxt += num + sc.nextLine() + " € \r\n";
					++num;
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

	/**
	 * Comprueba que haya contenido en los campos de texto: "txtDesc" y "txtPrice";
	 * al tiempo que comprueba que el dato introducido en el precio sea un número.
	 * 
	 * @param descrip: Recibe el texto introducido en el TextField de "txtDesc".
	 * @param price:   Recibe el texto introducido en el TextField de "txtPrice".
	 * @return mensaje: En caso de que no pase alguno de los condicionales; retorna
	 *         un mensaje de error.
	 * @throws Exception e: en caso de que la información introducida en "txtPrice"
	 *                   no fuera numérica, lanzaría una excepción retornando un
	 *                   mensaje de error para {@link #lblError} .
	 */
	public static String checkFields(String descrip, String pric) {
		String description = descrip.trim();
		String price = pric.trim();
		String mensaje = "";
		if (description.length() == 0 || price.length() == 0) {
			mensaje = "No puede dejar los campos en blanco";
			return mensaje;
		}
		try {
			Double.parseDouble(price);
		} catch (Exception e) {
			mensaje = "Por favor, introduce sólo números en Precio";
			return mensaje;
		}
		return mensaje;

	}

}
