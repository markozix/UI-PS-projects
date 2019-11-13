package serijalizacija;

import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableStrokeAdapter implements Stroke, Serializable {

	private Stroke stroke;
	
	public SerializableStrokeAdapter(Stroke stroke) {
		this.stroke = stroke;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		if(stroke instanceof BasicStroke) {
			BasicStroke str = (BasicStroke)stroke;
			out.writeFloat(str.getLineWidth());
			out.writeInt(str.getEndCap());
			out.writeInt(str.getLineJoin());
			out.writeFloat(str.getMiterLimit());
			out.writeObject(str.getDashArray());
			out.writeFloat(str.getDashPhase());
		}
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		stroke = new BasicStroke(in.readFloat(), in.readInt(), in.readInt(), in.readFloat(), (float[])in.readObject(),
				in.readFloat());
	}

	@Override
	public Shape createStrokedShape(Shape p) {
		return stroke.createStrokedShape(p);
	}

}
