package controller.state;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.MainFrame;
import main.ToolBarIznadTabele;
import modeli.Atribut;
import modeli.Entitet;

public class SearchAND implements ActionListener {

	private JDialog dialog;
	
	public SearchAND(JDialog dialog) {
		this.dialog = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
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
				dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
				return;
			} catch (SQLException e) {
				e.printStackTrace();
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
			dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
