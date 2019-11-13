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
import java.io.RandomAccessFile;
import java.sql.PreparedStatement;
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

public class DeleteState extends State {

	@Override
	public void pressButton(ActionEvent e) {
		if(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().toString().equals("Serijski")) {
			int row = MainFrame.getInstance().getTrenutnaTabela().getSelectedRow();
			int brAtributa = MainFrame.getInstance().getTrenutniEntitet().getChildCount();
			String[] vrednosti = new String[brAtributa];
			for(int i = 0; i <  brAtributa; i++) {
				vrednosti[i] = (String)MainFrame.getInstance().getTrenutnaTabela().getValueAt(row, i);
			}
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
				RandomAccessFile afile = new RandomAccessFile(MainFrame.getInstance().getTrenutniEntitet().getPath(), "rw");
				afile.seek(0);
				int duzinaReda = afile.readLine().length();
				afile.seek(0);
				int brReda = 0;
				int cnt = 0;
				long tmp = 0;
				boolean upisano = false;
				int skipped = 0;
				long brPredjenih = 0;
				String data[] = new String[atributi];
				MainFrame.getInstance().getTrenutniEntitet().setSeek(0);
				while(afile.getFilePointer() != afile.length() && !nadjen) {
					brPredjenih++;
					String red = afile.readLine();
					if(red.charAt(red.length() - 1) == '0') {
						int pocetak = 0;
						for(int i = 0; i < atributi; i++) {
							int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(i).getDuzina();
							if(kraj < red.length()) 
								data[i] = red.substring(pocetak, kraj);
							else 
								data[i] = red.substring(pocetak, red.length());
							pocetak = kraj;
						}
					 	nadjen = true;
						for(int j = 0; j < atributi; j++) {
							String txt = vrednosti[j].trim();
							if(!txt.equals("")) {
								String str = (String)data[j];
								if(!txt.equals(str.trim())) {
									nadjen = false;
			//						brReda = i;
									break;
								}
							}
						}
						if(nadjen) {
							tmp = afile.getFilePointer();
							afile.seek(afile.getFilePointer() - 4);
							afile.writeChar(49);
							break;
						}
					} else {
						skipped++;
					}
	//				while(cnt < block) {
	//					if (MainFrame.getInstance().getTrenutniEntitet().getSeek() > afile.length())
	//						afile.seek(0);
	//					String red = afile.readLine();
	//					int pocetak = 0;
	//					for (int j = 0; j < atributi; j++) {
	//						int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
	//						if (red.charAt(red.length() - 1) == '0') {
	//							upisano = true;
	//							if (kraj < red.length())
	//								podaci[cnt][j] = red.substring(pocetak, kraj);
	//							else
	//								podaci[cnt][j] = red.substring(pocetak, red.length());
	//						} else {
	//							skipped++;
	//						}
	//						heder[j] = MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getName();
	//						pocetak = kraj;
	//					}
	//					if(upisano)
	//						cnt++;
	//					upisano = false;
	//				}
	//				cnt = 0;
	//				for(int i = 0; i < block; i++) {
	//					if(nadjen) {
	//						tmp = afile.getFilePointer();
	//						afile.seek(tmp - (block + skipped - brReda) * (duzinaReda + 2));
	//						break;
	//					}
	//					nadjen = true;
	//					brReda = i;
	//					for(int j = 0; j < atributi; j++) {
	//						String txt = vrednosti[j];
	//						if(!txt.equals("")) {
	//							String str = (String)podaci[i][j];
	//							if(!txt.equals(str.trim())) {
	//								nadjen = false;
	////								brReda = i;
	//								break;
	//							}
	//						}
	//					}
	//				}
	//				skipped = 0;
				}
				afile.seek(0);
				long blok = brPredjenih / block + 1;
				while(blok > 0) {
					cnt = 0;
					upisano = false;
					while (cnt < block) {
						if (MainFrame.getInstance().getTrenutniEntitet().getSeek() > afile.length())
							MainFrame.getInstance().getTrenutniEntitet().setSeek(0);
	//					afile.seek(MainFrame.getInstance().getTrenutniEntitet().getSeek());
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
					}
					blok--;
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
				MainFrame.getInstance().getGornjiTabovi().addTab(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
						+ MainFrame.getInstance().getTrenutniEntitet().getName(),
						panel);
				MainFrame.getInstance().getGornjiTabovi()
						.setSelectedIndex(MainFrame.getInstance().getGornjiTabovi().getTabCount() - 1);
				MainFrame.getInstance().getTrenutniEntitet().getStateManager().setDeleteState();
	//			MainFrame.getInstance().getTrenutnaTabela().setRowSelectionInterval(brReda, brReda);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().toString().equals("Sekvencijalni")) {
			int row = MainFrame.getInstance().getTrenutnaTabela().getSelectedRow();
			int brAtributa = MainFrame.getInstance().getTrenutniEntitet().getChildCount();
			String[] vrednosti = new String[brAtributa];
			for(int i = 0; i <  brAtributa; i++) {
				vrednosti[i] = (String)MainFrame.getInstance().getTrenutnaTabela().getValueAt(row, i);
			}
			String fileName = MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + "-"
					+ MainFrame.getInstance().getTrenutniEntitet().getName() + ".dtp";
			File datotekaPromena = new File(fileName);
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < brAtributa; i++) {
				sb.append(vrednosti[i]);
			}
			sb.append("D");
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
			
			int row = MainFrame.getInstance().getTrenutnaTabela().getSelectedRow();
			int brAtributa = MainFrame.getInstance().getTrenutniEntitet().getChildCount();
			String[] vrednosti = new String[brAtributa];
			for(int i = 0; i <  brAtributa; i++) {
				vrednosti[i] = (String)MainFrame.getInstance().getTrenutnaTabela().getValueAt(row, i);
			}
			Entitet trenutni = MainFrame.getInstance().getTrenutniEntitet();
			String deleteSQL=" DELETE FROM "+ trenutni.getName() +" WHERE ";
			boolean prvi = true;
			for(int i = 0; i < brAtributa; i++) {
				Atribut atribut = (Atribut)trenutni.getChildAt(i);
				if(prvi) {
					prvi = false;
					deleteSQL += atribut.getName() +  " = ? ";
				} else {
					deleteSQL += " AND " + atribut.getName() +  " = ? ";
				}
			}
			System.out.println(deleteSQL);
			try {
				PreparedStatement ps = MainFrame.getInstance().getConnection().prepareStatement(deleteSQL);
				for(int i = 0; i < brAtributa; i++) {
					ps.setObject(i + 1, vrednosti[i]);
				}
				ps.execute();
				
				Object[] heder = new Object[brAtributa];
				for (int k = 0; k < brAtributa; k++) {

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
				
				PreparedStatement ps1 = MainFrame.getInstance().getConnection().prepareStatement("SELECT * FROM " + trenutni.getName());
				
				ResultSet rs = ps1.executeQuery();
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
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	

}
