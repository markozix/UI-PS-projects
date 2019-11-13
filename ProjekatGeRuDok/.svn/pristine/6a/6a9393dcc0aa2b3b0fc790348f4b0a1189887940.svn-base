package state;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import main.MainFrame;
import model.Element;
import model.InputOutputElement;
import model.LinijaElement;
import model.Slot;
import model.SlotDevice;
import view.DokumentView;
import view.ProjekatView;
import view.SlotView;
import view.StranicaView;

public class LinijaState extends State {

	private Slot slot;
	private LinijaElement veza = null;
	
	public LinijaState(Slot slot) {
		this.slot = slot;
	}

	@Override
	public void mousePressed(MouseEvent e) {
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
		slot.getSelectionModel().removeAllFromSelectionList();
		view.repaint();
		
		Point position = e.getPoint();
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(veza == null) {
				if(slot.getModel().getElementAtPosition(position) != -1) {
					Element device = slot.getModel().getElementi().get(slot.getModel().getElementAtPosition(position));
					if(device instanceof SlotDevice) {
						SlotDevice ele = (SlotDevice)device;
						Point point = new Point();
						point.setLocation(ele.getPosition().getX() + ele.getSize().width, 
								ele.getPosition().getY() + ele.getSize().height / 2);
//						InputOutputElement ioElem = (InputOutputElement)InputOutputElement.napraviCustom(point, null, null,
//								ele, slot.getModel().getElementi().size(), 1);
//						slot.getModel().addElement(ioElem);
//						veza = (LinijaElement)LinijaElement.napraviCustom(ele, ioElem, slot.getModel().getElementi().size());
//						System.out.println("Da");
						InputOutputElement ioElement = ele.getOutputs().get(0);
						veza = (LinijaElement)LinijaElement.napraviCustom(ele, ioElement,
								slot.getModel().getElementi().size());
						slot.getModel().addElement(veza);
					}
				}
			} else {
				if(slot.getModel().getElementAtPosition(position) == -1) {
					veza.getPoints().add(position);
				} else {
					Element device = slot.getModel().getElementi().get(slot.getModel().getElementAtPosition(position));
					if(device instanceof SlotDevice) {
						SlotDevice ele = (SlotDevice)device;
//						Point point = new Point();
//						if(position.getY() < ele.getPosition().getY() + ele.getSize().height / 2) {
//							point.setLocation(ele.getPosition().getX(), ele.getPosition().getY() + ele.getSize().height / 3);
//						} else {
//							point.setLocation(ele.getPosition().getX(), ele.getPosition().getY() +
//									2 * ele.getSize().height / 3);
//						}
//						InputOutputElement ioElem = (InputOutputElement)InputOutputElement.napraviCustom(point, null, null,
//								ele, slot.getModel().getElementi().size(), 1);
//						slot.getModel().addElement(ioElem);
//						veza.setInput(ioElem);
//						veza.setKranji(ele);
//						veza = null;
						InputOutputElement ioElement = ele.getInputs().get(0);
						veza.setKranji(ele);
						veza.setInput(ioElement);
						veza.setPainter(veza);
					}
				}
			}
		}
		view.repaint();
	}

	@Override
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
		slot.getSelectionModel().removeAllFromSelectionList();
		view.repaint();
		if(veza != null) {
			Point position = e.getPoint();
//			veza.getPoints().get(veza.getPoints().size() - 1);
			veza.setPainter(veza);
		}
		view.repaint();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
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
		slot.getSelectionModel().removeAllFromSelectionList();
		view.repaint();
		if(veza != null) {
			Point position = e.getPoint();
			veza.getPoints().get(veza.getPoints().size() - 1);
			veza.setPainter(veza);
		}
		view.repaint();
	}

	@Override
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
		slot.getSelectionModel().removeAllFromSelectionList();
		view.repaint();
		
		Point position = e.getPoint();
		if(veza == null) {
			return;
		}
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(slot.getModel().getElementAtPosition(position) != -1) {
				SlotDevice endDevice = (SlotDevice) slot.getModel().getElementi().
						get(slot.getModel().getElementAtPosition(position));
				if(endDevice.getInputs().size() > 0) {
					InputOutputElement input;
					if(position.getY() > endDevice.getPosition().getY() + endDevice.getSize().getHeight() / 2) {
						input = endDevice.getInputs().get(1);
					} else {
						input = endDevice.getInputs().get(0);
					}
					veza.setKranji(endDevice);
					veza.setInput(input);
					veza.setPainter(veza);
					veza = null;
				} else {
					slot.getModel().removeElement(veza);
					veza = null;
				}
			} else {
				veza.getPoints().add(position);
			}
		}
		view.repaint();
	}
}
