package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.event.EventListenerList;
import javax.swing.tree.TreeNode;

import event.UpdateEvent;
import event.UpdateListener;

public class Dokument implements Container, TreeNode, Serializable {

	private String naziv;
	private ArrayList<Stranica> stranice;
	private transient EventListenerList listenerList = new EventListenerList();
	private transient UpdateEvent updateEvent = null;

	public Dokument(String naziv) {
		this.naziv = naziv;
		stranice = new ArrayList<>();
	}

	public Dokument(Dokument d) {
		this.naziv = d.naziv;
		stranice = d.getStranice();
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

	public ArrayList<Stranica> getStranice() {
		return stranice;
	}

	public void setStranice(ArrayList<Stranica> stranice) {
		this.stranice = stranice;
	}

	public EventListenerList getListenerList() {
		return listenerList;
	}

	public void setListenerList(EventListenerList listenerList) {
		this.listenerList = listenerList;
	}

	@Override
	public Enumeration children() {
		return (Enumeration<Stranica>) stranice;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return stranice.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return stranice.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return stranice.indexOf((Stranica) node);
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public boolean isLeaf() {
		return stranice.isEmpty();
	}

	@Override
	public void add(Object dete) {
		if (dete instanceof Stranica) {
			stranice.add((Stranica) dete);
		}

	}

	@Override
	public void remove(Object dete) {
		if (dete instanceof Stranica) {
			stranice.remove((Stranica) dete);
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
