package main;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.NinaReport;

public class NinaWindow extends JDialog {

	public NinaWindow() {
		setTitle("Report");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JLabel lbl = new JLabel("Region");
		JTextField tf = new JTextField();
		JButton btn = new JButton("Report");
		btn.addActionListener(new NinaReport(tf));
		
		
		add(lbl, BorderLayout.NORTH);
		add(tf, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
	}
}
