package controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import main.MainFrame;
import main.ToolBarIznadTabele;
import modeli.Entitet;
import modeli.Tabela;

public class FetchBlock implements ActionListener {

	private int bs = 20;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int zaBrisanje = -1;
		bs = MainFrame.getInstance().getTrenutniEntitet().getBlockSize();
		int brAtributa = MainFrame.getInstance().getTrenutniEntitet().getChildCount();
		Entitet zaCuvanje = MainFrame.getInstance().getTrenutniEntitet();
		try {
			for (int i = 0; i < MainFrame.getInstance().getGornjiTabovi().getTabCount(); i++) {
				if (MainFrame.getInstance().getGornjiTabovi().getTitleAt(i)
						.equals(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
								+ MainFrame.getInstance().getTrenutniEntitet().getName())) {
					zaBrisanje = i;
					break;
				}
			}

			RandomAccessFile afile = new RandomAccessFile(MainFrame.getInstance().getTrenutniEntitet().getPath(), "r");
			Object[][] podaci = new Object[bs][brAtributa];
			Object[] heder = new Object[brAtributa];
			int duzinaReda = afile.readLine().length();

			int cnt = 0;
			boolean prviProlaz = true;
			boolean upisano = false;
			while (cnt < bs) {
				if (!prviProlaz)
					MainFrame.getInstance().getTrenutniEntitet()
							.setSeek(MainFrame.getInstance().getTrenutniEntitet().getSeek() + 2 + duzinaReda);
				if (MainFrame.getInstance().getTrenutniEntitet().getSeek() > afile.length())
					MainFrame.getInstance().getTrenutniEntitet().setSeek(0);
				afile.seek(MainFrame.getInstance().getTrenutniEntitet().getSeek());
				String red = afile.readLine();
				int pocetak = 0;
				for (int j = 0; j < brAtributa; j++) {
					int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
					if (MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv().equals("Serijski")) {
						if (red.charAt(red.length() - 1) == '0') {
							upisano = true;
							if (kraj < red.length())
								podaci[cnt][j] = red.substring(pocetak, kraj);
							else
								podaci[cnt][j] = red.substring(pocetak, red.length());
						} else {
							upisano = false;
						}
					} else {
						if(red == null) {
							continue;
						}
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
				prviProlaz = false;
			}
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

			Component c = MainFrame.getInstance().getGornjiTabovi().getSelectedComponent();
			JPanel jp = (JPanel) c;
			if (jp.getComponent(0) instanceof ToolBarIznadTabele) {
				ToolBarIznadTabele tb = (ToolBarIznadTabele) jp.getComponent(0);
				MainFrame.getInstance().getTrenutniEntitet()
						.setOpened(MainFrame.getInstance().getTrenutniEntitet().getOpened() + 1);
				tb.getBrojac().setText("" + MainFrame.getInstance().getTrenutniEntitet().getOpened());
				tb.repaint();
				tb.revalidate();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
