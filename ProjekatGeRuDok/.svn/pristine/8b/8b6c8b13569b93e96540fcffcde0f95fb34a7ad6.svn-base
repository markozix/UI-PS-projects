package painter;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;


import model.Element;
import model.KrugElement;

public class KrugPainter extends DevicePainter {

	public KrugPainter(Element device) {
		super(device);
		KrugElement or = (KrugElement) device;
		
		shape = new GeneralPath();
		((GeneralPath)shape).moveTo(or.getPosition().getX()+or.getSize().getWidth()/2,or.getPosition().getY());
		
		((GeneralPath)shape).quadTo(or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY(), 
									or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY()+or.getSize().getHeight()/2);
		
		((GeneralPath)shape).quadTo(or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY()+or.getSize().getHeight(),
									or.getPosition().getX()+or.getSize().getWidth()/2, or.getPosition().getY()+or.getSize().getHeight());
		
		((GeneralPath)shape).quadTo(or.getPosition().getX(), or.getPosition().getY()+or.getSize().getHeight(),
				or.getPosition().getX(), or.getPosition().getY()+or.getSize().getHeight()/2);


		((GeneralPath)shape).quadTo(or.getPosition().getX(), or.getPosition().getY(),
				or.getPosition().getX()+or.getSize().getWidth()/2,or.getPosition().getY());
	}

}
