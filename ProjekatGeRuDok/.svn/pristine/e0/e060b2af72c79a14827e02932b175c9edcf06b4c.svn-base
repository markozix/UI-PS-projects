package state;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import main.MainFrame;
import model.Element;
import model.Slot;
import model.SlotDevice;
import view.DokumentView;
import view.ProjekatView;
import view.SlotView;
import view.SlotView.Handle;
import view.StranicaView;

public class SelectState extends State {

	private Slot slot;
	private int elementInMotion = -1;
	private Handle handleInMotion = null;
	private int mouseButton = 0;
	
	public SelectState(Slot slot) {
		this.slot = slot;
	}

	public void mousePressed(MouseEvent e) {
		if(!e.isControlDown()) {
			slot.getSelectionModel().removeAllFromSelectionList();
		}
		mouseButton = e.getButton();
		Point position = e.getPoint();
		if(e.getButton() == MouseEvent.BUTTON1) {
			Slot slot = (Slot)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
			SlotView view = new SlotView();
			for(Component i : MainFrame.getInstance().getDesniDesktop().getComponents()) {
				if(i instanceof ProjekatView) {
					ProjekatView tmp = (ProjekatView)i;
					for(DokumentView j : tmp.getLista()) {
						DokumentView tmp2 = j;
						for(StranicaView k : tmp2.getLista()) {
							StranicaView tmp3 = k;
							for(SlotView l : tmp3.getLista()) {
								if(l.getSlot().equals(slot)) {
									view = l;
								}
							}
						}
					}
				}
			}
			handleInMotion = view.getDeviceAndHandleForPoint(position);
			if(handleInMotion == null) {
				elementInMotion = slot.getModel().getElementAtPosition(position);
				if(elementInMotion != -1) {
					Element element = slot.getModel().getElementi().get(elementInMotion);
					if(slot.getSelectionModel().isElementSelected(element)) {
						slot.getSelectionModel().removeFromSelectionList(element);
					} else {
						slot.getSelectionModel().addToSelectionList(element);
					}
				}
			}
		}
	}
	
	public void mouseMoved(MouseEvent e) {
		Point2D point = e.getPoint();
		Object slot = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		if(slot instanceof Slot) {
			SlotView view = new SlotView();
			for(Component i : MainFrame.getInstance().getDesniDesktop().getComponents()) {
				if(i instanceof ProjekatView) {
					ProjekatView tmp = (ProjekatView)i;
					for(DokumentView j : tmp.getLista()) {
						DokumentView tmp2 = j;
						for(StranicaView k : tmp2.getLista()) {
							StranicaView tmp3 = k;
							for(SlotView l : tmp3.getLista()) {
								if(l.getSlot().equals(slot)) {
									view = l;
								}
							}
						}
					}
				}
			}
			view.setMouseCursor(point);
		}
		
	}
	
	public void mouseDragged(MouseEvent e) {
		if(mouseButton == MouseEvent.BUTTON1) {
			Point position = e.getPoint();
			Slot slot = (Slot)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
			SlotView view = new SlotView();
			for(Component i : MainFrame.getInstance().getDesniDesktop().getComponents()) {
				if(i instanceof ProjekatView) {
					ProjekatView tmp = (ProjekatView)i;
					for(DokumentView j : tmp.getLista()) {
						DokumentView tmp2 = j;
						for(StranicaView k : tmp2.getLista()) {
							StranicaView tmp3 = k;
							for(SlotView l : tmp3.getLista()) {
								if(l.getSlot().equals(slot)) {
									view = l;
								}
							}
						}
					}
				}
			}
			handleInMotion = view.getDeviceAndHandleForPoint(position);
			if(handleInMotion != null) {
				
			} else {
				elementInMotion = slot.getModel().getElementAtPosition(position);
				if(elementInMotion != -1) {
					slot.getStateManager().setMoveStanje();
					return;
				} else {
					slot.getStateManager().setLassoStanje();
				}
			}
		}
	}

}
