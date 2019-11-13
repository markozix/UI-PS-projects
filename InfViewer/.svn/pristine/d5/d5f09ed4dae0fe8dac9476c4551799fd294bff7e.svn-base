package metaSema;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.DodajAtribut;
import controller.DodajEntitet;
import controller.DodajInfResurs;
import controller.DodajPaket;
import controller.DodajRelacija;
import controller.RemoveAtribut;
import controller.RemoveEntitet;
import controller.RemovePaket;
import controller.RemoveRelacija;
import controller.UpdateAtribut;
import controller.UpdateEntitet;
import controller.UpdateRelacija;
import controller.UpdateResurs;

public class MetaMenuBar extends JMenuBar {

	public MetaMenuBar() {
		JMenu add = new JMenu("Add");
		JMenu remove = new JMenu("Remove");
		JMenu update = new JMenu("Update");
		
		add(add);
		add(remove);
		add(update);
		
		JMenuItem addInf = new JMenuItem("InfResurs");
		addInf.addActionListener(new DodajInfResurs());
		JMenuItem addPaket = new JMenuItem("Paket");
		addPaket.addActionListener(new DodajPaket());
		JMenuItem addEntitet = new JMenuItem("Entitet");
		addEntitet.addActionListener(new DodajEntitet());
		JMenuItem addAtribut = new JMenuItem("Atribut");
		addAtribut.addActionListener(new DodajAtribut());
		JMenuItem addRelacija = new JMenuItem("Relacija");
		addRelacija.addActionListener(new DodajRelacija());
		add.add(addInf);
		add.add(addPaket);
		add.add(addEntitet);
		add.add(addAtribut);
		add.add(addRelacija);
		
		JMenuItem removePaket = new JMenuItem("Paket");
		removePaket.addActionListener(new RemovePaket());
		JMenuItem removeEntitet = new JMenuItem("Entitet");
		removeEntitet.addActionListener(new RemoveEntitet());
		JMenuItem removeAtribut = new JMenuItem("Atribut");
		removeAtribut.addActionListener(new RemoveAtribut());
		JMenuItem removeRelacija = new JMenuItem("Relacija");
		removeRelacija.addActionListener(new RemoveRelacija());
		remove.add(removePaket);
		remove.add(removeEntitet);
		remove.add(removeAtribut);
		remove.add(removeRelacija);
		
		JMenuItem updateInf = new JMenuItem("InfResurs");
		updateInf.addActionListener(new UpdateResurs());
		JMenuItem updatePaket = new JMenuItem("Paket");
		JMenuItem updateEntitet = new JMenuItem("Entitet");
		updateEntitet.addActionListener(new UpdateEntitet());
		JMenuItem updateAtribut = new JMenuItem("Atribut");
		updateAtribut.addActionListener(new UpdateAtribut());
		JMenuItem updateRelacija = new JMenuItem("Relacija");
		updateRelacija.addActionListener(new UpdateRelacija());
		update.add(updateInf);
		update.add(updatePaket);
		update.add(updateEntitet);
		update.add(updateAtribut);
		update.add(updateRelacija);
	}
}
