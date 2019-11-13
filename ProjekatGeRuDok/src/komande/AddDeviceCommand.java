package komande;

import java.awt.geom.Point2D;
import java.util.Iterator;

import main.MainFrame;
import model.Element;
import model.InputOutputElement;
import model.KrugElement;
import model.LinijaElement;
import model.PravougaonikElement;
import model.Slot;
import model.SlotDevice;
import model.SlotModel;
import model.SlotSelectionModel;
import model.TrougaoElement;
import view.SlotView;

public class AddDeviceCommand extends AbstractCommand {

	private SlotModel model;
	private Point2D lastPos;
	private Element element;
	private SlotSelectionModel selectionModel;
	private int tip;
	
	
	public AddDeviceCommand(SlotModel model, Point2D lastPos, SlotSelectionModel selectionModel, int tip) {
		this.model = model;
		this.lastPos = lastPos;
		this.selectionModel = selectionModel;
		this.tip = tip;
	}


	@Override
	public void doCommand() {
		if (element == null)
			if (tip == SlotView.CIRCLE){
				element = KrugElement.napraviCustom(lastPos, model.getElementi().size());
			}else if (tip == SlotView.RECTANGLE){
				element = PravougaonikElement.napraviCustom(lastPos, model.getElementi().size());
			} else if(tip == SlotView.TROUGAO) {
				element = TrougaoElement.napraviCustom(lastPos, model.getElementi().size());
			}
			
		selectionModel.removeAllFromSelectionList();
		model.addElement(element);
		selectionModel.addToSelectionList(element);
	}


	@Override
	public void undoCommand() {
		selectionModel.removeAllFromSelectionList();
		model.removeElement(element);
		SlotDevice device = (SlotDevice)element;
		for(InputOutputElement io : device.getInputs()) {
			model.removeElement(io);
		}
		for(InputOutputElement io : device.getOutputs()) {
			model.removeElement(io);
		}
		Iterator<Element> it = model.getElementi().iterator();
		while(it.hasNext()) {
			Element linija = it.next();
			if(linija instanceof LinijaElement) {
				if(element instanceof SlotDevice) {
					SlotDevice tmp = (SlotDevice)element;
					if(tmp.equals(((LinijaElement) linija).getPocetni())) {
						model.removeElement(linija);
					} else {
						if(tmp.equals(((LinijaElement) linija).getKranji())) {
							model.removeElement(linija);
						}
					}
				}
			}
		}
 	}
	
	
}
