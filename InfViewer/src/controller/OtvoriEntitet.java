package controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeModel;

import controller.state.FieldSelected;
import main.MainFrame;
import main.ToolBarIznadTabele;
import model.tree.TreeCellRenderer;
import modeli.Atribut;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Paket;
import modeli.Relacija;
import modeli.Tabela;
import state.StateManager;

public class OtvoriEntitet implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (e.getClickCount() == 2) {
				if (MainFrame.getInstance().getTree().getLastSelectedPathComponent() instanceof Entitet) {
					Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
					Entitet trenutni = (Entitet) o;
					Paket pp = (Paket) MainFrame.getInstance().getTree().getSelectionPath().getPathComponent(2);

					trenutni.setEntPaket(pp);
					MainFrame.getInstance().setTrenutniEntitet(trenutni);
					StateManager statemanager = new StateManager();
					statemanager.setDetailState();
					MainFrame.getInstance().getTrenutniEntitet().setStateManager(statemanager);
					String nazivTaba = trenutni.getName();

					// provera da li je odabrani entitet vec otvoren, ako
					// jeste,
					// otvori taj tab

					int brojTabova = MainFrame.getInstance().getGornjiTabovi().getTabCount();
					for (int i = 0; i < brojTabova; i++) {
						if (MainFrame.getInstance().getGornjiTabovi().getTitleAt(i)
								.equals(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
										+ nazivTaba)) {
							MainFrame.getInstance().getGornjiTabovi().setSelectedIndex(i);

							return;
						}
					}

					// broj atributa
					int t = ((Entitet) o).getChildCount();

					// lista objekata za kolone, dajemo joj duzinu t koja
					// odgovara broju atributa
					Object[] heder = new Object[t];

					// petlja da procita atribute i stavi u kolone
					for (int k = 0; k < t; k++) {

						Object o2 = ((Entitet) o).getChildAt(k);
						String s = ((Atribut) o2).getName();
						Object p = s;
						heder[k] = p;

					}
					if (!pp.getNaziv().equals("Indeks-Sekvencijalni")) {
						// ubacen scroll pane zbog pozivanja kolona tabele
						JPanel panel = new JPanel();
						BorderLayout bl = new BorderLayout();
						panel.setLayout(bl);
						JTable tabela = null;
						ArrayList<String[]> lista = new ArrayList<>();
						if (pp.getNaziv().equals("Serijski") || pp.getNaziv().equals("Sekvencijalni")) {
							tabela = new JTable(new Tabela(null, heder));
							// JTable tabela = new JTable(podaci,heder);
						} else {
							try {
								Statement stmt = MainFrame.getInstance().getConnection().createStatement();
								ResultSet rs = stmt.executeQuery("SELECT * FROM " + trenutni.getName());
								while (rs.next()) {
									String[] niz = new String[trenutni.getChildCount()];
									for (int i = 0; i < trenutni.getChildCount(); i++) {
										niz[i] = rs.getString(i+1);
									}
									lista.add(niz);
								}
								Object[][] podaci = new Object[lista.size()][trenutni.getChildCount()];
								for (int i = 0; i < lista.size(); i++)
									for (int j = 0; j < trenutni.getChildCount(); j++) {
										podaci[i][j] = lista.get(i)[j];
									}
								tabela = new JTable(podaci, heder);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						MainFrame.getInstance().setTrenutnaTabela(tabela);
						JScrollPane scroll = new JScrollPane(tabela);
						// dodati toolbar u scroll
						ToolBarIznadTabele toolbar = new ToolBarIznadTabele();

						Dimension screenSize = MainFrame.getInstance().getGornji().getSize();
						scroll.setPreferredSize(screenSize);
						scroll.setMaximumSize(screenSize);
						scroll.setMinimumSize(screenSize);

						// da se doda bijela pozadina tabele da bi se
						// razlikovala od
						// ostatka
						tabela.setFillsViewportHeight(true);
						panel.add(toolbar, BorderLayout.NORTH);
						panel.add(scroll);
						// naziv taba, isti kao entitet da bih mogao da sprecim
						// otvaranje dva puta istog entiteta
						MainFrame.getInstance().getGornjiTabovi().addTab(
								MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":" + nazivTaba,
								panel);
						MainFrame.getInstance().getGornjiTabovi()
								.setSelectedIndex(MainFrame.getInstance().getGornjiTabovi().getTabCount() - 1);
					} else {
						MainFrame.getInstance().getTrenutniEntitet()
								.openTree("./Veliki Set Podataka/Indeks - sekvencijalne datoteke/" + trenutni.getName()
										+ ".tree");
						DefaultTreeModel treeModel = new DefaultTreeModel(
								MainFrame.getInstance().getTrenutniEntitet().getTree().getRootElement());
						JTree indexTree = new JTree(treeModel);
						TreeCellRenderer renderer = new TreeCellRenderer();
						indexTree.setCellRenderer(renderer);
						JPanel panel = new JPanel();
						BorderLayout bl = new BorderLayout();
						panel.setLayout(bl);
						JTable tabela = new JTable(new Tabela(null, heder));
						
						// JTable tabela = new JTable(podaci,heder);
						MainFrame.getInstance().setTrenutnaTabela(tabela);
						JScrollPane scroll = new JScrollPane(tabela);
						Dimension screenSize = MainFrame.getInstance().getGornji().getSize();
						JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, indexTree, scroll);
						ToolBarIznadTabele toolbar = new ToolBarIznadTabele();
						panel.add(toolbar, BorderLayout.NORTH);
						panel.add(split);
						MainFrame.getInstance().getGornjiTabovi().addTab(
								MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":" + nazivTaba,
								panel);
						MainFrame.getInstance().getGornjiTabovi()
								.setSelectedIndex(MainFrame.getInstance().getGornjiTabovi().getTabCount() - 1);
					}
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
