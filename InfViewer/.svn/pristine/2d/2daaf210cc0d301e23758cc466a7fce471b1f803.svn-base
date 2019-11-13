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

import controller.PotvrdiRelacija;
import modeli.Entitet;

public class RelacijaDialog extends JDialog {

	private Entitet entitet1;
	private Entitet entitet2;
	
	public RelacijaDialog(Entitet entitet1, Entitet entitet2) {
		JTextArea ta = new JTextArea();
		JButton dugme = new JButton("Dodaj");
		dugme.addActionListener(new PotvrdiRelacija(this, ta, entitet1, entitet2));
		
		setTitle("MetaOpis - Relacija");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(ta);
		add(dugme, BorderLayout.SOUTH);
		ta.setFont(ta.getFont().deriveFont(14f));
		
		File fajl = new File("MetaOpisRelacija.txt");
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
}
