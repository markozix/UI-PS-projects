package controller.state;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ChooseANDOR extends JDialog {

	public ChooseANDOR() {
		setTitle("Izaberite vrstu pretrage");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JButton prvo = new JButton("AND");
		JButton drugo = new JButton("OR");
		
		prvo.addActionListener(new SearchAND(this));
		drugo.addActionListener(new SearchOR(this));
		
		add(prvo, BorderLayout.NORTH);
		add(drugo, BorderLayout.SOUTH);
	}
}
