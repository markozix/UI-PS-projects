package metaSema;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

import modeli.InformacioniResurs;

public class OdabirInfResursa extends JDialog {

	public OdabirInfResursa() {
		DefaultListModel<InformacioniResurs> model = new DefaultListModel<>();
		JList<InformacioniResurs> lista = new JList<>(model);
		JScrollPane pane = new JScrollPane(lista);
		JButton izaberi = new JButton("Izaberi");
	}
}
