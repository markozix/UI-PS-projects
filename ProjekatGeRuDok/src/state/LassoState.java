package state;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import main.MainFrame;
import model.Slot;
import view.DokumentView;
import view.ProjekatView;
import view.SlotView;
import view.StranicaView;

public class LassoState extends State {

	private Rectangle2D pravougaonik = new Rectangle2D.Double();
	private Slot slot;
	
	public LassoState(Slot slot) {
		this.slot = slot;
	}

	public void mouseDragged(MouseEvent e) {
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
		Point2D mousePos = e.getPoint();
		if(!e.isControlDown()) {
			slot.getSelectionModel().removeAllFromSelectionList();
		}
		
		double width = mousePos.getX() - view.getLastPos().getX();
		double height = mousePos.getY() - view.getLastPos().getY();
		if((width < 0) && (height < 0)) {
			pravougaonik.setRect(mousePos.getX(), mousePos.getY(), Math.abs(width), Math.abs(height));
		} else if((width < 0) && (height >= 0)) {
			pravougaonik.setRect(mousePos.getX(), view.getLastPos().getY(), Math.abs(width), Math.abs(height));
		} else if((width > 0) && (height < 0)) {
			pravougaonik.setRect(view.getLastPos().getX(), mousePos.getY(), Math.abs(width), Math.abs(height));
		} else {
			pravougaonik.setRect(view.getLastPos().getX(), view.getLastPos().getY(), Math.abs(width), Math.abs(height));
		}
		view.setSelectioPravougaonik(pravougaonik);
		slot.getSelectionModel().izaberiElemente(pravougaonik, slot.getModel().getElementi());
		view.repaint();
	}

	public void mouseReleased(MouseEvent e) {
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
		view.setSelectioPravougaonik(new Rectangle2D.Double(0, 0, 0, 0));
		view.repaint();
		slot.getStateManager().setSelectStanje();
	}

}
