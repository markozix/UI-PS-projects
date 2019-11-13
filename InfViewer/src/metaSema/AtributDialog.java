package metaSema;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;

import controller.PotvrdiAtribut;
import modeli.Entitet;

public class AtributDialog extends JDialog {

	private Entitet entitet;
	
	public AtributDialog(Entitet entitet) {
		this.entitet = entitet;
		JTextArea ta = new JTextArea();
		JButton dugme = new JButton("Dodaj");
		dugme.addActionListener(new PotvrdiAtribut(this, ta, entitet));
		
		setTitle("MetaOpis - Atribut");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(ta);
		add(dugme, BorderLayout.SOUTH);
		ta.setFont(ta.getFont().deriveFont(14f));
		
		File fajl = new File("MetaOpisAtribut.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(fajl));
			ta.setEditable(true);
			String ucitaj;
			while((ucitaj = br.readLine()) != null) {
				ta.append(ucitaj);
				ta.append("\n");
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Entitet getEntitet() {
		return entitet;
	}

	public void setEntitet(Entitet entitet) {
		this.entitet = entitet;
	}
	
}