package metaSema;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

import controller.IzaberiEntitetBrisanjeAkcija;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Paket;

public class IzaberiEntitetBrisanje extends JDialog {

	private JList<Entitet> lista;
	private DefaultListModel<Entitet> model;
	
	public IzaberiEntitetBrisanje() {
		model = new DefaultListModel<>();
		lista = new JList<>(model);
		setTitle("Izaberite entitet koji se brise");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JScrollPane pane = new JScrollPane(lista);
		JButton dugme = new JButton("Izaberi");
		InformacioniResurs resurs = EditorMetaSeme.getInstance().getResurs();
		for(int i = 0; i < resurs.getChildCount(); i++) {
			Paket p = (Paket)resurs.getChildAt(i);
			for(int j = 0; j < p.getChildCount(); j++) {
				Entitet e = (Entitet)p.getChildAt(j);
				model.addElement(e);
			}
		}
		dugme.addActionListener(new IzaberiEntitetBrisanjeAkcija(this));
		add(pane, BorderLayout.NORTH);
		add(dugme, BorderLayout.SOUTH);
	}

	public JList<Entitet> getLista() {
		return lista;
	}

	public void setLista(JList<Entitet> lista) {
		this.lista = lista;
	}

	public DefaultListModel<Entitet> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<Entitet> model) {
		this.model = model;
	}
	
}