package metaSema;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

import controller.UpdateIzaberiRelacijaAkcija;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Paket;
import modeli.Relacija;

public class UpdateIzaberiRelacija extends JDialog {

	private JList<Relacija> lista;
	private DefaultListModel<Relacija> model;
	
	public UpdateIzaberiRelacija() {
		model = new DefaultListModel<>();
		lista = new JList<>(model);
		setTitle("Izaberite relaciju");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JScrollPane pane = new JScrollPane(lista);
		JButton dugme = new JButton("Izaberi");
		InformacioniResurs resurs = EditorMetaSeme.getInstance().getResurs();
		for(int i = 0; i < resurs.getChildCount(); i++) {
			Paket p = (Paket)resurs.getChildAt(i);
			for(int k = 0; k < p.getChildCount(); k++) {
				Entitet e = (Entitet)p.getChildAt(k);
				for(int j = 0; j < e.getRelacije().size(); j++) {
					Relacija r = e.getRelacije().get(j);
					model.addElement(r);
				}
			}
		}
		dugme.addActionListener(new UpdateIzaberiRelacijaAkcija(this));
		add(pane, BorderLayout.NORTH);
		add(dugme, BorderLayout.SOUTH);
	}

	public JList<Relacija> getLista() {
		return lista;
	}

	public void setLista(JList<Relacija> lista) {
		this.lista = lista;
	}

	public DefaultListModel<Relacija> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<Relacija> model) {
		this.model = model;
	}
	
}
