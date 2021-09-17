package botones;

import java.awt.*;

import javax.swing.JButton;

public class RoundButton extends JButton {
	public RoundButton() {
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(279, 49);
		setPreferredSize(size);
		setContentAreaFilled(false);
	}

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

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(2, 2, 277, 47, 20, 20);
	}
}
