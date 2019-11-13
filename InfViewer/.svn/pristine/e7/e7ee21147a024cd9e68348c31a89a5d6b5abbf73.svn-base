package controller.state;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ChooseSaveLocation extends JDialog {

	public ChooseSaveLocation(String[][] matrica, int counter, Object[] heder) {
		setTitle("Izaberite vrstu prikaza");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JButton prvo = new JButton("Tabela");
		JButton drugo = new JButton("Fajl");
		
		prvo.addActionListener(new SaveTabela(matrica, this, heder));
		drugo.addActionListener(new SaveFajl(matrica, this, counter));
		
		add(prvo, BorderLayout.NORTH);
		add(drugo, BorderLayout.SOUTH);
	}
}
