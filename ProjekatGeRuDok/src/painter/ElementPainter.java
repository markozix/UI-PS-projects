package painter;




import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.io.Serializable;

import model.Element;




public abstract class ElementPainter implements Serializable {

	protected Element element;
	
	public ElementPainter(Element element) {
		this.element = element;
	}

	public abstract void paint(Graphics2D g, Element element);
	
	public abstract boolean isElementAt(Point pos);


}
