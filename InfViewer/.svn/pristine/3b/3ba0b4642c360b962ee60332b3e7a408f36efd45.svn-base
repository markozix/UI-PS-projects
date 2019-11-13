package controller.state;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ChooseVrstaPretrage2 extends JDialog {

	public ChooseVrstaPretrage2() {
		setTitle("Izaberite vrstu pretrage");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JButton prvo = new JButton("Prvi");
		JButton drugo = new JButton("Svi");
		
		prvo.addActionListener(new SearchPrvi(this));
		drugo.addActionListener(new SearchSvi(this));
		
		add(prvo, BorderLayout.NORTH);
		add(drugo, BorderLayout.SOUTH);
	}
}
