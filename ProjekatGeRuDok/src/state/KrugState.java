package state;

import java.awt.Point;
import java.awt.event.MouseEvent;import komande.AddDeviceCommand;
import model.KrugElement;
import model.Slot;
import model.SlotDevice;
import view.SlotView;

public class KrugState extends State {
	private Slot slot;
	
	public KrugState(Slot slot) {
		this.slot = slot;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(slot.getModel().getDeviceAtPosition(position) == -1) {
				slot.getCommandManager().addCommand(new AddDeviceCommand(slot.getModel(),
						position, slot.getSelectionModel(), SlotView.CIRCLE));
			}
		}
	}


}
