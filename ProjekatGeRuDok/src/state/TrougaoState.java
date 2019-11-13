package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import komande.AddDeviceCommand;
import model.PravougaonikElement;
import model.Slot;
import model.SlotDevice;
import model.TrougaoElement;
import view.SlotView;

public class TrougaoState extends State {

	private Slot slot;

	public TrougaoState(Slot slot) {
		this.slot = slot;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(slot.getModel().getDeviceAtPosition(position) == -1) {
				slot.getCommandManager().addCommand(new AddDeviceCommand(slot.getModel(),
						position, slot.getSelectionModel(), SlotView.TROUGAO));
			}
		}
	}

}
