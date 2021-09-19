package extensiones;

/**
 * @author Marta Molina Aguilera
 * <p>Clase que la apariencia del Scrollbar mediante la herencia de la clase BasicScrollBarUI.</p>
 * https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html#clipRect(int,%20int,%20int,%20int)
 * 
 */
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class NewScrollBar extends BasicScrollBarUI {
	/**
	 * Constructor. Asigna valor al ancho de la barra de scroll.
	 */
	public NewScrollBar() {
		this.scrollBarWidth = 15;
	}

	/**
	 * Configura el color de la barra de scroll y el fondo.
	 */
	protected void configureScrollBarColors() {
		this.thumbColor = new Color(0, 109, 119);
		this.trackColor = new Color(131, 197, 190);
	}

	/**
	 * Retona un arrow button con dimensiones 0,0 haciendo que este desaparezca.
	 * 
	 * @param orientation: Orientación del botón tipo arrow (north o south). Viene
	 *                     dada por el propio objeto "DecreaseButton"
	 * @return deleteButton() creado con {@link #deleteButton()}
	 */
	protected JButton createDecreaseButton(int orientacion) {
		return deleteButton();
	}

	/**
	 * Retona un arrow button con dimensiones 0,0 haciendo que este desaparezca.
	 * 
	 * @param orientation: Orientación del botón tipo arrow (north o south). Viene
	 *                     dada por el propio objeto "DecreaseButton"
	 * @return deleteButton() creado con {@link #deleteButton()}
	 */
	protected JButton createIncreaseButton(int orientacion) {
		return deleteButton();
	}

	/**
	 * Crea un botón con dimeinsiones 0,0; creando la ilusiónd e que este no existe.
	 * 
	 * @return button()
	 */
	private JButton deleteButton() {
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(0, 0));
		button.setMinimumSize(new Dimension(0, 0));
		button.setMaximumSize(new Dimension(0, 0));
		return button;
	}
}
