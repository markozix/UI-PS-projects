package main;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.BogiReport;

public class BogdanWindow extends JDialog {

	public BogdanWindow() {
		setTitle("Report");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JLabel lbl = new JLabel("ID Firme");
		JTextField tf = new JTextField();
		JButton btn = new JButton("Report");
		btn.addActionListener(new BogiReport(tf));
		
		add(lbl, BorderLayout.NORTH);
		add(tf, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
	}
}
