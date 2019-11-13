package controller.state;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JDialog;

import main.MainFrame;
import modeli.Atribut;

public class Merge implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().toString().equals("Sekvencijalni")) {
			String fileName = MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + "-"
					+ MainFrame.getInstance().getTrenutniEntitet().getName() + ".dtp";
			File datotekaPromena = new File(fileName);
			int brojLinija = 0;
			try {
				BufferedReader br = new BufferedReader(new FileReader(datotekaPromena));
				String line;
				while((line = br.readLine()) != null) {
					if(line.charAt(line.length() - 1) == 'A') {
						RandomAccessFile afile = new RandomAccessFile(MainFrame.getInstance().getTrenutniEntitet().getPath(), "rw");
						afile.seek(0);
						int duzinaReda = afile.readLine().length();
						afile.seek(0);
						int atributi = MainFrame.getInstance().getTrenutniEntitet().getChildCount();
						String podaci[] = new String[atributi];
						String vrednosti[] = new String[atributi];
						boolean nadjen = false;
						boolean prekoracio = false;
						int poc = 0;
						int check = 0;
						for(int i = 0; i < atributi; i++) {
							int kraj = poc + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(i).getDuzina();
							if (kraj < line.length())
								vrednosti[i] = line.substring(poc, kraj);
							else
								vrednosti[i] = line.substring(poc, line.length());
							poc = kraj;
						}
						while(afile.getFilePointer() != afile.length() && !nadjen && !prekoracio) {
							String red = afile.readLine();
							int pocetak = 0;
							for (int j = 0; j < atributi; j++) {
								int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
								if (kraj < red.length())
									podaci[j] = red.substring(pocetak, kraj);
								else
									podaci[j] = red.substring(pocetak, red.length());
								pocetak = kraj;
							}
							nadjen = true;
							for(int j = 0; j < atributi; j++) {
								Atribut atri = (Atribut)MainFrame.getInstance().getTrenutniEntitet().getChildAt(j);
								if(atri.isKey()) {
									if(podaci[j].trim().compareTo(vrednosti[j].trim()) > 0) {
										prekoracio = true;
										break;
									}
								}
								if(!podaci[j].trim().equals(vrednosti[j])) {
									nadjen = false;
									break;
								}
							}
							if(nadjen) {
								//greska
							}
							if(prekoracio) {
								break;
							}
						}
						String trLinija[] = vrednosti;
						String[] slLinija = podaci;
//						int poce = 0;
//						for (int j = 0; j < atributi; j++) {
//							int kraj = poce + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
//							if (kraj < red1.length())
//								slLinija[j] = red1.substring(poce, kraj);
//							else
//								slLinija[j] = red1.substring(poce, red1.length());
//							poce = kraj;
//						}
						afile.seek(afile.getFilePointer() - (duzinaReda + 2));
						while(afile.getFilePointer() != afile.length()) {
							StringBuilder sb = new StringBuilder();
							for(int i = 0; i < atributi; i++) {
								sb.append(trLinija[i]);
							}
							sb.append("\r\n");
							afile.writeBytes(sb.toString());
//							afile.seek(afile.getFilePointer() - (duzinaReda + 2));
//							System.out.print(sb.toString());
							for(int i = 0; i < atributi; i++) {
								trLinija[i] = slLinija[i];
//								System.out.print(trLinija[i]);
							}
//							System.out.println();
							if(afile.getFilePointer() != afile.length()) {
								String lin = afile.readLine();
//								System.out.println(lin);
								afile.seek(afile.getFilePointer() - (duzinaReda + 2));
								int pocetak = 0;
								for (int j = 0; j < atributi; j++) {
									int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
									if (kraj < lin.length())
										slLinija[j] = lin.substring(pocetak, kraj);
									else
										slLinija[j] = lin.substring(pocetak, lin.length());
									pocetak = kraj;
								}
							}
						}
//						System.out.println(sb2.toString());
						StringBuilder sb = new StringBuilder();
						for(int i = 0; i < atributi; i++) {
							sb.append(trLinija[i]);
						}
						sb.append("\r\n");
						afile.writeBytes(sb.toString());
						afile.setLength(afile.length());
						afile.close();
					} else if(line.charAt(line.length() - 1) == 'D') {
						RandomAccessFile afile = new RandomAccessFile(MainFrame.getInstance().getTrenutniEntitet().getPath(), "rw");
						afile.seek(0);
						int duzinaReda = afile.readLine().length();
						afile.seek(0);
						int atributi = MainFrame.getInstance().getTrenutniEntitet().getChildCount();
						String podaci[] = new String[atributi];
						String vrednosti[] = new String[atributi];
						boolean nadjen = false;
						boolean prekoracio = false;
						int poc = 0;
						int check = 0;
						for(int i = 0; i < atributi; i++) {
							int kraj = poc + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(i).getDuzina();
							if (kraj < line.length())
								vrednosti[i] = line.substring(poc, kraj);
							else
								vrednosti[i] = line.substring(poc, line.length());
							poc = kraj;
						}
						while(afile.getFilePointer() != afile.length() && !nadjen && !prekoracio) {
							String red = afile.readLine();
							int pocetak = 0;
							for (int j = 0; j < atributi; j++) {
								int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
								if (kraj < red.length())
									podaci[j] = red.substring(pocetak, kraj);
								else
									podaci[j] = red.substring(pocetak, red.length());
								pocetak = kraj;
							}
							nadjen = true;
							for(int j = 0; j < atributi; j++) {
								Atribut atri = (Atribut)MainFrame.getInstance().getTrenutniEntitet().getChildAt(j);
								if(atri.isKey()) {
									if(podaci[j].trim().compareTo(vrednosti[j].trim()) > 0) {
										prekoracio = true;
										break;
									}
								}
								if(!podaci[j].trim().equals(vrednosti[j])) {
									nadjen = false;
									break;
								}
							}
							if(nadjen) {
								break;
							}
							if(prekoracio) {
								//greska
							}
						}
						String trLinija[] = vrednosti;
						StringBuilder sb = new StringBuilder();
						for(int i = 0; i < atributi; i++) {
							sb.append(trLinija[i]);
						}
						String cilj = sb.toString();
						String slLinija[] = new String[atributi];
						long ptr = afile.getFilePointer() - (duzinaReda + 2);
						afile.seek(afile.length() - (duzinaReda + 2));
						String podaci1;
//						String podaci1 = afile.readLine();
//						System.out.println(podaci1);
//						afile.seek(afile.getFilePointer() - 2 * (duzinaReda + 2));
//						afile.writeBytes(podaci1 + "\r\n");
						String linija = afile.readLine();
						while(!linija.equals(cilj)) {
							afile.seek(afile.getFilePointer() - 2 * (duzinaReda + 2));
							podaci1 = afile.readLine();
							afile.seek(afile.getFilePointer() - (duzinaReda + 2));
							afile.writeBytes(linija + "\r\n");
							linija = podaci1;
						}
						afile.setLength(afile.length() - (duzinaReda + 2));
						afile.close();
					} else if(line.charAt(line.length() - 1) == 'U') {
						RandomAccessFile afile = new RandomAccessFile(MainFrame.getInstance().getTrenutniEntitet().getPath(), "rw");
						afile.seek(0);
						int duzinaReda = afile.readLine().length();
						afile.seek(0);
						int atributi = MainFrame.getInstance().getTrenutniEntitet().getChildCount();
						String podaci[] = new String[atributi];
						String vrednosti[] = new String[atributi];
						boolean nadjen = false;
						boolean prekoracio = false;
						int poc = 0;
						int check = 0;
						for(int i = 0; i < atributi; i++) {
							int kraj = poc + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(i).getDuzina();
							if (kraj < line.length())
								vrednosti[i] = line.substring(poc, kraj);
							else
								vrednosti[i] = line.substring(poc, line.length());
							poc = kraj;
						}
						while(afile.getFilePointer() != afile.length() && !nadjen && !prekoracio) {
							String red = afile.readLine();
							int pocetak = 0;
							for (int j = 0; j < atributi; j++) {
								int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
								if (kraj < red.length())
									podaci[j] = red.substring(pocetak, kraj);
								else
									podaci[j] = red.substring(pocetak, red.length());
								pocetak = kraj;
							}
							nadjen = true;
							for(int j = 0; j < atributi; j++) {
								Atribut atri = (Atribut)MainFrame.getInstance().getTrenutniEntitet().getChildAt(j);
								if(atri.isKey()) {
									if(podaci[j].trim().compareTo(vrednosti[j].trim()) > 0) {
										prekoracio = true;
										break;
									}
								}
								if(!podaci[j].trim().equals(vrednosti[j])) {
									nadjen = false;
									break;
								}
							}
							if(nadjen) {
								break;
							}
							if(prekoracio) {
								//greska
							}
						}
						String trLinija[] = vrednosti;
						StringBuilder sb = new StringBuilder();
						for(int i = 0; i < atributi; i++) {
							sb.append(trLinija[i]);
						}
						String cilj = sb.toString();
						String slLinija[] = new String[atributi];
						long ptr = afile.getFilePointer() - (duzinaReda + 2);
						afile.seek(afile.length() - (duzinaReda + 2));
						String podaci1;
//						String podaci1 = afile.readLine();
//						System.out.println(podaci1);
//						afile.seek(afile.getFilePointer() - 2 * (duzinaReda + 2));
//						afile.writeBytes(podaci1 + "\r\n");
						String linija = afile.readLine();
						while(!linija.equals(cilj)) {
							afile.seek(afile.getFilePointer() - 2 * (duzinaReda + 2));
							podaci1 = afile.readLine();
							afile.seek(afile.getFilePointer() - (duzinaReda + 2));
							afile.writeBytes(linija + "\r\n");
							linija = podaci1;
						}
						afile.setLength(afile.length() - (duzinaReda + 2));
						//dodaj
						afile.seek(0);
						String updt = br.readLine();
						String updtVrednosti[] = new String[atributi];
						nadjen = false;
						prekoracio = false;
						poc = 0;
						for(int i = 0; i < atributi; i++) {
							int kraj = poc + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(i).getDuzina();
							if (kraj < updt.length())
								updtVrednosti[i] = updt.substring(poc, kraj);
							else
								updtVrednosti[i] = updt.substring(poc, updt.length());
							poc = kraj;
						}
						while(afile.getFilePointer() != afile.length() && !nadjen && !prekoracio) {
							String red = afile.readLine();
							int pocetak = 0;
							for (int j = 0; j < atributi; j++) {
								int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
								if (kraj < red.length())
									podaci[j] = red.substring(pocetak, kraj);
								else
									podaci[j] = red.substring(pocetak, red.length());
								pocetak = kraj;
							}
							nadjen = true;
							for(int j = 0; j < atributi; j++) {
								Atribut atri = (Atribut)MainFrame.getInstance().getTrenutniEntitet().getChildAt(j);
								if(atri.isKey()) {
									if(podaci[j].trim().compareTo(updtVrednosti[j].trim()) > 0) {
										prekoracio = true;
										break;
									}
								}
								if(!podaci[j].trim().equals(updtVrednosti[j])) {
									nadjen = false;
									break;
								}
							}
							if(nadjen) {
								//greska
							}
							if(prekoracio) {
								break;
							}
						}
						trLinija = updtVrednosti;
						slLinija = podaci;
						afile.seek(afile.getFilePointer() - (duzinaReda + 2));
						while(afile.getFilePointer() != afile.length()) {
							StringBuilder sb2 = new StringBuilder();
							for(int i = 0; i < atributi; i++) {
								sb2.append(trLinija[i]);
							}
							sb2.append("\r\n");
							afile.writeBytes(sb2.toString());
//							afile.seek(afile.getFilePointer() - (duzinaReda + 2));
//							System.out.print(sb.toString());
							for(int i = 0; i < atributi; i++) {
								trLinija[i] = slLinija[i];
//								System.out.print(trLinija[i]);
							}
//							System.out.println();
							if(afile.getFilePointer() != afile.length()) {
								String lin = afile.readLine();
//								System.out.println(lin);
								afile.seek(afile.getFilePointer() - (duzinaReda + 2));
								int pocetak = 0;
								for (int j = 0; j < atributi; j++) {
									int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
									if (kraj < lin.length())
										slLinija[j] = lin.substring(pocetak, kraj);
									else
										slLinija[j] = lin.substring(pocetak, lin.length());
									pocetak = kraj;
								}
							}
						}
//						System.out.println(sb2.toString());
						StringBuilder sb2 = new StringBuilder();
						for(int i = 0; i < atributi; i++) {
							sb2.append(trLinija[i]);
						}
						sb2.append("\r\n");
						afile.writeBytes(sb2.toString());
						afile.setLength(afile.length());
						afile.close();
//						RandomAccessFile afile = new RandomAccessFile(MainFrame.getInstance().getTrenutniEntitet().getPath(), "rw");
//						afile.seek(0);
//						int duzinaReda = afile.readLine().length();
//						int atributi = MainFrame.getInstance().getTrenutniEntitet().getChildCount();
//						String podaci[] = new String[atributi];
//						String vrednosti[] = new String[atributi];
//						String updtVrednosti[] = new String[atributi];
//						String updt = br.readLine();
//						boolean nadjen = false;
//						boolean prekoracio = false;
//						int poc = 0;
//						for(int i = 0; i < atributi; i++) {
//							int kraj = poc + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(i).getDuzina();
//							if (kraj < updt.length())
//								updtVrednosti[i] = updt.substring(poc, kraj);
//							else
//								updtVrednosti[i] = updt.substring(poc, updt.length());
//							poc = kraj;
//						}
//						poc = 0;
//						for(int i = 0; i < atributi; i++) {
//							int kraj = poc + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(i).getDuzina();
//							if (kraj < line.length())
//								vrednosti[i] = line.substring(poc, kraj);
//							else
//								vrednosti[i] = line.substring(poc, line.length());
//							poc = kraj;
//						}
//						while(afile.getFilePointer() != afile.length() && !nadjen && !prekoracio) {
//							String red = afile.readLine();
//							int pocetak = 0;
//							for (int j = 0; j < atributi; j++) {
//								int kraj = pocetak + MainFrame.getInstance().getTrenutniEntitet().getAtributi().get(j).getDuzina();
//								if (kraj < red.length())
//									podaci[j] = red.substring(pocetak, kraj);
//								else
//									podaci[j] = red.substring(pocetak, red.length());
//								pocetak = kraj;
//							}
//							nadjen = true;
//							for(int j = 0; j < atributi; j++) {
//								Atribut atri = (Atribut)MainFrame.getInstance().getTrenutniEntitet().getChildAt(j);
//								if(atri.isKey()) {
//									if(podaci[j].trim().compareTo(vrednosti[j].trim()) > 0) {
//										prekoracio = true;
//										break;
//									}
//								}
//								if(!podaci[j].trim().equals(vrednosti[j])) {
//									nadjen = false;
//									break;
//								}
//							}
//							if(nadjen) {
//								break;
//							}
//							if(prekoracio) {
//								//greska
//							}
//						}
//						afile.seek(afile.getFilePointer() - 2 * (duzinaReda + 2));
//						String unos[] = new String[atributi];
//						for(int i = 0; i < atributi; i++) {
//							if(updtVrednosti[i].trim().equals("")) {
//								unos[i] = vrednosti[i];
//							} else {
//								unos[i] = updtVrednosti[i];
//							}
//						}
//						StringBuffer sb = new StringBuffer();
//						for(int i = 0; i < atributi; i++) {
//							sb.append(unos[i]);
//						}
//						sb.append("\r\n");
//						afile.writeBytes(sb.toString());
//						afile.close();
					} else {
						
					}
					datotekaPromena.delete();
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
