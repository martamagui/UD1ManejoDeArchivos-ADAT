package extensiones;

/**
 * @author Marta Molina Aguilera
 * <p>Clase creada con el propósito de redondear los JButtons mediante el uso de la clase Graphics.
 * La cual incluye el objeto que tiene de la información para las operaciones básicas renderización que Java soporta. </p>
 * https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html#clipRect(int,%20int,%20int,%20int)
 * https://javawithus.com/en/how-to-make-round-corners-in-jbutton-with-background-color-in-java/
 */
import java.awt.*;

import javax.swing.JButton;

public class RoundButton extends JButton {
	/**
	 * Constructor, medidas fijas. Hace el botón transparente.
	 */
	public RoundButton() {
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(279, 49);
		setPreferredSize(size);
		setContentAreaFilled(false);
	}

	/*
	 * Pinta el botón de azul, lo estecha 2 px de alto y ancho, establece sus
	 * medidas 2px por debajo de las originales del botón(279, 49). Redondea 20
	 * horizontalmente y verticalmente.
	 * 
	 * Si este está pulsado cambia a claro
	 */
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			setForeground(new Color(131, 197, 190));
		} else {
			g.setColor(new Color(0, 109, 119));
			setForeground(new Color(237, 246, 249));
		}
		g.fillRoundRect(2, 2, 277, 47, 20, 20);
		super.paintComponent(g);
	}

	/*
	 * Redondea el borde con las mismas medidas que se pintó el rectángulo.
	 * Según el componente es clicado o no cambia el color al mismo que el rectángulo.
	 */
	protected void paintBorder(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(new Color(131, 197, 190));
		} else {
			g.setColor(new Color(0, 109, 119));
		}
		g.drawRoundRect(2, 2, 277, 47, 30, 30);
	}
}
