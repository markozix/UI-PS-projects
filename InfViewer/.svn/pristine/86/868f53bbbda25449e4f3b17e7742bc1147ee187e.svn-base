package main;

import java.awt.BorderLayout;

import javax.swing.*;

import controller.MatkeReport;

public class MatovicWindow extends JDialog {

	public MatovicWindow() {
		setTitle("Report");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);

		JLabel lbl = new JLabel("Drzave");
		JTextField tf = new JTextField();
		JButton btn = new JButton("Report");
		btn.addActionListener(new MatkeReport(tf));

		add(lbl, BorderLayout.NORTH);
		add(tf, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
	}
}
