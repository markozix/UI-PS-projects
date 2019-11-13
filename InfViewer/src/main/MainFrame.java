package main;

import java.awt.Toolkit;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

import controller.OsveziTrenutniEntitet;
import controller.OtvoriEntitet;
import modeli.Atribut;
import modeli.Entitet;
import modeli.Tabela;
import workspace.WorkspaceModel;
import workspace.WorkspaceTree;

public class MainFrame extends JFrame {
	private static MainFrame instance = null;
	private WorkspaceModel wm;
	private WorkspaceTree tree;
	private JPanel gornji;
	private JTabbedPane gornjiTabovi;
	private JPanel donji;
	private JTabbedPane donjiTabovi;
	private ArrayList<JTextField> lista;
	private ArrayList<String> listaTFsadrzaj;
	private ArrayList<String> listaLBnaziv;
	// dodati entitet trenutni
	private Entitet trenutniEntitet;
	private JTable trenutnaTabela;
	private OsveziTrenutniEntitet or;
	private ArrayList<JComboBox<String>> operatori;

	private Connection connection = null;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public WorkspaceTree getTree() {
		return tree;
	}

	public void setTree(WorkspaceTree tree) {
		this.tree = tree;
	}

	private MainFrame() {
		init();
	}

	private void init() {
		MenuBar meni = new MenuBar(this);

		Toolkit kit = Toolkit.getDefaultToolkit();

		gornji = new JPanel();
		gornjiTabovi = new JTabbedPane();
		or = new OsveziTrenutniEntitet();
		gornjiTabovi.addChangeListener(or);
		gornji.add(gornjiTabovi);
		donji = new JPanel();
		donjiTabovi = new JTabbedPane();
		donji.add(donjiTabovi);

		JSplitPane desniSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, gornji, donji);
		// desniSplit.setEnabled(false);

		JPanel desniCentar = new JPanel();

		desniCentar.setBackground(Color.WHITE);

		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(3 * screenWidth / 4, 3 * screenHeight / 4);
		desniSplit.setDividerLocation(screenHeight - screenHeight * 1 / 3);
		desniSplit.setEnabled(false);
		setTitle("InfViewer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Pozicija slajdera za desniSplit-pane
		// desniSplit.setDividerLocation(getSize().width - 367);
		// desniSplit.setEnabled(false);

		// desniSplit.setBackground(Color.white);
		getContentPane().setBackground(Color.WHITE);

		tree = new WorkspaceTree();
		wm = new WorkspaceModel();
		tree.setModel(wm);
		tree.setRootVisible(false);
		tree.setShowsRootHandles(true);

		tree.addMouseListener(new OtvoriEntitet());

		JSplitPane glavni = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tree, desniSplit);
		glavni.setEnabled(false);
		glavni.setDividerLocation(180);

		MyToolBar toolbar = new MyToolBar();
		toolbar.setVisible(true);
		add(toolbar, BorderLayout.NORTH);

		this.setJMenuBar(meni);
		add(glavni);

	}

	public static MainFrame getInstance() {
		if (instance == null)
			instance = new MainFrame(); // singlton
		return instance;
	}

	public OsveziTrenutniEntitet getOr() {
		return or;
	}

	public void setOr(OsveziTrenutniEntitet or) {
		this.or = or;
	}

	public JPanel getGornji() {
		return gornji;
	}

	public void setGornji(JPanel gornji) {
		this.gornji = gornji;
	}

	public JPanel getDonji() {
		return donji;
	}

	public void setDonji(JPanel donji) {
		this.donji = donji;
	}

	public JTabbedPane getGornjiTabovi() {
		return gornjiTabovi;
	}

	public void setGornjiTabovi(JTabbedPane gornjiTabovi) {
		this.gornjiTabovi = gornjiTabovi;
	}

	public JTabbedPane getDonjiTabovi() {
		return donjiTabovi;
	}

	public void setDonjiTabovi(JTabbedPane donjiTabovi) {
		this.donjiTabovi = donjiTabovi;
	}

	public WorkspaceModel getWm() {
		return wm;
	}

	public void setWm(WorkspaceModel wm) {
		this.wm = wm;
	}

	public Entitet getTrenutniEntitet() {
		return trenutniEntitet;
	}

	public void setTrenutniEntitet(Entitet trenutniEntitet) {
		this.trenutniEntitet = trenutniEntitet;
	}

	public static void setInstance(MainFrame instance) {
		MainFrame.instance = instance;
	}

	public JTable getTrenutnaTabela() {
		return trenutnaTabela;
	}

	public void setTrenutnaTabela(JTable trenutnaTabela) {
		this.trenutnaTabela = trenutnaTabela;
	}

	public ArrayList<JTextField> getLista() {
		return lista;
	}

	public void setLista(ArrayList<JTextField> lista) {
		this.lista = lista;
	}

	public ArrayList<JComboBox<String>> getOperatori() {
		return operatori;
	}

	public void setOperatori(ArrayList<JComboBox<String>> operatori) {
		this.operatori = operatori;
	}

	public ArrayList<String> getListaTFsadrzaj() {
		return listaTFsadrzaj;
	}

	public void setListaTFsadrzaj(ArrayList<String> listaTFsadrzaj) {
		this.listaTFsadrzaj = listaTFsadrzaj;
	}

	public ArrayList<String> getListaLBnaziv() {
		return listaLBnaziv;
	}

	public void setListaLBnaziv(ArrayList<String> listaLBnaziv) {
		this.listaLBnaziv = listaLBnaziv;
	}



}