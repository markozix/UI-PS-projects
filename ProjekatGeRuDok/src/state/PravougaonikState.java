package state;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import komande.AddDeviceCommand;
import main.MainFrame;
import model.PravougaonikElement;
import model.Slot;
import model.SlotDevice;
import view.DokumentView;
import view.ProjekatView;
import view.SlotView;
import view.StranicaView;

public class PravougaonikState extends State {

	private Slot slot;
	
	public PravougaonikState(Slot slot) {
		this.slot = slot;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(slot.getModel().getDeviceAtPosition(position) == -1) {
				slot.getCommandManager().addCommand(new AddDeviceCommand(slot.getModel(),
						position, slot.getSelectionModel(), SlotView.RECTANGLE));
			}
		}
	}


}
