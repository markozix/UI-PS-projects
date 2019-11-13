package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.event.EventListenerList;
import javax.swing.tree.TreeNode;

import event.UpdateEvent;
import event.UpdateListener;
import komande.CommandManager;
import state.StateManager;
import view.SlotView;

public class Slot implements Container, TreeNode, Serializable {

	private String naziv;
	private ArrayList<Element> elementi;
	private SlotModel model;
	private SlotSelectionModel selectionModel;
	private transient EventListenerList listenerList;
	private transient UpdateEvent updateEvent = null;
	private transient StateManager stateManager;
	private transient CommandManager commandManager;

	public Slot(String naziv) {
		this.naziv = naziv;
		model = new SlotModel();
		elementi = new ArrayList<>();
		selectionModel = new SlotSelectionModel();
		stateManager = new StateManager(this);
		commandManager = new CommandManager();
		listenerList = new EventListenerList();
	}

	public Slot(Slot s) {
		this.naziv = s.naziv;
		model = s.model;
		elementi = s.elementi;
		selectionModel = s.selectionModel;
		stateManager = s.stateManager;
		commandManager = s.commandManager;
		listenerList = s.listenerList;
	}

	private Object readResolve() {
		listenerList = new EventListenerList();
		updateEvent = null;
		stateManager = new StateManager(this);
		commandManager = new CommandManager();
		return this;
	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public void setCommandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}

	public StateManager getStateManager() {
		return stateManager;
	}

	public void setStateManager(StateManager stateManager) {
		this.stateManager = stateManager;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public ArrayList<Element> getElementi() {
		return elementi;
	}

	public void setElementi(ArrayList<Element> elementi) {
		this.elementi = elementi;
	}

	public EventListenerList getListenerList() {
		return listenerList;
	}

	public void setListenerList(EventListenerList listenerList) {
		this.listenerList = listenerList;
	}

	@Override
	public void add(Object dete) {
		if (dete instanceof Element) {
			elementi.add((Element) dete);
		}

	}

	@Override
	public void remove(Object dete) {
		if (dete instanceof Element) {
			elementi.remove((Element) dete);
		}
	}

	@Override
	public Enumeration children() {
		return (Enumeration<Element>) elementi;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return elementi.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return elementi.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return elementi.indexOf((Element) node);
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public boolean isLeaf() {
		return elementi.isEmpty();
	}

	public SlotModel getModel() {
		return model;
	}

	public void setModel(SlotModel model) {
		this.model = model;
	}

	public SlotSelectionModel getSelectionModel() {
		return selectionModel;
	}

	public void setSelectionModel(SlotSelectionModel selectionModel) {
		this.selectionModel = selectionModel;
	}

	public void fireUpdatePerformed() {
		Object[] listener = listenerList.getListenerList();
		for (int i = listener.length - 2; i >= 0; i -= 2) {
			if (listener[i] == UpdateListener.class) {
				if (updateEvent == null) {
					updateEvent = new UpdateEvent(this);
				}
				((UpdateListener) listener[i + 1]).updatePerformed(updateEvent);
			}
		}
	}

	@Override
	public String toString() {
		return naziv;
	}

}
