package controller.state;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ChooseVrstaPretrage extends JDialog {

	public ChooseVrstaPretrage(boolean bleja) {
		setTitle("Izaberite vrstu pretrage");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JButton prvo = new JButton("Pocetak");
		JButton drugo = new JButton("Poslednji");
		
		prvo.addActionListener(new SearchOdPocetka(this, bleja));
		drugo.addActionListener(new SearchOdPoslednjeg(this, bleja));
		
		add(prvo, BorderLayout.NORTH);
		add(drugo, BorderLayout.SOUTH);
	}
}
