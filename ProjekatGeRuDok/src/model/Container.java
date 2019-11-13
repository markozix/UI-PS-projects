package model;

import event.UpdateEvent;

public interface Container {
	public void add(Object dete);

	public void remove(Object dete);

	
	
	// sve klase koje ga implementiraju su Container-i, sadrze druge komponente
}
