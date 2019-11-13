package akcije;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import main.MainFrame;
import model.Element;
import model.LinijaElement;
import model.Slot;
import model.SlotDevice;

public class UkloniElementAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Slot slot = (Slot)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		slot.getStateManager().setSelectStanje();
		if(!slot.getSelectionModel().getSelectionList().isEmpty()) {
			Iterator<Element> it = slot.getSelectionModel().getSelectionList().iterator();
			while(it.hasNext()) {
				Element element = it.next();
				slot.getModel().removeElement(element);
				Iterator<Element> i2 = slot.getModel().getElementi().iterator();
				while(i2.hasNext()) {
					Element linija = i2.next();
					if(linija instanceof LinijaElement) {
						if(element instanceof SlotDevice) {
							SlotDevice tmp = (SlotDevice)element;
							if(tmp.equals(((LinijaElement) linija).getPocetni())) {
								slot.getModel().removeElement(linija);
							} else {
								if(tmp.equals(((LinijaElement) linija).getKranji())) {
									slot.getModel().removeElement(linija);
								}
							}
						}
					}
				}
			}
			slot.getSelectionModel().removeAllFromSelectionList();
		}
	}

}
