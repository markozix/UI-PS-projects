package state;

import model.Slot;
import view.SlotView;

public class StateManager {

	private State trenutnoStanje;
	private KrugState krugStanje;
	private PravougaonikState pravougaonikStanje;
	private TrougaoState trougaoStanje;
	private LinijaState linijaStanje;
	private SelectState selectStanje;
	private LassoState lassoStanje;
	private MoveState moveStanje;
	
	public StateManager(Slot slot) {
		krugStanje = new KrugState(slot);
		pravougaonikStanje = new PravougaonikState(slot);
		trougaoStanje = new TrougaoState(slot);
		linijaStanje = new LinijaState(slot);
		selectStanje = new SelectState(slot);
		lassoStanje = new LassoState(slot);
		moveStanje = new MoveState(slot);
		trenutnoStanje = selectStanje;
	}

	public State getTrenutnoStanje() {
		return trenutnoStanje;
	}

	public void setKrugStanje() {
		trenutnoStanje = krugStanje;
	}

	public void setPravougaonikStanje() {
		trenutnoStanje = pravougaonikStanje;
	}

	public void setTrougaoStanje() {
		trenutnoStanje = trougaoStanje;
	}

	public void setLinijaStanje() {
		trenutnoStanje = linijaStanje;
	}
	
	public void setSelectStanje() {
		trenutnoStanje = selectStanje;
	}
	
	public void setLassoStanje() {
		trenutnoStanje = lassoStanje;
	}
	
	public void setMoveStanje() {
		trenutnoStanje = moveStanje;
	}
	
}
