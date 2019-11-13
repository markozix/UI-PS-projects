package painter;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;


import model.Element;
import model.TrougaoElement;

public class TrougaoPainter extends DevicePainter {

	public TrougaoPainter(Element device) {
		super(device);
		TrougaoElement trougao = (TrougaoElement) device;
		
		shape = new GeneralPath();
		((GeneralPath)shape).moveTo(trougao.getPosition().getX(), trougao.getPosition().getY());
		((GeneralPath)shape).lineTo(trougao.getPosition().getX(), trougao.getPosition().getY() + trougao.getSize().height);
		((GeneralPath)shape).lineTo(trougao.getPosition().getX() + trougao.getSize().width,
				trougao.getPosition().getY() + trougao.getSize().height / 2);
		
		((GeneralPath)shape).closePath();
	}

}
