package model;

public class GrafickiSlot extends Slot {

	public GrafickiSlot(String naziv) {
		super(naziv);
	}

	public GrafickiSlot(GrafickiSlot gs) {
		super(gs.getNaziv());
	}
}
