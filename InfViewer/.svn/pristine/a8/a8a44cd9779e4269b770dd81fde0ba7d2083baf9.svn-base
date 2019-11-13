package state;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.MainFrame;
import main.ToolBarIznadTabele;
import modeli.Atribut;
import modeli.Entitet;

public class UpdateState extends State {

	@Override
	public void selectedField() {

	}

	@Override
	public void pressButton(ActionEvent e) {
		if (MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv().equals("paket")) {
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
			int row = MainFrame.getInstance().getTrenutnaTabela().getSelectedRow();
			int brAtributa = MainFrame.getInstance().getTrenutniEntitet().getChildCount();
			String[] vrednosti = new String[brAtributa];
			String[] heder = new String[brAtributa];
			String[] uneto = new String[brAtributa];
			String[] provera = new String[brAtributa];
			int pozicija = -1;
			for (int i = 0; i < brAtributa; i++) {
				vrednosti[i] = (String) MainFrame.getInstance().getTrenutnaTabela().getValueAt(row, i);
			}
			String fsql = "UPDATE " + trenutni.getName() + " SET ";
			String pomocni = " WHERE ";
			for (int i = 0; i < brAtributa; i++) {
				Atribut att = (Atribut) trenutni.getChildAt(i);
				heder[i] = att.getName();
				uneto[i] = MainFrame.getInstance().getLista().get(i).getText().trim();
				if (uneto[i].length() > 0) {
					provera[i]=uneto[i];
					fsql += heder[i] + " = ";
					if (att.getType().equals("char")) {
						fsql += "'" + uneto[i] + "', ";
					} else if (att.getType().equals("numeric")) {
						fsql += uneto[i] + ", ";
					}
				} else {
					provera[i]=vrednosti[i];
					pomocni+= heder[i]+" = ";
					if (att.getType().equals("char")) {
						pomocni += "'" + vrednosti[i] + "' AND ";
					} else if (att.getType().equals("numeric")) {
						pomocni += vrednosti[i] + " AND ";
					}
				}
			}
			fsql = fsql.substring(0, fsql.length() - 2);
			pomocni = pomocni.substring(0, pomocni.length() - 5);
			fsql += pomocni;
			PreparedStatement ps;
			try {
				ps = MainFrame.getInstance().getConnection().prepareStatement(fsql);
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
				// TODO Auto-generated catch block
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
			MainFrame.getInstance().getTrenutniEntitet().getStateManager().setUpdateState();
			return;
			
		} else {
			int row = MainFrame.getInstance().getTrenutnaTabela().getSelectedRow();
			int brAtributa = MainFrame.getInstance().getTrenutniEntitet().getChildCount();
			String[] vrednosti = new String[brAtributa];
			for (int i = 0; i < brAtributa; i++) {
				vrednosti[i] = (String) MainFrame.getInstance().getTrenutnaTabela().getValueAt(row, i);
			}
			String fileName = MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + "-"
					+ MainFrame.getInstance().getTrenutniEntitet().getName() + ".dtp";
			File datotekaPromena = new File(fileName);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < brAtributa; i++) {
				Atribut atr = (Atribut) MainFrame.getInstance().getTrenutniEntitet().getChildAt(i);
				sb.append(vrednosti[i]);
			}
			sb.append("U");
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
		}
	}
}
