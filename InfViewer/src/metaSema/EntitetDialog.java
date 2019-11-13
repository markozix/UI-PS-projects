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

import controller.PotvrdiEntitet;
import modeli.Paket;

public class EntitetDialog extends JDialog {

	private Paket paket;
	
	public EntitetDialog(Paket paket) {
		this.paket = paket;
		JTextArea ta = new JTextArea();
		JButton dugme = new JButton("Dodaj");
		dugme.addActionListener(new PotvrdiEntitet(ta, this, paket));
		
		setTitle("MetaOpis - Entitet");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(ta);
		add(dugme, BorderLayout.SOUTH);
		ta.setFont(ta.getFont().deriveFont(14f));
		
		File fajl = new File("MetaOpisMoj2.txt");
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

	public Paket getPaket() {
		return paket;
	}

	public void setPaket(Paket paket) {
		this.paket = paket;
	}
	
}
