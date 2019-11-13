package main;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import akcije.CascadeViewAction;
import akcije.DodajDeljeniAction;
import akcije.DodajDokumentAction;
import akcije.DodajProjekatAction;
import akcije.DodajSlotAction;
import akcije.DodajStranicuAction;
import akcije.HorizontalViewAction;
import akcije.OtvoriProjekatAction;
import akcije.OtvoriWorkspaceAction;
import akcije.PodeliDokumentAction;
import akcije.SacuvajProjekatAction;
import akcije.SacuvajWorkspaceAction;
import akcije.UkloniDokumentAction;
import akcije.UkloniElementAction;
import akcije.UkloniProjekatAction;
import akcije.UkloniSlotAction;
import akcije.UkloniStranicuAction;
import akcije.VerticalViewAction;

public class MenuBar extends JMenuBar {
	JRadioButtonMenuItem kaskadno = new JRadioButtonMenuItem("Cascade");
	JRadioButtonMenuItem vertikalno = new JRadioButtonMenuItem("Tile Vertically");
	JRadioButtonMenuItem horizontalno = new JRadioButtonMenuItem("Tile Horizontally");

	public MenuBar(final JFrame parent) {

		JMenu meniFile = new JMenu("File");

		JMenu add = new JMenu("Add");
		JMenuItem addProjekat = new JMenuItem("Project");
		addProjekat.addActionListener(new DodajProjekatAction());
		JMenuItem addDokument = new JMenuItem("Document");
		addDokument.addActionListener(new DodajDokumentAction());
		JMenuItem addStranica = new JMenuItem("Page");
		addStranica.addActionListener(new DodajStranicuAction());
		JMenuItem addSlot = new JMenuItem("Slot");
		addSlot.addActionListener(new DodajSlotAction());
		JMenuItem addElement = new JMenuItem("Element");
		add.add(addProjekat);
		add.add(addDokument);
		add.add(addStranica);
		add.add(addSlot);
		add.add(addElement);

		JMenu remove = new JMenu("Remove");
		JMenuItem deleteProjekat = new JMenuItem("Project");
		deleteProjekat.addActionListener(new UkloniProjekatAction());
		JMenuItem deleteDokument = new JMenuItem("Document");
		deleteDokument.addActionListener(new UkloniDokumentAction());
		JMenuItem deleteStranica = new JMenuItem("Page");
		deleteStranica.addActionListener(new UkloniStranicuAction());
		JMenuItem deleteSlot = new JMenuItem("Slot");
		deleteSlot.addActionListener(new UkloniSlotAction());
		JMenuItem deleteElement = new JMenuItem("Element");
		deleteElement.addActionListener(new UkloniElementAction());
		remove.add(deleteProjekat);
		remove.add(deleteDokument);
		remove.add(deleteStranica);
		remove.add(deleteSlot);
		remove.add(deleteElement);
		
		JMenu save = new JMenu("Save");
		JMenuItem saveProjekat = new JMenuItem("Save Project");
		saveProjekat.addActionListener(new SacuvajProjekatAction());
		save.add(saveProjekat);
		JMenuItem saveWorkspace = new JMenuItem("Save Workspace");
		saveWorkspace.addActionListener(new SacuvajWorkspaceAction());
		save.add(saveWorkspace);
		
		
		
		JMenu open = new JMenu("Open");
		JMenuItem openProjekat = new JMenuItem("Open Project");
		openProjekat.addActionListener(new OtvoriProjekatAction());
		open.add(openProjekat);
		JMenuItem openWorkspace = new JMenuItem("Open Workspace");
		openWorkspace.addActionListener(new OtvoriWorkspaceAction(null));
		open.add(openWorkspace);
		
		JMenuItem share = new JMenuItem("Share document");
		share.addActionListener(new PodeliDokumentAction());
		JMenuItem shareProject = new JMenuItem("Share to project");
		shareProject.addActionListener(new DodajDeljeniAction());
		
		meniFile.add(add);
		meniFile.add(remove);
		meniFile.add(save);
		meniFile.add(open);
		meniFile.add(share);
		meniFile.add(shareProject);
		add(meniFile);
		
		JMenu meniView = new JMenu("View");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(kaskadno);
		bg.add(vertikalno);
		bg.add(horizontalno);
		kaskadno.addActionListener(new CascadeViewAction());
		vertikalno.addActionListener(new VerticalViewAction());
		horizontalno.addActionListener(new HorizontalViewAction());
		
		kaskadno.setSelected(true);
		meniView.add(kaskadno);
		meniView.add(vertikalno);
		meniView.add(horizontalno);
		
		add(meniView);

	}
	
	public int getSelectedOption() {
		if(kaskadno.isSelected()) {
			return 1;
		} else {
			if(vertikalno.isSelected()) {
				return 2;
			} else {
				return 3;
			}
		}
	}

}
