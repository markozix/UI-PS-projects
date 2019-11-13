package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

import akcije.DodajDokumentAction;
import akcije.DodajProjekatAction;
import akcije.DodajSlotAction;
import akcije.DodajSlotProzorAction;
import akcije.DodajStranicuAction;
import akcije.UkloniDokumentAction;
import akcije.UkloniProjekatAction;
import akcije.UkloniSlotAction;
import akcije.UkloniStranicuAction;
import model.Dokument;
import model.LinijaElement;
import model.Projekat;
import model.Slot;
import model.Stranica;
import projectTree.PomocniModel;
import projectTree.PomocniTree;
import view.DokumentView;
import view.ProjekatView;
import workspace.WorkspaceModel;
import workspace.WorkspaceTree;

public class MainFrame extends JFrame implements ClipboardOwner {

	private static MainFrame instance = null;
	private WorkspaceModel wm;
	private WorkspaceTree tree;
	private JDesktopPane desniDesktop;
	private MenuBar meni;
	private PomocniModel pm;
	private PomocniTree pt;
	private Dokument dokumentZaDeljenje;
	private DokumentView viewZaDeljenje;
	private BiranjeWorkspacea w;

	private Clipboard clipboard = new Clipboard(null);

	private MainFrame() {

		napravi();

	}

	private void napravi() {
		meni = new MenuBar(this);
		Toolkit kit = Toolkit.getDefaultToolkit();

		Dimension ss = kit.getScreenSize();
		int sh = ss.height;
		int sw = ss.width;

		setSize(3 * sw / 4, 3 * sh / 4);
		setTitle("GeRuDok");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Drvo
		tree = new WorkspaceTree(); // stablo za komponente
		wm = new WorkspaceModel(BiranjeWorkspacea.getFajl());
		tree.setModel(wm);
		tree.setRootVisible(false);
		tree.setShowsRootHandles(true);

		pt = new PomocniTree();
		pm = new PomocniModel();
		pt.setModel(pm);
		pt.setRootVisible(false);
		pt.setShowsRootHandles(true);

		// Izgled glavnog prozora
		// JPanel lijeviGornji = new JPanel();
		// lijeviGornji.setBackground(Color.white);
		// lijeviGornji.add(tree);
		// JPanel lijeviDonji = new JPanel();
		// lijeviDonji.setBackground(Color.white);

		// popup menu na drvetu

		JPopupMenu jpP = new JPopupMenu();
		JMenuItem dodajDokument = new JMenuItem("Dodaj dokument");
		dodajDokument.addActionListener(new DodajDokumentAction());
		jpP.add(dodajDokument);
		JMenuItem obrisiProjekat = new JMenuItem("Obrisi projekat");
		obrisiProjekat.addActionListener(new UkloniProjekatAction());
		jpP.add(obrisiProjekat);

		JPopupMenu jpD = new JPopupMenu();
		JMenuItem dodajStranicu = new JMenuItem("Dodaj stranicu");
		dodajStranicu.addActionListener(new DodajStranicuAction());
		jpD.add(dodajStranicu);
		JMenuItem obrisiDokument = new JMenuItem("Obrisi dokument");
		obrisiDokument.addActionListener(new UkloniDokumentAction());
		jpD.add(obrisiDokument);

		JPopupMenu jpS = new JPopupMenu();
		JMenuItem dodajSlot = new JMenuItem("Dodaj slot");
		dodajSlot.addActionListener(new DodajSlotProzorAction());
		jpS.add(dodajSlot);
		JMenuItem obrisiStranicu = new JMenuItem("Obrisi stranicu");
		obrisiStranicu.addActionListener(new UkloniStranicuAction());
		jpS.add(obrisiStranicu);

		JPopupMenu jPP = new JPopupMenu();
		JMenuItem dodajProjekat = new JMenuItem("Dodaj Projekat");
		dodajProjekat.addActionListener(new DodajProjekatAction());
		jPP.add(dodajProjekat);

		// radi izgleda stavljen pane treba zamijeniti drvetom
		JSplitPane lijeviSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tree, pt);
		desniDesktop = new JDesktopPane();
		desniDesktop.setBackground(Color.DARK_GRAY);
		JSplitPane splitGlavni = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lijeviSplit, desniDesktop);
		splitGlavni.setDividerLocation(180);

		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					if (tree.getLastSelectedPathComponent() instanceof Dokument) {
						jpD.show(tree, e.getX(), e.getY());
					} else if (tree.getLastSelectedPathComponent() instanceof Stranica) {
						jpS.show(tree, e.getX(), e.getY());
					} else if (tree.getLastSelectedPathComponent() instanceof Projekat) {
						jpP.show(tree, e.getX(), e.getY());
					} else {
						jPP.show(tree, e.getX(), e.getY());
					}
				}
			}
		});

		// treba testirati, polozaj divajdera namjestiti po dodavanju drveta i
		// korpe za smece da bi izgledalo lijepo
		// lijepo i kad se pokrene i kad se uveca
		lijeviSplit.setDividerLocation(290);

		add(splitGlavni);
		setJMenuBar(meni);
		// treba meni dodati i dva toolbara

	}

	public WorkspaceTree getTree() {
		return tree;
	}

	public PomocniTree getPTree() {
		return pt;
	}

	public JDesktopPane getDesniDesktop() {
		return desniDesktop;
	}

	public static MainFrame getInstance() {
		if (instance == null)
			instance = new MainFrame();
		return instance;
	}

	public MenuBar getMeni() {
		return meni;
	}

	public Dokument getDokumentZaDeljenje() {
		return dokumentZaDeljenje;
	}

	public void setDokumentZaDeljenje(Dokument dokumentZaDeljenje) {
		this.dokumentZaDeljenje = dokumentZaDeljenje;
	}

	public DokumentView getViewZaDeljenje() {
		return viewZaDeljenje;
	}

	public void setViewZaDeljenje(DokumentView viewZaDeljenje) {
		this.viewZaDeljenje = viewZaDeljenje;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub

	}

	public WorkspaceModel getWm() {
		return wm;
	}

	public void setWm(WorkspaceModel wm) {
		this.wm = wm;
	}

	public PomocniModel getPm() {
		return pm;
	}

	public void setPm(PomocniModel pm) {
		this.pm = pm;
	}

	public PomocniTree getPt() {
		return pt;
	}

	public void setPt(PomocniTree pt) {
		this.pt = pt;
	}

	public static void setInstance(MainFrame instance) {
		MainFrame.instance = instance;
	}

	public void setTree(WorkspaceTree tree) {
		this.tree = tree;
	}

	public void setDesniDesktop(JDesktopPane desniDesktop) {
		this.desniDesktop = desniDesktop;
	}

	public void setMeni(MenuBar meni) {
		this.meni = meni;
	}

	public Clipboard getClipboard() {
		return clipboard;
	}

	public void setClipboard(Clipboard clipboard) {
		this.clipboard = clipboard;
	}

	public BiranjeWorkspacea getW() {
		return w;
	}

	public void setW(BiranjeWorkspacea w) {
		this.w = w;
	}

}
