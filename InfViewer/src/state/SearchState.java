package state;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import controller.state.ChooseANDOR;
import controller.state.ChooseVrstaPretrage;
import controller.state.ChooseVrstaPretrage2;
import main.Main;
import main.MainFrame;
import main.ToolBarIznadTabele;
import model.tree.KeyElement;
import model.tree.Node;
import model.tree.NodeElement;
import model.tree.TreeCellRenderer;
import modeli.Atribut;
import modeli.Entitet;
import modeli.Tabela;

public class SearchState extends State {

	@Override
	public void selectedField() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pressButton(ActionEvent e) {
		if (MainFrame.getInstance().getTrenutniEntitet().getEntPaket().toString().equals("Serijski")) {
			int block = MainFrame.getInstance().getTrenutniEntitet().getBlockSize();
			int atributi = MainFrame.getInstance().getTrenutniEntitet().getChildCount();
			int fileP = 0;
			Object[][] podaci = new Object[block][atributi];
			Object[] heder = new Object[atributi];
			boolean nadjen = false;
			int zaBrisanje = -1;
			for (int i = 0; i < MainFrame.getInstance().getGornjiTabovi().getTabCount(); i++) {
				if (MainFrame.getInstance().getGornjiTabovi().getTitleAt(i)
						.equals(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
								+ MainFrame.getInstance().getTrenutniEntitet().getName())) {
					zaBrisanje = i;
					break;
				}
			}
			try {
				RandomAccessFile afile = new RandomAccessFile(MainFrame.getInstance().getTrenutniEntitet().getPath(),
						"r");
				afile.seek(0);
				int duzinaReda = afile.readLine().length();
				afile.seek(0);
				int brReda = 0;
				int cnt = 0;
				boolean upisano = false;
				MainFrame.getInstance().getTrenutniEntitet().setSeek(0);
				while (afile.getFilePointer() != afile.length() && !nadjen) {
					while (cnt < block) {
						if (MainFrame.getInstance().getTrenutniEntitet().getSeek() > afile.length())
							afile.seek(0);
						String red = afile.readLine();
						int pocetak = 0;
						for (int j = 0; j < atributi; j++) {
							int kraj = pocetak
									+ MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
							if (red.charAt(red.length() - 1) == '0') {
								upisano = true;
								if (kraj < red.length())
									podaci[cnt][j] = red.substring(pocetak, kraj);
								else
									podaci[cnt][j] = red.substring(pocetak, red.length());
							}
							heder[j] = MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getName();
							pocetak = kraj;
						}
						if (upisano)
							cnt++;
						upisano = false;
					}
					cnt = 0;
					for (int i = 0; i < block; i++) {
						if (nadjen) {
							break;
						}
						nadjen = true;
						brReda = i;
						for (int j = 0; j < atributi; j++) {
							String txt = MainFrame.getInstance().getLista().get(j).getText().trim();
							if (!txt.equals("")) {
								String str = (String) podaci[i][j];
								if (!txt.equals(str.trim())) {
									nadjen = false;
									// brReda = i;
									break;
								}
							}
						}
					}
				}
				MainFrame.getInstance().getTrenutniEntitet().setSeek(afile.getFilePointer());
				JPanel panel = new JPanel();
				BorderLayout bl = new BorderLayout();
				panel.setLayout(bl);
				JTable tabela = new JTable(podaci, heder);
				MainFrame.getInstance().setTrenutnaTabela(tabela);
				JScrollPane scroll = new JScrollPane(tabela);
				ToolBarIznadTabele toolbar = new ToolBarIznadTabele();
				Dimension screenSize = MainFrame.getInstance().getGornji().getSize();
				scroll.setPreferredSize(screenSize);
				scroll.setMaximumSize(screenSize);
				scroll.setMinimumSize(screenSize);
				tabela.setFillsViewportHeight(true);
				panel.add(toolbar, BorderLayout.NORTH);
				panel.add(scroll);
				MainFrame.getInstance().getGornjiTabovi().removeChangeListener(MainFrame.getInstance().getOr());
				MainFrame.getInstance().getGornjiTabovi().remove(zaBrisanje);
				MainFrame.getInstance().getGornjiTabovi().addChangeListener(MainFrame.getInstance().getOr());
				MainFrame.getInstance().getGornjiTabovi()
						.addTab(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
								+ MainFrame.getInstance().getTrenutniEntitet().getName(), panel);
				MainFrame.getInstance().getGornjiTabovi()
						.setSelectedIndex(MainFrame.getInstance().getGornjiTabovi().getTabCount() - 1);
				MainFrame.getInstance().getTrenutnaTabela().setRowSelectionInterval(brReda, brReda);
				MainFrame.getInstance().getTrenutniEntitet().getStateManager().setSearchState();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (MainFrame.getInstance().getTrenutniEntitet().getEntPaket().toString().equals("Sekvencijalni")) {
			ChooseVrstaPretrage2 cvp = new ChooseVrstaPretrage2();
		} else if (MainFrame.getInstance().getTrenutniEntitet().getEntPaket().toString().equals("Indeks-sekvencijalni")) {
			int adresa = 0;
			int brojKljuceva = 0;
			Node root = MainFrame.getInstance().getTrenutniEntitet().getTree().getRootElement();
			for (int i = 0; i < MainFrame.getInstance().getTrenutniEntitet().getChildCount(); i++) {
				Atribut atr = (Atribut) MainFrame.getInstance().getTrenutniEntitet().getChildAt(i);
				if (atr.isKey())
					brojKljuceva++;
			}
			ArrayList<Integer> otvori = new ArrayList<>();
			while (root.getChildCount() != 0) {
				NodeElement ne = root.getData().get(0);
				String levi = "";
				for (KeyElement ke : ne.getKeyValue()) {
					levi += ke.getValue().toString();
				}
				levi = levi.trim();
				NodeElement ne2 = root.getData().get(1);
				String desni = "";
				for (KeyElement ke : ne2.getKeyValue()) {
					desni += ke.getValue().toString();
				}
				desni = desni.trim();
				String trazeni = "";
				for (JTextField tf : MainFrame.getInstance().getLista()) {
					trazeni += tf.getText().trim();
				}
				if (trazeni.compareTo(levi) < 0) {
					return;
				} else if (trazeni.compareTo(desni) < 0) {
					root = root.getChildren().get(0);
					otvori.add(0);
				} else {
					root = root.getChildren().get(1);
					otvori.add(1);
				}
			}
			NodeElement ne = root.getData().get(0);
			String levi = "";
			for (KeyElement ke : ne.getKeyValue()) {
				levi += ke.getValue().toString();
			}
			levi = levi.trim();
			NodeElement ne2 = root.getData().get(1);
			String desni = "";
			for (KeyElement ke : ne2.getKeyValue()) {
				desni += ke.getValue().toString();
			}
			desni = desni.trim();
			String trazeni = "";
			for (JTextField tf : MainFrame.getInstance().getLista()) {
				trazeni += tf.getText().trim();
			}
			if (trazeni.compareTo(levi) < 0) {
				return;
			} else if (trazeni.compareTo(desni) < 0) {
				adresa = root.getData().get(0).getBlockAddress();
			} else {
				adresa = root.getData().get(1).getBlockAddress();
			}
			int uRedu = 0;
			try {
				RandomAccessFile afile = new RandomAccessFile(MainFrame.getInstance().getTrenutniEntitet().getPath(),
						"r");
				afile.seek(0);
				int duzinaReda = afile.readLine().length();
				if (adresa != 0)
					afile.seek((adresa - 1) * (duzinaReda + 2));
				else
					afile.seek(0);
				int cnt = 0;
				boolean nije = false;
				Object[][] podaci = new Object[MainFrame.getInstance().getTrenutniEntitet().getBlockSize()][MainFrame
						.getInstance().getTrenutniEntitet().getChildCount()];
				Object[] heder = new Object[MainFrame.getInstance().getTrenutniEntitet().getChildCount()];
				while (cnt < MainFrame.getInstance().getTrenutniEntitet().getBlockSize()) {
					String red = afile.readLine();
					int pocetak = 0;
					String check = "";
					for (int j = 0; j < MainFrame.getInstance().getTrenutniEntitet().getChildCount(); j++) {
						int kraj = pocetak
								+ MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
						if (kraj < red.length())
							check = red.substring(pocetak, kraj);
						else
							check = red.substring(pocetak, red.length());
						podaci[cnt][j] = check;
						if (j < brojKljuceva)
							if (!check.trim().equals(MainFrame.getInstance().getLista().get(j).getText().trim())) {
								nije = true;
							}
						heder[j] = MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getName();
						pocetak = kraj;
					}
					if (nije == false) {
						uRedu = cnt;
					}
					nije = false;
					cnt++;
				}
				int zaBrisanje = -1;
				for (int i = 0; i < MainFrame.getInstance().getGornjiTabovi().getTabCount(); i++) {
					if (MainFrame.getInstance().getGornjiTabovi().getTitleAt(i)
							.equals(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
									+ MainFrame.getInstance().getTrenutniEntitet().getName())) {
						zaBrisanje = i;
						break;
					}
				}
				MainFrame.getInstance().getTrenutniEntitet()
						.openTree("./Veliki Set Podataka/Indeks - sekvencijalne datoteke/"
								+ MainFrame.getInstance().getTrenutniEntitet().getName() + ".tree");
				DefaultTreeModel treeModel = new DefaultTreeModel(
						MainFrame.getInstance().getTrenutniEntitet().getTree().getRootElement());
				JTree indexTree = new JTree(treeModel);
				TreeCellRenderer renderer = new TreeCellRenderer();
				indexTree.setCellRenderer(renderer);
				TreeNode tn = (TreeNode) indexTree.getModel().getRoot();
				TreeNode[] nizic = new TreeNode[otvori.size() +1];
				nizic[0] = tn;
				for (int i = 1; i < nizic.length; i++) {
					if (tn.getChildCount() > 0) {
						if (otvori.get(i - 1) == 0)
							tn = tn.getChildAt(0);
						else
							tn = tn.getChildAt(1);
						nizic[i] = tn;
					}
				}
				TreePath tp = new TreePath(nizic);
				indexTree.expandPath(tp);
				JPanel panel = new JPanel();
				BorderLayout bl = new BorderLayout();
				panel.setLayout(bl);
				JTable tabela = new JTable(podaci, heder);
				MainFrame.getInstance().setTrenutnaTabela(tabela);
				MainFrame.getInstance().getTrenutnaTabela().setRowSelectionInterval(uRedu, uRedu);
				JScrollPane scroll = new JScrollPane(tabela);
				Dimension screenSize = MainFrame.getInstance().getGornji().getSize();
				JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, indexTree, scroll);
				ToolBarIznadTabele toolbar = new ToolBarIznadTabele();
				panel.add(toolbar, BorderLayout.NORTH);
				panel.add(split);
				MainFrame.getInstance().getGornjiTabovi().removeChangeListener(MainFrame.getInstance().getOr());
				MainFrame.getInstance().getGornjiTabovi().remove(zaBrisanje);
				MainFrame.getInstance().getGornjiTabovi().addChangeListener(MainFrame.getInstance().getOr());
				MainFrame.getInstance().getGornjiTabovi()
						.addTab(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
								+ MainFrame.getInstance().getTrenutniEntitet().getName(), panel);
				MainFrame.getInstance().getGornjiTabovi()
						.setSelectedIndex(MainFrame.getInstance().getGornjiTabovi().getTabCount() - 1);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			// kod za bazu
//			ChooseANDOR chs = new ChooseANDOR();

			int zaBrisanje = -1;
			for (int i = 0; i < MainFrame.getInstance().getGornjiTabovi().getTabCount(); i++) {
				if (MainFrame.getInstance().getGornjiTabovi().getTitleAt(i)
						.equals(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
								+ MainFrame.getInstance().getTrenutniEntitet().getName())) {
					zaBrisanje = i;
					break;
				}
			}
			
			
			Entitet trenutni = MainFrame.getInstance().getTrenutniEntitet();
			String findSQL = " SELECT * FROM "+trenutni+" WHERE ";
			int atr = trenutni.getChildCount();
			
			boolean nadjen = false;
			for(int i = 0; i < atr; i++) {
				String txt = MainFrame.getInstance().getLista().get(i).getText().trim();
				if(!txt.equals("")) {
					nadjen = true;
				}
			}
			
			if(!nadjen) {
				String fSQL = " SELECT * FROM " + trenutni;
				try {
					PreparedStatement ps = MainFrame.getInstance().getConnection().prepareStatement(fSQL);
					int cnt = 0;
					for(int i = 0; i < atr; i++) {
						String txt = MainFrame.getInstance().getLista().get(i).getText().trim();
						if(!txt.equals("")) {
							Atribut atribut = (Atribut)trenutni.getChildAt(i);
							if(atribut.getType().equals("char") || atribut.getType().equals("varchar")) {
								ps.setObject(cnt + 1, txt);
							} else {
								ps.setObject(cnt + 1, Integer.parseInt(txt.substring(1)));
							}
							cnt++;
						}
					}
					Object[] heder = new Object[atr];
					for (int k = 0; k < atr; k++) {

						Object o2 = trenutni.getChildAt(k);
						String s = ((Atribut) o2).getName();
						Object p = s;
						heder[k] = p;

					}
					JPanel panel = new JPanel();
					BorderLayout bl = new BorderLayout();
					panel.setLayout(bl);
					JTable tabela = null;
					ArrayList<String[]> lista = new ArrayList<>();
					
					ResultSet rs = ps.executeQuery();
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
					MainFrame.getInstance().getGornjiTabovi().removeChangeListener(MainFrame.getInstance().getOr());
					MainFrame.getInstance().getGornjiTabovi().remove(zaBrisanje);
					MainFrame.getInstance().getGornjiTabovi().addChangeListener(MainFrame.getInstance().getOr());
					MainFrame.getInstance().getGornjiTabovi()
							.addTab(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
									+ MainFrame.getInstance().getTrenutniEntitet().getName(), panel);
					MainFrame.getInstance().getGornjiTabovi()
							.setSelectedIndex(MainFrame.getInstance().getGornjiTabovi().getTabCount() - 1);
					MainFrame.getInstance().getTrenutniEntitet().getStateManager().setSearchState();
					return;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			boolean prvi = true;
			int lastTaken = 0;
			for(int i = 0; i < atr; i++) {
				String txt = MainFrame.getInstance().getLista().get(i).getText().trim();
				if(!txt.equals("")) {
					Atribut atribut = (Atribut)trenutni.getChildAt(i);
					if(prvi) {
						prvi = false;
						lastTaken = i;
						if(atribut.getType().equals("char") || atribut.getType().equals("varchar")) {
							findSQL += atribut.getName() + " LIKE  ? ";
						} else {
							findSQL += atribut.getName() + " " + txt.substring(0, 1) + " ? ";
						}
	 				} else {
						if(atribut.getType().equals("char") || atribut.getType().equals("varchar")) {
							findSQL += " " + MainFrame.getInstance().getOperatori().get(lastTaken).getSelectedItem() + " "
									+ atribut.getName() + " LIKE  ? ";
						} else {
							findSQL += " " + MainFrame.getInstance().getOperatori().get(lastTaken).getSelectedItem() + " " 
									+ atribut.getName() + " " + txt.substring(0, 1) + " ? ";
						}
						lastTaken = i;
					}
				}
			}
			System.out.println(findSQL);
			try {
				PreparedStatement ps = MainFrame.getInstance().getConnection().prepareStatement(findSQL);
				int cnt = 0;
				for(int i = 0; i < atr; i++) {
					String txt = MainFrame.getInstance().getLista().get(i).getText().trim();
					if(!txt.equals("")) {
						Atribut atribut = (Atribut)trenutni.getChildAt(i);
						if(atribut.getType().equals("char") || atribut.getType().equals("varchar")) {
							ps.setObject(cnt + 1, txt);
						} else {
							ps.setObject(cnt + 1, Integer.parseInt(txt.substring(1)));
						}
						cnt++;
					}
				}
				Object[] heder = new Object[atr];
				for (int k = 0; k < atr; k++) {

					Object o2 = trenutni.getChildAt(k);
					String s = ((Atribut) o2).getName();
					Object p = s;
					heder[k] = p;

				}
				JPanel panel = new JPanel();
				BorderLayout bl = new BorderLayout();
				panel.setLayout(bl);
				JTable tabela = null;
				ArrayList<String[]> lista = new ArrayList<>();
				
				ResultSet rs = ps.executeQuery();
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
				MainFrame.getInstance().getGornjiTabovi().removeChangeListener(MainFrame.getInstance().getOr());
				MainFrame.getInstance().getGornjiTabovi().remove(zaBrisanje);
				MainFrame.getInstance().getGornjiTabovi().addChangeListener(MainFrame.getInstance().getOr());
				MainFrame.getInstance().getGornjiTabovi()
						.addTab(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
								+ MainFrame.getInstance().getTrenutniEntitet().getName(), panel);
				MainFrame.getInstance().getGornjiTabovi()
						.setSelectedIndex(MainFrame.getInstance().getGornjiTabovi().getTabCount() - 1);
				MainFrame.getInstance().getTrenutniEntitet().getStateManager().setSearchState();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "Search";
	}
}
