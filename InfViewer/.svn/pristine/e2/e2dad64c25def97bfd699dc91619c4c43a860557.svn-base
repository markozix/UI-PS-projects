package controller.state;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.MainFrame;
import main.ToolBarIznadTabele;
import modeli.Atribut;

public class SearchOdPoslednjeg implements ActionListener {

	private JDialog dialog;
	private boolean prvi;
	
	public SearchOdPoslednjeg(JDialog dialog, boolean prvi) {
		this.dialog = dialog;
		this.prvi = prvi;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(prvi) {
			int block = MainFrame.getInstance().getTrenutniEntitet().getBlockSize();									
			int atributi = MainFrame.getInstance().getTrenutniEntitet().getChildCount();
			int fileP = 0;
			Object[][] podaci = new Object[block][atributi];
			Object[] heder = new Object[atributi];
			boolean nadjen = false;
			boolean prekoracio = false;
			boolean zaokruzi = false;
			boolean poc = false;
			int zaBrisanje = -1;
			int brKljuceva = 0;
			for(int i = 0; i < MainFrame.getInstance().getTrenutniEntitet().getChildCount(); i++) {
				Atribut atr = (Atribut)MainFrame.getInstance().getTrenutniEntitet().getChildAt(i);
				if(atr.isKey())
					brKljuceva++;
			}
			for (int i = 0; i < MainFrame.getInstance().getGornjiTabovi().getTabCount(); i++) {
				if (MainFrame.getInstance().getGornjiTabovi().getTitleAt(i)
						.equals(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
								+ MainFrame.getInstance().getTrenutniEntitet().getName())) {
					zaBrisanje = i;
					break;
				}
			}
			try {
				RandomAccessFile afile = new RandomAccessFile(MainFrame.getInstance().getTrenutniEntitet().getPath(), "r");
				afile.seek(0);
				int duzinaReda = afile.readLine().length();
				afile.seek(MainFrame.getInstance().getTrenutniEntitet().getLastSearch());
				int brReda = 0;
	//			MainFrame.getInstance().getTrenutniEntitet().setSeek(0);
	//			long pomoc = MainFrame.getInstance().getTrenutniEntitet().getLastSearch();
				String red1 = afile.readLine();
				afile.seek(MainFrame.getInstance().getTrenutniEntitet().getLastSearch());
	//			String podaci1[] = new String[atributi];
	//			int pocetak1 = 0;
	//			for (int j = 0; j < atributi; j++) {
	//				int kraj = pocetak1 + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
	//				if (kraj < red1.length())
	//					podaci1[j] = red1.substring(pocetak1, kraj);
	//				else
	//					podaci1[j] = red1.substring(pocetak1, red1.length());
	//				pocetak1 = kraj;
	//			}
	//			for(int i = 0; i < atributi; i++) {
	//				Atribut atr1 = (Atribut)MainFrame.getInstance().getTrenutniEntitet().getChildAt(i);
	//				String txt1 = MainFrame.getInstance().getLista().get(i).getText().trim();
	//				if(atr1.isKey()) {
	//					if(!txt1.equals("")) {
	//						zaokruzi = false;
	//					}
	//				}
	//			}
				if(MainFrame.getInstance().getLista().get(0).getText().trim().equals("")) {
					zaokruzi = true;
					afile.seek(MainFrame.getInstance().getTrenutniEntitet().getLastSearch());
				} else {
					String klj = red1.substring(0, MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(0).getDuzina());
					if(MainFrame.getInstance().getLista().get(0).getText().trim().compareTo(klj) < 0) {
						afile.seek(0);
					} else {
						afile.seek(MainFrame.getInstance().getTrenutniEntitet().getLastSearch());
					}
				}
				while(afile.getFilePointer() < afile.length() && !nadjen && !prekoracio) {
					for(int i = 0; i < block; i++) {
						String red = afile.readLine();
						int pocetak = 0;
						for (int j = 0; j < atributi; j++) {
							int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
							if (kraj < red.length())
								podaci[i][j] = red.substring(pocetak, kraj);
							else
								podaci[i][j] = red.substring(pocetak, red.length());
							heder[j] = MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getName();
							pocetak = kraj;
						}
					}
					for(int i = 0; i < block; i++) {
						if(nadjen || prekoracio) {
							break;
						}
						nadjen = true;
						brReda = i;
						for(int j = 0; j < atributi; j++) {
							String txt = MainFrame.getInstance().getLista().get(j).getText().trim();
							if(!txt.equals("")) {
								String str = (String)podaci[i][j];
								Atribut atri = (Atribut)MainFrame.getInstance().getTrenutniEntitet().getChildAt(j);
								if(atri.isKey()) {
									if(txt.compareTo(str.trim()) < 0) {
										prekoracio = true;
										break;
									}
								}
								if(!txt.equals(str.trim())) {
									nadjen = false;
	//								brReda = i;
									break;
								}
							}
						}
					}
				}
				if(zaokruzi) {
					afile.seek(0);
					while(afile.getFilePointer() < MainFrame.getInstance().getTrenutniEntitet().getLastSearch() && !nadjen && !prekoracio) {
						for(int i = 0; i < block; i++) {
							String red = afile.readLine();
							int pocetak = 0;
							for (int j = 0; j < atributi; j++) {
								int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
								if (kraj < red.length())
									podaci[i][j] = red.substring(pocetak, kraj);
								else
									podaci[i][j] = red.substring(pocetak, red.length());
								heder[j] = MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getName();
								pocetak = kraj;
							}
						}
						for(int i = 0; i < block; i++) {
							if(nadjen || prekoracio) {
								break;
							}
							nadjen = true;
							brReda = i;
							for(int j = 0; j < atributi; j++) {
								String txt = MainFrame.getInstance().getLista().get(j).getText().trim();
								if(!txt.equals("")) {
									String str = (String)podaci[i][j];
									Atribut atri = (Atribut)MainFrame.getInstance().getTrenutniEntitet().getChildAt(j);
									if(atri.isKey()) {
										if(txt.compareTo(str.trim()) < 0) {
											prekoracio = true;
											break;
										}
									}
									if(!txt.equals(str.trim())) {
										nadjen = false;
	//									brReda = i;
										break;
									}
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
				MainFrame.getInstance().getGornjiTabovi().addTab(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
						+ MainFrame.getInstance().getTrenutniEntitet().getName(),
						panel);
				MainFrame.getInstance().getGornjiTabovi()
						.setSelectedIndex(MainFrame.getInstance().getGornjiTabovi().getTabCount() - 1);
				MainFrame.getInstance().getTrenutniEntitet().getStateManager().setSearchState();
				if(!prekoracio) {
					MainFrame.getInstance().getTrenutnaTabela().setRowSelectionInterval(brReda, brReda);
					MainFrame.getInstance().getTrenutniEntitet().setLastSearch(afile.getFilePointer() - (block - brReda) * (duzinaReda + 2));
				} else {
					MainFrame.getInstance().getTrenutniEntitet().setLastSearch(afile.getFilePointer());
				}
				dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else{
			ArrayList<ArrayList<String>> lista = new ArrayList<>();
			ArrayList<String> pomocna = new ArrayList<>();
			int block = MainFrame.getInstance().getTrenutniEntitet().getBlockSize();									
			int atributi = MainFrame.getInstance().getTrenutniEntitet().getChildCount();
			int fileP = 0;
			String[][] podaci = new String[block][atributi];
			Object[] heder = new Object[atributi];
			String[][] matrica = new String[100000][atributi];
			int counter = 0;
			boolean nadjen = false;
			boolean prekoracio = false;
			boolean zaokruzi = false;
			boolean poc = false;
			int zaBrisanje = -1;
			int brKljuceva = 0;
			for(int i = 0; i < MainFrame.getInstance().getTrenutniEntitet().getChildCount(); i++) {
				Atribut atr = (Atribut)MainFrame.getInstance().getTrenutniEntitet().getChildAt(i);
				if(atr.isKey())
					brKljuceva++;
			}
			for (int i = 0; i < MainFrame.getInstance().getGornjiTabovi().getTabCount(); i++) {
				if (MainFrame.getInstance().getGornjiTabovi().getTitleAt(i)
						.equals(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
								+ MainFrame.getInstance().getTrenutniEntitet().getName())) {
					zaBrisanje = i;
					break;
				}
			}
			try {
				RandomAccessFile afile = new RandomAccessFile(MainFrame.getInstance().getTrenutniEntitet().getPath(), "r");
				afile.seek(0);
				int duzinaReda = afile.readLine().length();
				afile.seek(MainFrame.getInstance().getTrenutniEntitet().getLastSearch());
				int brReda = 0;
	//			MainFrame.getInstance().getTrenutniEntitet().setSeek(0);
	//			long pomoc = MainFrame.getInstance().getTrenutniEntitet().getLastSearch();
				String red1 = afile.readLine();
				afile.seek(MainFrame.getInstance().getTrenutniEntitet().getLastSearch());
				long filePTmp = MainFrame.getInstance().getTrenutniEntitet().getSeek();
	//			String podaci1[] = new String[atributi];
	//			int pocetak1 = 0;
	//			for (int j = 0; j < atributi; j++) {
	//				int kraj = pocetak1 + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
	//				if (kraj < red1.length())
	//					podaci1[j] = red1.substring(pocetak1, kraj);
	//				else
	//					podaci1[j] = red1.substring(pocetak1, red1.length());
	//				pocetak1 = kraj;
	//			}
	//			for(int i = 0; i < atributi; i++) {
	//				Atribut atr1 = (Atribut)MainFrame.getInstance().getTrenutniEntitet().getChildAt(i);
	//				String txt1 = MainFrame.getInstance().getLista().get(i).getText().trim();
	//				if(atr1.isKey()) {
	//					if(!txt1.equals("")) {
	//						zaokruzi = false;
	//					}
	//				}
	//			}
				if(MainFrame.getInstance().getLista().get(0).getText().trim().equals("")) {
					zaokruzi = true;
					afile.seek(MainFrame.getInstance().getTrenutniEntitet().getLastSearch());
				} else {
					String klj = red1.substring(0, MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(0).getDuzina());
					if(MainFrame.getInstance().getLista().get(0).getText().trim().compareTo(klj) < 0) {
						afile.seek(0);
					} else {
						afile.seek(MainFrame.getInstance().getTrenutniEntitet().getLastSearch());
					}
				}
				while(afile.getFilePointer() < afile.length() && !nadjen && !prekoracio) {
					for(int i = 0; i < block; i++) {
						String red = afile.readLine();
						int pocetak = 0;
						for (int j = 0; j < atributi; j++) {
							int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
							if (kraj < red.length())
								podaci[i][j] = red.substring(pocetak, kraj);
							else
								podaci[i][j] = red.substring(pocetak, red.length());
							heder[j] = MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getName();
							pocetak = kraj;
						}
					}
					for(int i = 0; i < block; i++) {
						if(prekoracio) {
							break;
						}
						if(nadjen) {
							
						}
						nadjen = true;
						brReda = i;
						for(int j = 0; j < atributi; j++) {
							String txt = MainFrame.getInstance().getLista().get(j).getText().trim();
							if(!txt.equals("")) {
								String str = (String)podaci[i][j];
								pomocna.add(str);
								Atribut atri = (Atribut)MainFrame.getInstance().getTrenutniEntitet().getChildAt(j);
								if(atri.isKey()) {
									if(txt.compareTo(str.trim()) < 0) {
										prekoracio = true;
										break;
									}
								}
								if(!txt.equals(str.trim())) {
									nadjen = false;
	//								brReda = i;
									break;
								}
							}
						}
						if(nadjen && !prekoracio) {
							for(int j = 0; j < atributi; j++) {
								matrica[counter][j] = podaci[i][j];
							}
							counter++;
						}

					}
				}
				if(zaokruzi) {
					afile.seek(0);
					while(afile.getFilePointer() < MainFrame.getInstance().getTrenutniEntitet().getLastSearch() && !nadjen && !prekoracio) {
						for(int i = 0; i < block; i++) {
							String red = afile.readLine();
							int pocetak = 0;
							for (int j = 0; j < atributi; j++) {
								int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
								if (kraj < red.length())
									podaci[i][j] = red.substring(pocetak, kraj);
								else
									podaci[i][j] = red.substring(pocetak, red.length());
								heder[j] = MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getName();
								pocetak = kraj;
							}
						}
						for(int i = 0; i < block; i++) {
							if(prekoracio) {
								break;
							}
							nadjen = true;
							brReda = i;
							for(int j = 0; j < atributi; j++) {
								String txt = MainFrame.getInstance().getLista().get(j).getText().trim();
								if(!txt.equals("")) {
									String str = (String)podaci[i][j];
									pomocna.add(str);
									Atribut atri = (Atribut)MainFrame.getInstance().getTrenutniEntitet().getChildAt(j);
									if(atri.isKey()) {
										if(txt.compareTo(str.trim()) < 0) {
											prekoracio = true;
											break;
										}
									}
									if(!txt.equals(str.trim())) {
										nadjen = false;
	//									brReda = i;
										break;
									}
								}
							}
							if(nadjen && !prekoracio) {
								for(int j = 0; j < atributi; j++) {
									matrica[counter][j] = podaci[i][j];
								}
								counter++;
							}
						}
					}
				}
				MainFrame.getInstance().getTrenutniEntitet().setSeek(filePTmp);
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
				MainFrame.getInstance().getTrenutniEntitet().getStateManager().setSearchState();
				if(!prekoracio) {
					MainFrame.getInstance().getTrenutnaTabela().setRowSelectionInterval(brReda, brReda);
					MainFrame.getInstance().getTrenutniEntitet().setLastSearch(afile.getFilePointer() - (block - brReda) * (duzinaReda + 2));
				} else {
					MainFrame.getInstance().getTrenutniEntitet().setLastSearch(afile.getFilePointer());
				}
				dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
				ChooseSaveLocation loc = new ChooseSaveLocation(matrica, counter, heder);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
