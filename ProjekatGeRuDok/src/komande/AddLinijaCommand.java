package komande;

import model.LinijaElement;
import model.Slot;
import model.SlotSelectionModel;

public class AddLinijaCommand extends AbstractCommand{

	private Slot model;
	private LinijaElement element;
	private SlotSelectionModel selectionModel;
	private boolean first = true;
	
	public AddLinijaCommand(Slot model, LinijaElement element, SlotSelectionModel selectionModel, boolean first) {
		super();
		this.model = model;
		this.element = element;
		this.selectionModel = selectionModel;
		this.first = first;
	}

	@Override
	public void doCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undoCommand() {
		// TODO Auto-generated method stub
		
	}

}
