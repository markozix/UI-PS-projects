package main;

import javax.swing.JFrame;

public class Main {


	public static void main(String[] args) {
		MainFrame frame = MainFrame.getInstance();
		//otvara odma na fullscreen
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}