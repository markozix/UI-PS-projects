package main;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.AboutController;

public class MenuBar extends JMenuBar {

	public MenuBar(final JFrame parent) {

		// meni

		// about dugme
		JMenuItem about = new JMenuItem("About");
		about.setMaximumSize(new Dimension(45, 50));

		AboutController aboutController = new AboutController(parent);
		add(about);
		about.addActionListener(aboutController);

	}

}
