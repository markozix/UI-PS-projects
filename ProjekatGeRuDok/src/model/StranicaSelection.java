package model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class StranicaSelection implements Transferable {

	static public DataFlavor elef;

	private DataFlavor[] supported = { elef };
	public ArrayList<Stranica> stranice = new ArrayList<Stranica>();

	public StranicaSelection(ArrayList<Stranica> stranice) {
		this.stranice = stranice;
		try {
			elef = new DataFlavor(Class.forName("java.util.ArrayList"), "Stranice");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if (flavor.equals(elef))
			return (stranice);
		else
			throw new UnsupportedFlavorException(elef);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return supported;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return (flavor.equals(elef));
	}
}
