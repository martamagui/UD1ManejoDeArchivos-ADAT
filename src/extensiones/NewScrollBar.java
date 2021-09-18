package extensiones;

/**
 * @author Marta Molina Aguilera
 * <p>Clase creada para cambiar la apariencia del Scroll </p>
 * https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html#clipRect(int,%20int,%20int,%20int)
 * https://javawithus.com/en/how-to-make-round-corners-in-jbutton-with-background-color-in-java/
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class NewScrollBar extends BasicScrollBarUI {
	public NewScrollBar() {
		this.scrollBarWidth = 15;
	}
	protected void configureScrollBarColors() {
		this.thumbColor = new Color(0, 109, 119);
		this.trackColor = new Color(131, 197, 190);
	}
	protected void painThumb(Graphics g,JComponent c,Rectangle thumB) {
		
	}
	protected JButton createDecreaseButton(int orientacion) {
		return deleteButton();
	}
	protected JButton createIncreaseButton(int orientacion) {
		return deleteButton();
	}
	private JButton deleteButton() {
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(0, 0));
		button.setMinimumSize(new Dimension(0, 0));
		button.setMaximumSize(new Dimension(0, 0));
		return button;
	}
}
