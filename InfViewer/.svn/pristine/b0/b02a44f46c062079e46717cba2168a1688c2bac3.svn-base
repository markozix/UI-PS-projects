package metaSema;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.PotvrdiEntitet;
import controller.PotvrdiPaket;
import modeli.InformacioniResurs;
import modeli.Paket;

public class PaketDialog extends JDialog {

	private JList<Paket> lista;
	private DefaultListModel<Paket> model;
	
	public PaketDialog() {
//		model = new DefaultListModel<>();
//		lista = new JList<>(model);
//		setTitle("Izaberite paket koji dodajete");
//		setSize(300, 300);
//		setLocationRelativeTo(null);
//		setVisible(true);
//		
//		JScrollPane pane = new JScrollPane(lista);
//		JButton dugme = new JButton("Izaberi");
//		InformacioniResurs resurs = EditorMetaSeme.getInstance().getResurs();
//		Paket p = new Paket();
//		Paket p1 = new Paket();
//		Paket p2 = new Paket();
//		Paket p3 = new Paket();
//		p.setNaziv("Serijski");
//		p1.setNaziv("Sekvencijalni");
//		p2.setNaziv("Indeks-Sekvencijalni");
//		p3.setNaziv("Baza");
//		model.addElement(p);
//		model.addElement(p1);
//		model.addElement(p2);
//		model.addElement(p3);
//		dugme.addActionListener(new PotvrdiPaket(this));
//		add(pane, BorderLayout.NORTH);
//		add(dugme, BorderLayout.SOUTH);
		JTextArea ta = new JTextArea();
		JButton dugme = new JButton("Dodaj");
		dugme.addActionListener(new PotvrdiPaket(ta, this));
		
		setTitle("MetaOpis - Paket");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(ta);
		add(dugme, BorderLayout.SOUTH);
		ta.setFont(ta.getFont().deriveFont(14f));
		
		File fajl = new File("MetaOpisMoj.txt");
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

	public JList<Paket> getLista() {
		return lista;
	}

	public void setLista(JList<Paket> lista) {
		this.lista = lista;
	}

	public DefaultListModel<Paket> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<Paket> model) {
		this.model = model;
	}
	
}
