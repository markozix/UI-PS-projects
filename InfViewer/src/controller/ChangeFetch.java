package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import main.MainFrame;

public class ChangeFetch implements ActionListener {

	private JTextField tf;

	public ChangeFetch(JTextField tf) {
		this.tf = tf;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().getTrenutniEntitet().setBlockSize(Integer.parseInt(tf.getText()));
	}
}
