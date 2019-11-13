package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		BiranjeWorkspacea w = new BiranjeWorkspacea();

	}

	public static void uradi() {
		MainFrame frame = MainFrame.getInstance();

		// kreiranje dva toolbara
		// box layout da bi stali jedan ispod drugog

		PrviToolBar toolbar1 = new PrviToolBar();
		toolbar1.setVisible(true);

		DrugiToolBar toolbar2 = new DrugiToolBar();
		toolbar2.setOrientation(JToolBar.VERTICAL);

		toolbar2.setVisible(true);
		toolbar2.setPreferredSize(new Dimension(45, 300));

		frame.add(toolbar1, BorderLayout.NORTH);
		frame.add(toolbar2, BorderLayout.EAST);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
