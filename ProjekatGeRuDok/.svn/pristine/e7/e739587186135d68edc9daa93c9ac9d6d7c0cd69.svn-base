package model;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultSingleSelectionModel;
import javax.swing.event.EventListenerList;

import event.UpdateEvent;
import event.UpdateListener;
import painter.LinijaPainter;

public class SlotSelectionModel extends DefaultSingleSelectionModel {

	public ArrayList<Element> selectionList = new ArrayList<>();
	private transient EventListenerList listaListenera = new EventListenerList();
	private transient UpdateEvent updateEvent;
	
	private Object readResolve() {
		listaListenera = new EventListenerList();
		updateEvent = null;
		return this;
	}
	
	public void addToSelectionList(Element element) {
		selectionList.add(element);
		fireUpdatePerformed();
	}
	
	public void addToSelectionList(ArrayList<Element> list) {
		selectionList.addAll(list);
		fireUpdatePerformed();
	}

	public Element getElementFromSelectionListAt(int index) {
		return (Element)selectionList.get(index);
	}
	
	public void removeFromSelectionList(Element element) {
		selectionList.remove(element);
		fireUpdatePerformed();
	}
	
	public void removeAllFromSelectionList() {
		selectionList.clear();
		fireUpdatePerformed();
	}
	
	public ArrayList<Element> getSelectionList() {
		return selectionList;
	}
	
	public boolean isElementSelected(Element element){
		return selectionList.contains(element);
	}

	public void izaberiElemente(Rectangle2D pravougaonik, ArrayList<Element> elementi) {
		Iterator<Element> it = elementi.iterator();
		while(it.hasNext()) {
			Element element = it.next();
			if(element instanceof SlotDevice) {
				SlotDevice device = (SlotDevice) element;
				if(pravougaonik.intersects(device.getPosition().getX(), device.getPosition().getY(), device.getSize().
						getWidth(), device.getSize().getHeight())) {
					if(!isElementSelected(device)) {
						selectionList.add(device);
					}
				}
			} else {
				LinijaElement linija = (LinijaElement)element;
				if(pravougaonik.contains(LinijaPainter.findRectangle(linija))) {
					if(!isElementSelected(linija)) {
						selectionList.add(linija);
					}
				}
			}
		}
	}
	
	public EventListenerList getListaListenera() {
		return listaListenera;
	}

	public void setListaListenera(EventListenerList listaListenera) {
		this.listaListenera = listaListenera;
	}

	public void fireUpdatePerformed() {
		Object[] listeners = listaListenera.getListenerList();
	     for (int i = listeners.length-2; i>=0; i-=2) {
	         if (listeners[i]==UpdateListener.class) {
	             if (updateEvent == null)
	                 updateEvent = new UpdateEvent(this);
	             ((UpdateListener)listeners[i+1]).updatePerformed(updateEvent);
	         }
	     }
	}
}
