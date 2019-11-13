package state;

public class StateManager {

	private State trenutnoStanje;
	private AddState addState;
	private DeleteState deleteState;
	private DetailState detailState;
	private RelacijaState relacijaState;
	private SearchState seatchState;
	private UpdateState updateState;
	
	public StateManager() {
		addState = new AddState();
		deleteState = new DeleteState();
		detailState = new DetailState();
		relacijaState = new RelacijaState();
		seatchState = new SearchState();
		updateState = new UpdateState();
		trenutnoStanje = detailState;
	}
	
	public State getTrenutnoStanje() {
		return trenutnoStanje;
	}
	
	public void setAddState() {
		trenutnoStanje = addState;
	}
	
	public void setDeleteState() {
		trenutnoStanje = deleteState;
	}
	
	public void setDetailState() {
		trenutnoStanje = detailState;
	}
	
	public void setRelacijaState() {
		trenutnoStanje = relacijaState;
	}
	
	public void setSearchState() {
		trenutnoStanje = seatchState;
	}
	
	public void setUpdateState() {
		trenutnoStanje = updateState;
	}
}
