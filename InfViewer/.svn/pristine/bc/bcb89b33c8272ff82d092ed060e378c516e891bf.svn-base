package metaSema;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

import controller.UcitajResursUpdate;
import main.MainFrame;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Workspace;

public class UpdateIzaberiResurs extends JDialog {

	private JList<InformacioniResurs> lista;
	private DefaultListModel<InformacioniResurs> model;
	
	public UpdateIzaberiResurs() {
		model = new DefaultListModel<>();
		lista = new JList<>(model);
		setTitle("Izaberite informacioni resurs koji se menja");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JScrollPane pane = new JScrollPane(lista);
		JButton dugme = new JButton("Izaberi");
		Workspace work = (Workspace)MainFrame.getInstance().getTree().getModel().getRoot();
		for(int i = 0; i < work.getChildCount(); i++) {
			InformacioniResurs res = (InformacioniResurs)work.getChildAt(i);
			model.addElement(res);
		}
		dugme.addActionListener(new UcitajResursUpdate(this));
		add(pane, BorderLayout.NORTH);
		add(dugme, BorderLayout.SOUTH);
	}

	public JList<InformacioniResurs> getLista() {
		return lista;
	}

	public void setLista(JList<InformacioniResurs> lista) {
		this.lista = lista;
	}

	public DefaultListModel<InformacioniResurs> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<InformacioniResurs> model) {
		this.model = model;
	}

}
