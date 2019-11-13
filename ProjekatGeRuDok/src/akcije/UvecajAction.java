package akcije;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class UvecajAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
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
		Iterator<Element> it = slot.getSelectionModel().getSelectionList().iterator();
		while(it.hasNext()) {
			Element element = it.next();
			SlotDevice device;
			if(element instanceof SlotDevice) {
				device = (SlotDevice)element;
			} else {
				return;
			}
			device.setSize(new Dimension((int)device.getSize().getWidth() + 2, (int)device.getSize().getHeight() + 2));
			Iterator<InputOutputElement> it2 = device.getInputs().iterator();
			int i = 0;
			while(it2.hasNext()) {
				Point2D ioPos = new Point2D.Double(device.getPosition().getX(), device.getPosition().getY() + 
						(device.getSize().getHeight() / (device.getBrIn() + 1)) * (i + 1));
				InputOutputElement ioe = it2.next();
				ioe.setPosition(ioPos);
				view.repaint();
				i++;
			}
			it2 = device.getOutputs().iterator();
			i = 0;
			while(it2.hasNext()) {
				Point2D ioPos = new Point2D.Double(device.getPosition().getX() + device.getSize().getWidth(), device.getPosition().getY() + 
						device.getSize().getHeight() / 2);
				InputOutputElement ioe = it2.next();
				ioe.setPosition(ioPos);
				view.repaint();
				i++;
			}
		}
		view.repaint();
	}

}
