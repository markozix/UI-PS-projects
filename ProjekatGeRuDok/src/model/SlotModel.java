package model;

import java.awt.Point; 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.event.EventListenerList;

import event.UpdateEvent;
import event.UpdateListener;

public class SlotModel implements Serializable {

	private String naziv;
	private ArrayList<Element> elementi;
	private transient EventListenerList listenerList = new EventListenerList();
	private transient UpdateEvent updateEvent = null;
	
	private Object readResolve() {
		listenerList = new EventListenerList();
		updateEvent = null;
		return this;
	}
	
	public SlotModel() {
		elementi = new ArrayList<>();
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
	
	public UpdateEvent getUpdateEvent() {
		return updateEvent;
	}
	
	public EventListenerList getListenerList() {
		return listenerList;
	}

	public void setListenerList(EventListenerList listenerList) {
		this.listenerList = listenerList;
	}
	
	public void addElement(Element element) {
		elementi.add(element);
		fireUpdatePerformed();
	}
	
	public void removeElement(Element element) {
		elementi.remove(element);
		fireUpdatePerformed();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public Iterator<Element> getDeviceIterator(){
		return elementi.iterator();
	}
	
	public int getElementAtPosition(Point point) {
		for(int i = elementi.size() - 1;i >= 0; i--){
			Element element = elementi.get(i);
			if(element.getElementPainter().isElementAt(point)){
				return i;
			}
		}
		return -1;
	}
	
	public void addUpdateListener(UpdateListener l) {
		listenerList.add(UpdateListener.class, l);
	}
	public void removeUpdateListener(UpdateListener l) {
		listenerList.add(UpdateListener.class, l);
	}
	
	public int getDeviceAtPosition(Point point) {
		for(int i = elementi.size() - 1; i >= 0; i--) {
			Element element = elementi.get(i);
			if(element.getElementPainter().isElementAt(point)) {
				return i;
			}
		}
		return -1;
	}
	
	public void fireUpdatePerformed() {
//<<<<<<< .mine
//		Object[] listeners = listenerList.getListenerList();
//		for(int i = listeners.length-1; i>=0; i--) {
//			if(updateEvent == null) {
//				updateEvent = new UpdateEvent(this);
//				((UpdateListener)listeners[i+1]).updatePerformed(updateEvent);
//			}
//		}
		
		Object[] listener = listenerList.getListenerList();
		for(int i = listener.length - 2; i >= 0; i -= 2) {
			if(listener[i] == UpdateListener.class) {
				if(updateEvent == null) {
					updateEvent = new UpdateEvent(this);
				}
				((UpdateListener)listener[i + 1]).updatePerformed(updateEvent);
			}
		}

	}
}
