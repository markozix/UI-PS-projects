package painter;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;


import model.Element;
import model.PravougaonikElement;

public class PravougaonikPainter extends DevicePainter {

	public PravougaonikPainter(Element device) {
		super(device);
		PravougaonikElement pravougaonik = (PravougaonikElement) device;
		
		shape = new GeneralPath();
		((GeneralPath)shape).moveTo(pravougaonik.getPosition().getX(), pravougaonik.getPosition().getY());
		
		((GeneralPath)shape).lineTo(pravougaonik.getPosition().getX()+pravougaonik.getSize().width,pravougaonik.getPosition().getY());
		
		((GeneralPath)shape).lineTo(pravougaonik.getPosition().getX()+pravougaonik.getSize().width,pravougaonik.getPosition().getY()+pravougaonik.getSize().height);
		
		((GeneralPath)shape).lineTo(pravougaonik.getPosition().getX(),pravougaonik.getPosition().getY()+pravougaonik.getSize().height);
		
		((GeneralPath)shape).closePath();
		
	}

}
