package metaSema;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

import controller.IzaberiAtributBrisanjeAkcija;
import modeli.Atribut;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Paket;


public class IzaberiAtributBrisanje extends JDialog {

	private JList<Atribut> lista;
	private DefaultListModel<Atribut> model;
	
	public IzaberiAtributBrisanje() {
		model = new DefaultListModel<>();
		lista = new JList<>(model);
		setTitle("Izaberite atribut koji se brise");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JScrollPane pane = new JScrollPane(lista);
		JButton dugme = new JButton("Izaberi");
		InformacioniResurs resurs = EditorMetaSeme.getInstance().getResurs();
		for(int i = 0; i < resurs.getChildCount(); i++) {
			Paket p = (Paket)resurs.getChildAt(i);
			for(int l = 0; l < p.getChildCount(); l++) {
				Entitet e = (Entitet)p.getChildAt(l);
				for(int j = 0; j < e.getChildCount(); j++) {
					Atribut a = (Atribut)e.getChildAt(j);
					model.addElement(a);
				}
			}
		}
		dugme.addActionListener(new IzaberiAtributBrisanjeAkcija(this));
		add(pane, BorderLayout.NORTH);
		add(dugme, BorderLayout.SOUTH);
	}

	public JList<Atribut> getLista() {
		return lista;
	}

	public void setLista(JList<Atribut> lista) {
		this.lista = lista;
	}

	public DefaultListModel<Atribut> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<Atribut> model) {
		this.model = model;
	}
	
}
