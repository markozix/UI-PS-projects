package akcije;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import event.UpdateListener;
import komande.CommandManager;
import main.MainFrame;
import model.Dokument;
import model.DokumentSelection;
import model.GrafickiSlot;
import model.TekstualniSlot;
import state.StateManager;
import view.DokumentView;
import view.DokumentViewSelection;
import view.GrafickiSlotView;
import view.ProjekatView;
import view.SlotView;
import view.StranicaView;
import view.StranicaViewSelection;
import view.TekstualniSlotView;
import model.Projekat;
import model.Slot;
import model.SlotSelection;
import model.Stranica;
import model.StranicaSelection;

public class PasteAction implements ActionListener {

	public PasteAction() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		Transferable cbContent = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
		Transferable cbContent2 = MainFrame.getInstance().getClipboard().getContents(null);
		if (o instanceof Projekat) {
			if ((cbContent != null) && (cbContent.isDataFlavorSupported(DokumentSelection.elef))) {
				try {
					ArrayList<Dokument> tmp = (ArrayList<Dokument>) cbContent.getTransferData(DokumentSelection.elef);
					for (int i = 0; i < tmp.size(); i++) {
						Dokument d = new Dokument(tmp.get(i));
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						ObjectOutputStream out = new ObjectOutputStream(bos);
			            out.writeObject(d);
			            out.flush();
			            out.close();

			            ObjectInputStream in = new ObjectInputStream(
			                new ByteArrayInputStream(bos.toByteArray()));
			            Dokument kopirani = (Dokument)in.readObject();
						((Projekat) o).add(kopirani);
						ProjekatView trazen = null;
						for(Component c : MainFrame.getInstance().getDesniDesktop().getComponents()) {
							if(c instanceof ProjekatView) {
								if(((ProjekatView)c).getProjekat().equals((Projekat)o)) {
									trazen = (ProjekatView)c;
								}
							}
						}
						DokumentView dview = new DokumentView();
						dview.setDokument(kopirani);
						trazen.dodaj(dview);
						trazen.getTabovi().addTab(d.getNaziv(), dview.getContentPane());
						d.getListenerList().add(UpdateListener.class, (UpdateListener) o);
						d.fireUpdatePerformed();
						for(int j = 0; j < kopirani.getChildCount(); j++) {
							Stranica s = (Stranica)kopirani.getChildAt(j);
							StranicaView sview = new StranicaView();
							sview.setStranica(s);
							dview.add(sview);
							dview.dodaj(sview);
							for(int k = 0; k < s.getChildCount(); k++) {
								if(s.getChildAt(k) instanceof GrafickiSlot) {
									GrafickiSlot gsl = (GrafickiSlot)s.getChildAt(k);
									GrafickiSlotView gslview = new GrafickiSlotView();
									StateManager sm = new StateManager(gsl);
									CommandManager cm = new CommandManager();
									gsl.setCommandManager(cm);
									gsl.setStateManager(sm);
									gsl.getModel().getListenerList().add(UpdateListener.class, (UpdateListener)gslview);
									gsl.getSelectionModel().getListaListenera().add(UpdateListener.class, (UpdateListener)gslview);
									gslview.setSlot(gsl);
									sview.add(gslview);
									sview.dodaj(gslview);
								} else {
									TekstualniSlot tsl = (TekstualniSlot)s.getChildAt(k);
									TekstualniSlotView tslview = new TekstualniSlotView();
									tslview.setTs(tsl);
									tsl.getModel().getListenerList().add(UpdateListener.class, (UpdateListener)tslview);
									sview.add(tslview);
									sview.dodaj(tslview);
								}
							}
						}
						MainFrame.getInstance().getTree().expandPath(path);
						SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		if (o instanceof Dokument) {
			if ((cbContent != null) && (cbContent.isDataFlavorSupported(StranicaSelection.elef))) {
				try {
					ArrayList<Stranica> tmp = (ArrayList<Stranica>) cbContent.getTransferData(StranicaSelection.elef);
					for (int i = 0; i < tmp.size(); i++) {
						Stranica s = new Stranica(tmp.get(i));
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						ObjectOutputStream out = new ObjectOutputStream(bos);
			            out.writeObject(s);
			            out.flush();  
			            out.close();

			            ObjectInputStream in = new ObjectInputStream(
			                new ByteArrayInputStream(bos.toByteArray()));
			            Stranica kopirani = (Stranica)in.readObject();
						((Dokument) o).add(kopirani);
						DokumentView trazen = null;
						ProjekatView view1 = null;
						for(Component c : MainFrame.getInstance().getDesniDesktop().getComponents()) {
							if(c instanceof ProjekatView) {
								ProjekatView pv = (ProjekatView)c;
								if(((ProjekatView)c).getProjekat().equals((Projekat)path.getPathComponent(1))) {
									view1 = (ProjekatView)c;
								}
								for(DokumentView j : pv.getLista()) {
									if(j.getDokument().equals((Dokument)o)) {
										trazen = j;
									}
								}
							}
						}
						StranicaView sview = new StranicaView();
						sview.setStranica(kopirani);
						trazen.dodaj(sview);
						trazen.add(sview);
						for(int k = 0; k < s.getChildCount(); k++) {
							if(s.getChildAt(k) instanceof GrafickiSlot) {
								GrafickiSlot gsl = (GrafickiSlot)s.getChildAt(k);
								GrafickiSlotView gslview = new GrafickiSlotView();
								StateManager sm = new StateManager(gsl);
								CommandManager cm = new CommandManager();
								gsl.setCommandManager(cm);
								gsl.setStateManager(sm);
								gsl.getModel().getListenerList().add(UpdateListener.class, (UpdateListener)gslview);
								gsl.getSelectionModel().getListaListenera().add(UpdateListener.class, (UpdateListener)gslview);
								gslview.setSlot(gsl);
								sview.add(gslview);
								sview.dodaj(gslview);
							} else {
								TekstualniSlot tsl = (TekstualniSlot)s.getChildAt(k);
								TekstualniSlotView tslview = new TekstualniSlotView();
								tslview.setTs(tsl);
								tsl.getModel().getListenerList().add(UpdateListener.class, (UpdateListener)tslview);
								sview.add(tslview);
								sview.dodaj(tslview);
							}
						}
						trazen.repaint();
						trazen.revalidate();
						s.getListenerList().add(UpdateListener.class, (UpdateListener) path.getPathComponent(1));
						s.fireUpdatePerformed();
						MainFrame.getInstance().getTree().expandPath(path);
						SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
						view1.repaint();
						view1.revalidate();
//						for (Component cmp : MainFrame.getInstance().getDesniDesktop().getComponents()) {
//							if (cmp instanceof ProjekatView) {
//								ProjekatView pv = (ProjekatView) cmp;
//								for (DokumentView j : pv.getLista()) {
//									if (j.getDokument().equals((Dokument) o)) {
//										ArrayList<StranicaView> tmp6 = (ArrayList<StranicaView>) cbContent2
//												.getTransferData(StranicaViewSelection.elef);
//										for (int aman = 0; aman < tmp6.size(); aman++) {
//											StranicaView svV = new StranicaView(tmp6.get(aman));
//											for (SlotView hh : svV.getLista()) {
//												SlotView aids2 = new SlotView(hh);
//												svV.add(aids2);
//											}
//											j.add(svV);
//											j.repaint();
//											j.revalidate();
//											pv.repaint();
//											pv.revalidate();
//										}
//									}
//								}
//							}
//						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		if (o instanceof Stranica) {
			if ((cbContent != null) && (cbContent.isDataFlavorSupported(SlotSelection.elef))) {
				try {
					ArrayList<Slot> tmp = (ArrayList<Slot>) cbContent.getTransferData(SlotSelection.elef);
					for (int i = 0; i < tmp.size(); i++) {
						if (tmp.get(i) instanceof GrafickiSlot) {
							GrafickiSlot s1 = new GrafickiSlot((GrafickiSlot) tmp.get(i));
							ByteArrayOutputStream bos = new ByteArrayOutputStream();
							ObjectOutputStream out = new ObjectOutputStream(bos);
				            out.writeObject(s1);
				            out.flush();
				            out.close();

				            ObjectInputStream in = new ObjectInputStream(
				                new ByteArrayInputStream(bos.toByteArray()));
				            GrafickiSlot kopirani = (GrafickiSlot)in.readObject();
							((Stranica) o).add(kopirani);
							StranicaView trazen = null;
							ProjekatView view1 = null;
							for(Component c : MainFrame.getInstance().getDesniDesktop().getComponents()) {
								if(c instanceof ProjekatView) {
									ProjekatView pv = (ProjekatView)c;
									if(((ProjekatView)c).getProjekat().equals((Projekat)path.getPathComponent(1))) {
										view1 = (ProjekatView)c;
									}
									for(DokumentView j : pv.getLista()) {
										for(StranicaView k : j.getLista()) {
											if(k.getStranica().equals((Stranica)o)) {
												trazen = k;
											}
 										}
									}
								}
							}
							GrafickiSlotView gslview = new GrafickiSlotView();
							StateManager sm = new StateManager(kopirani);
							CommandManager cm = new CommandManager();
							kopirani.setStateManager(sm);
							kopirani.setCommandManager(cm);
							kopirani.getModel().getListenerList().add(UpdateListener.class, (UpdateListener)gslview);
							kopirani.getSelectionModel().getListaListenera().add(UpdateListener.class, (UpdateListener)gslview);
							gslview.setSlot(kopirani);
							trazen.dodaj(gslview);
							trazen.add(gslview);
							
							s1.getListenerList().add(UpdateListener.class, (UpdateListener) path.getPathComponent(1));
							s1.fireUpdatePerformed();
							MainFrame.getInstance().getTree().expandPath(path);
							SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
							view1.repaint();
							view1.revalidate();
						} else {
							TekstualniSlot s2 = new TekstualniSlot((TekstualniSlot) tmp.get(i));
							ByteArrayOutputStream bos = new ByteArrayOutputStream();
							ObjectOutputStream out = new ObjectOutputStream(bos);
				            out.writeObject(s2);
				            out.flush();
				            out.close();

				            ObjectInputStream in = new ObjectInputStream(
				                new ByteArrayInputStream(bos.toByteArray()));
				            TekstualniSlot kopirani = (TekstualniSlot)in.readObject();
							((Stranica) o).add(kopirani);
							StranicaView trazen = null;
							ProjekatView view1 = null;
							for(Component c : MainFrame.getInstance().getDesniDesktop().getComponents()) {
								if(c instanceof ProjekatView) {
									ProjekatView pv = (ProjekatView)c;
									if(((ProjekatView)c).getProjekat().equals((Projekat)path.getPathComponent(1))) {
										view1 = (ProjekatView)c;
									}
									for(DokumentView j : pv.getLista()) {
										for(StranicaView k : j.getLista()) {
											if(k.getStranica().equals((Stranica)o)) {
												trazen = k;
											}
 										}
									}
								}
							}
							TekstualniSlotView tslview = new TekstualniSlotView();
							tslview.setTs(kopirani);
							s2.getModel().getListenerList().add(UpdateListener.class, (UpdateListener)tslview);
							trazen.add(tslview);
							trazen.dodaj(tslview);
							
							s2.getListenerList().add(UpdateListener.class, (UpdateListener) path.getPathComponent(1));
							s2.fireUpdatePerformed();
							MainFrame.getInstance().getTree().expandPath(path);
							SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
							view1.repaint();
							view1.revalidate();
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
