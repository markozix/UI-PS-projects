package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.crypto.SecretKeyFactorySpi;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import akcije.OWSokAction;
import akcije.OtvoriWorkspaceAction;

public class BiranjeWorkspacea extends JDialog {
	JButton btn;
	static JTextField tf = new JTextField();
	static File fajl;

	public BiranjeWorkspacea() {
		napravi();
	}

	public void napravi() {
		setLocationRelativeTo(null);
		setTitle("Izaberite Workspace");
		setSize(500, 100);
		FlowLayout flow = new FlowLayout();
		setLayout(flow);
		Label labela = new Label("Workspace: ");
		tf.setPreferredSize(new Dimension(200, 25));
		tf.setEditable(false);
		btn = new JButton("Browse");
		btn.addActionListener(new OtvoriWorkspaceAction(this));
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new OWSokAction(this));
		setAlwaysOnTop(true);
		add(labela);
		add(tf);
		add(btn);
		add(btOk);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public static File getFajl() {
		return fajl;
	}

	public static void setFajl(File fajl) {
		BiranjeWorkspacea.fajl = fajl;
	}

	public JButton getBtn() {
		return btn;
	}

	public void setBtn(JButton btn) {
		this.btn = btn;
	}

	public static JTextField getTf() {
		return tf;
	}

	public static void setTf(JTextField tf) {
		BiranjeWorkspacea.tf = tf;
	}

}
