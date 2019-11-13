package painter;




import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.io.Serializable;
import java.util.Iterator;

import model.Element;
import model.InputOutputElement;
import model.KrugElement;
import model.PravougaonikElement;
import model.SlotDevice;
import model.TrougaoElement;

public abstract class DevicePainter extends ElementPainter implements Serializable {
	
	protected Shape shape;
	
	public DevicePainter(Element element){
		super(element);
	}
	
	public void paint(Graphics2D g, Element element){
		if(element instanceof PravougaonikElement) {
			element.setElementPainter(new PravougaonikPainter(element));
		} else if(element instanceof KrugElement) {
			element.setElementPainter(new KrugPainter(element));
		} else if(element instanceof TrougaoElement) {
			element.setElementPainter(new TrougaoPainter(element));
		} else if(element instanceof InputOutputElement) {
			element.setElementPainter(new InputOutputPainter((InputOutputElement)element));
		}
		
		if (element instanceof SlotDevice){
			  SlotDevice device=(SlotDevice)element;
			  //ako se iscrtava element, trebaju da se iscrtaju i njegovi ulazi i izlazi 
  	   		  Iterator it = device.getInputs().iterator();
			  while(it.hasNext()){
				    InputOutputElement d = (InputOutputElement) it.next();
				    d.getElementPainter().paint(g,d);
   			  } 
			  Iterator it2 = device.getOutputs().iterator();
			  while(it2.hasNext()){
				    InputOutputElement d2 = (InputOutputElement) it2.next();
				    d2.getElementPainter().paint(g,d2);
		     }	
			  
			  g.setPaint(Color.BLACK);
			  g.drawString(device.getNaziv(), (int)device.getPosition().getX()+10, 
											   (int)device.getPosition().getY()+(int)device.getSize().getHeight()/2);
		}
		
		//ovaj deo iscrtava element i linkove
		
		g.setPaint(element.getStrokeColor());
		g.setStroke(element.getStrokeAdapter());
		g.draw(getShape());

		
		g.setPaint(element.getPaint());
		g.fill(getShape());	
		
	}
	
	@Override
	public boolean isElementAt(Point pos) {
		return getShape().contains(pos);
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
