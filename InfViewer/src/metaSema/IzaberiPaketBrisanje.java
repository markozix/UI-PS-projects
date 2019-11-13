package metaSema;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

import controller.IzaberiPaketBrisanjeAkcija;
import modeli.InformacioniResurs;
import modeli.Paket;

public class IzaberiPaketBrisanje extends JDialog {

	private JList<Paket> lista;
	private DefaultListModel<Paket> model;
	
	public IzaberiPaketBrisanje() {
		model = new DefaultListModel<>();
		lista = new JList<>(model);
		setTitle("Izaberite paket koji se brise");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JScrollPane pane = new JScrollPane(lista);
		JButton dugme = new JButton("Izaberi");
		InformacioniResurs resurs = EditorMetaSeme.getInstance().getResurs();
		for(int i = 0; i < resurs.getChildCount(); i++) {
			Paket e = (Paket)resurs.getChildAt(i);
			model.addElement(e);
		}
		dugme.addActionListener(new IzaberiPaketBrisanjeAkcija(this));
		add(pane, BorderLayout.NORTH);
		add(dugme, BorderLayout.SOUTH);
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
