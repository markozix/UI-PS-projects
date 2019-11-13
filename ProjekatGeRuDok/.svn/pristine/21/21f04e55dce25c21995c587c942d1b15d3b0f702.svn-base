package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.event.EventListenerList;
import javax.swing.tree.TreeNode;

import event.UpdateEvent;
import event.UpdateListener;

public class Stranica implements Container, TreeNode, Serializable {

	private String naziv;
	private ArrayList<Slot> slotovi;
	private transient EventListenerList listenerList = new EventListenerList();
	private transient UpdateEvent updateEvent = null;

	public Stranica(String naziv) {
		this.naziv = naziv;
		slotovi = new ArrayList<>();
	}

	public Stranica(Stranica s) {
		this.naziv = s.naziv;
		slotovi = s.slotovi;
	}

	private Object readResolve() {
		listenerList = new EventListenerList();
		updateEvent = null;
		return this;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public ArrayList<Slot> getSlotovi() {
		return slotovi;
	}

	public void setSlotovi(ArrayList<Slot> slotovi) {
		this.slotovi = slotovi;
	}

	public EventListenerList getListenerList() {
		return listenerList;
	}

	public void setListenerList(EventListenerList listenerList) {
		this.listenerList = listenerList;
	}

	@Override
	public Enumeration children() {
		return (Enumeration<Slot>) slotovi;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return slotovi.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return slotovi.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return slotovi.indexOf((Slot) node);
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public boolean isLeaf() {
		return slotovi.isEmpty();
	}

	@Override
	public void add(Object dete) {
		if (dete instanceof Slot) {
			slotovi.add((Slot) dete);
		}

	}

	@Override
	public void remove(Object dete) {
		if (dete instanceof Slot) {
			slotovi.remove((Slot) dete);
		}
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
