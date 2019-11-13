package model;

public class TekstualniSlot extends Slot {

	public TekstualniSlot(String naziv) {
		super(naziv);

	}

	public TekstualniSlot(TekstualniSlot ts) {
		super(ts.getNaziv());
	}
}
