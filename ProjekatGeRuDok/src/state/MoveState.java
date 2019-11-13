package state;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Iterator;

import main.MainFrame;
import model.Element;
import model.InputOutputElement;
import model.Slot;
import model.SlotDevice;
import view.DokumentView;
import view.ProjekatView;
import view.SlotView;
import view.StranicaView;

public class MoveState extends State {

	private Slot slot;
	private double x = 0, y = 0;
	
	public MoveState(Slot slot) {
		this.slot = slot;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point2D lastPos = e.getPoint();
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
		view.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		double x2 = lastPos.getX() - view.getLastPos().getX();
		double y2 = lastPos.getY() - view.getLastPos().getY();
		Iterator<Element> iterator = slot.getSelectionModel().getSelectionList().iterator();
		while(iterator.hasNext()) {
			Element element = iterator.next();
			if(element instanceof SlotDevice) {
				SlotDevice device = (SlotDevice)element;
				Point2D newPosition = (Point2D)device.getPosition();
				newPosition.setLocation(newPosition.getX() + x2, newPosition.getY() + y2);
				device.setPosition(newPosition);
				Iterator<InputOutputElement> it2 = device.getInputs().iterator();
				int i = 0;
				while(it2.hasNext()) {
					Point2D ioPos = new Point2D.Double(device.getPosition().getX(), device.getPosition().getY()
							+ (device.getSize().getHeight() / (device.getBrIn() + 1)) * (i + 1));
					InputOutputElement ioe = it2.next();
					ioe.setPosition(ioPos);
					view.repaint();
					i++;
				}
				
				it2 = device.getOutputs().iterator();
				i = 0;
				while(it2.hasNext()) {
					Point2D ioPos = new Point2D.Double(device.getPosition().getX() + device.getSize().getWidth(), device.getPosition().getY()
							+ (device.getSize().getHeight() / (device.getBrOut() + 1)) * (i + 1));
					InputOutputElement ioe = it2.next();
					ioe.setPosition(ioPos);
					view.repaint();
					i++;
				}
			}
		}
		view.setLastPos(lastPos);
		view.repaint();
//		double xx = lastPos.getX() - view.getLastPos().getX();
//		double yy = lastPos.getY() - view.getLastPos().getY();
//		Iterator<Element> it = slot.getSelectionModel().getSelectionList().iterator();
//		while(it.hasNext()) {
//			Element element = it.next();
//			if(element instanceof SlotDevice) {
//				SlotDevice device = (SlotDevice)element;
//				Point2D newPos = (Point2D)device.getPosition().clone();
//				newPos.setLocation(newPos.getX() + xx, newPos.getY() + yy);
//				device.setPosition(newPos);
//				view.repaint();
//			}
//		}
//		x = x + xx;
//		y = y + yy;
//		view.setLastPos(lastPos);
//		view.updatePerformed(null);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
//		Slot med = (Slot)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
//		SlotView view = new SlotView();
//		for(Component i : MainFrame.getInstance().getDesniDesktop().getComponents()) {
//			if(i instanceof ProjekatView) {
//				ProjekatView tmp = (ProjekatView)i;
//				for(DokumentView j : tmp.getLista()) {
//					DokumentView tmp2 = j;
//					for(StranicaView k : tmp2.getLista()) {
//						StranicaView tmp3 = k;
//						for(SlotView l : tmp3.getLista()) {
//							if(l.getSlot().equals(med)) {
//								view = l;
//							}
//						}
//					}
//				}
//			}
//		}
//		Point pos = e.getPoint();
//		slot.getCommandManager().addCommand(new MoveDeviceCommand(slot.getModel(), slot.getSelectionModel(), pos.getX(), pos.getY()));
//		view.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
//		x = 0;
//		y = 0;
//		Point2D lastPos = e.getPoint();
//		view.setLastPos(lastPos);
		slot.getStateManager().setSelectStanje();
	}
}
