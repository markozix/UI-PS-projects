package painter;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;

import model.Element;
import model.InputOutputElement;

public class InputOutputPainter extends DevicePainter {
	
	public InputOutputPainter(InputOutputElement ioElement) {
		super(ioElement);
		shape=new GeneralPath();
		if (ioElement.getType()==InputOutputElement.INPUT){
 	           	((GeneralPath)shape).moveTo(ioElement.getPosition().getX(),ioElement.getPosition().getY());
                ((GeneralPath)shape).lineTo(ioElement.getPosition().getX()-5,ioElement.getPosition().getY());
		}else if (ioElement.getType()==InputOutputElement.OUTPUT){
			    ((GeneralPath)shape).moveTo(ioElement.getPosition().getX(),ioElement.getPosition().getY());
                ((GeneralPath)shape).lineTo(ioElement.getPosition().getX()+5,ioElement.getPosition().getY());
        }
	}

}
