package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import main.About;


	public class AboutController implements ActionListener {
		private JFrame parent = null;

		public AboutController(final JFrame parent) {
			this.parent = parent;
		}

	
		@Override
		public void actionPerformed(ActionEvent arg0) {
			About prozor = new About(parent, "About", true);
			prozor.setVisible(true);
		}

	}


