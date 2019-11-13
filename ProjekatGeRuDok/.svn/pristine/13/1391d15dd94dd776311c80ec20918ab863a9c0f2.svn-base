package akcije;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.tree.TreePath;

import main.MainFrame;
import model.Dokument;
import model.Projekat;
import view.ProjekatView;

public class DodajProjekatAction implements ActionListener {
	private static int br = 1;

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Projekat p = new Projekat("Projekat_" + br);
		br++;
		MainFrame.getInstance().getTree().addProjekat(p);
		ProjekatView view = new ProjekatView();
		view.setProjekat(p);
		MainFrame.getInstance().getDesniDesktop().add(view);
		try {
			view.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

	}
}
