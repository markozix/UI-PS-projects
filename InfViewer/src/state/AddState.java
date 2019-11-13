package state;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import main.MainFrame;
import main.ToolBarIznadTabele;
import model.tree.TreeCellRenderer;
import modeli.Atribut;
import modeli.Entitet;
import modeli.Tabela;

public class AddState extends State {

	@Override
	public void pressButton(ActionEvent e) {
		if (MainFrame.getInstance().getTrenutniEntitet().getEntPaket().toString().equals("Serijski")) {
			StringBuilder sb = new StringBuilder();
			sb.append("\r\n");
			for (int i = 0; i < MainFrame.getInstance().getTrenutniEntitet().getChildCount(); i++) {
				String str = MainFrame.getInstance().getLista().get(i).getText();
				Atribut atr = (Atribut) MainFrame.getInstance().getTrenutniEntitet().getChildAt(i);
				int len = atr.getDuzina();
				sb.append(str);
				if (str.length() == len) {

				} else {
					for (int j = 0; j < len - str.length(); j++) {
						sb.append(" ");
					}
				}
			}
			sb.append("0");
			try {
				RandomAccessFile afile = new RandomAccessFile(MainFrame.getInstance().getTrenutniEntitet().getPath(),
						"rw");
				afile.seek(afile.length());
				afile.writeBytes(sb.toString());
				afile.setLength(afile.length());
				afile.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv().equals("Sekvencijalni")
				|| MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv()
						.equals("Indeks-sekvencijalni")) {
			String fileName = MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + "-"
					+ MainFrame.getInstance().getTrenutniEntitet().getName() + ".dtp";
			File datotekaPromena = new File(fileName);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < MainFrame.getInstance().getTrenutniEntitet().getChildCount(); i++) {
				String str = MainFrame.getInstance().getLista().get(i).getText();
				Atribut atr = (Atribut) MainFrame.getInstance().getTrenutniEntitet().getChildAt(i);
				int len = atr.getDuzina();
				sb.append(str);
				if (str.length() == len) {

				} else {
					for (int j = 0; j < len - str.length(); j++) {
						sb.append(" ");
					}
				}
			}
			sb.append("A");
			try {
				FileWriter fw = new FileWriter(fileName, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				pw.println(sb.toString());
				pw.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
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
			JPanel panel = new JPanel();
			BorderLayout bl = new BorderLayout();
			panel.setLayout(bl);
			JTable tabela = null;
			String fsql = "INSERT INTO " + MainFrame.getInstance().getTrenutniEntitet().getName() + " (";
			String pomocni = "";
			String[] niz = new String[MainFrame.getInstance().getTrenutniEntitet().getChildCount()];
			String[] heder = new String[MainFrame.getInstance().getTrenutniEntitet().getChildCount()];
			String[] provera = new String[MainFrame.getInstance().getTrenutniEntitet().getChildCount()];
			int pozicija = -1;
			for (int i = 0; i < MainFrame.getInstance().getTrenutniEntitet().getChildCount(); i++) {
				Atribut atr = (Atribut) MainFrame.getInstance().getTrenutniEntitet().getChildAt(i);
				heder[i] = atr.getName();
				provera[i] = MainFrame.getInstance().getLista().get(i).getText().trim();
				if (i < MainFrame.getInstance().getTrenutniEntitet().getChildCount() - 1) {
					fsql += atr.getName() + ", ";
					pomocni += "'" + MainFrame.getInstance().getLista().get(i).getText().trim() + "', ";
				} else {
					fsql += atr.getName() + ") VALUES (";
					pomocni += "'" + MainFrame.getInstance().getLista().get(i).getText().trim() + "');";
				}
			}
			fsql += pomocni;
			try {
				PreparedStatement ps = MainFrame.getInstance().getConnection().prepareStatement(fsql);
				int rs = ps.executeUpdate();
				// osvezi view
				ArrayList<String[]> lista = new ArrayList<>();
				Statement stmt = MainFrame.getInstance().getConnection().createStatement();
				ResultSet rs2 = stmt.executeQuery("SELECT * FROM " + trenutni.getName());
				while (rs2.next()) {
					String[] niz2 = new String[trenutni.getChildCount()];
					for (int i = 0; i < trenutni.getChildCount(); i++) {
						niz2[i] = rs2.getString(i + 1);
					}
					lista.add(niz2);
				}
				Object[][] podaci = new Object[lista.size()][trenutni.getChildCount()];
				boolean check = true;

				for (int i = 0; i < lista.size(); i++) {
					for (int j = 0; j < trenutni.getChildCount(); j++) {
						podaci[i][j] = lista.get(i)[j];
						if (podaci[i][j] == null && provera[j] != null)
							check = false;
						else if (!podaci[i][j].toString().equals(provera[j]))
							check = false;
					}
					if (check == true)
						pozicija = i;
					check = true;
				}
				tabela = new JTable(podaci, heder);

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			MainFrame.getInstance().setTrenutnaTabela(tabela);
			MainFrame.getInstance().getTrenutnaTabela().setRowSelectionInterval(pozicija, pozicija);
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
			MainFrame.getInstance().getTrenutniEntitet().getStateManager().setAddState();
			return;
		}
	}

	@Override
	public String toString() {
		return "Add";
	}
}
