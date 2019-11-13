package controller.state;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.MainFrame;
import main.ToolBarIznadTabele;
import modeli.Atribut;
import modeli.Entitet;
import modeli.Tabela;

public class SortActionOpadajuce implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
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
		int atr = trenutni.getChildCount();
		
		int brKolone = MainFrame.getInstance().getTrenutnaTabela().getSelectedColumn();
		
		int[] nizKolona = MainFrame.getInstance().getTrenutnaTabela().getSelectedColumns();
		
		if(nizKolona.length<2) {
		String imeKolone = MainFrame.getInstance().getTrenutnaTabela().getColumnName(brKolone);
		
		String imeTabele = MainFrame.getInstance().getTrenutniEntitet().getName();
		//int i=0;
		String sql = " SELECT * FROM "+ imeTabele + " ORDER BY " + imeKolone + " DESC ";
		
		try {
			java.sql.Statement st = MainFrame.getInstance().getConnection().createStatement();
		
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
			
			ResultSet rs = st.executeQuery(sql);
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
			return;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else {
		
		//zavisno od toga sta se zeli, da li prva kolona da ima najjaci uticaj na sort
		//for(int l=nizKolona.length-1;l>=0;l--) {
		// ili posljednja kolona-------trenutno je ovo dioltno
		for(int l=0;l<nizKolona.length;l++) {
			
		
			String imeKolone = MainFrame.getInstance().getTrenutnaTabela().getColumnName(nizKolona[l]);
			System.out.println(imeKolone);
			System.out.println(nizKolona.length);
			String imeTabele = MainFrame.getInstance().getTrenutniEntitet().getName();
			
			String sql = " SELECT * FROM "+ imeTabele + " ORDER BY " + imeKolone + " DESC ";
			int q=0;
			
			try {
				java.sql.Statement st = MainFrame.getInstance().getConnection().createStatement();
			
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
				
				ResultSet rs = st.executeQuery(sql);
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
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
}
	

}
