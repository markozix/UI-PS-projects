package view;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class SlotViewSelection implements Transferable{

	static public DataFlavor elef;

	private DataFlavor[] supported = { elef };
	public ArrayList<SlotView> slotovi = new ArrayList<SlotView>();

	public SlotViewSelection(ArrayList<SlotView> slotovi) {
		this.slotovi = slotovi;
		try {
			elef = new DataFlavor(Class.forName("java.util.ArrayList"), "Slotovi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if (flavor.equals(elef))
			return (slotovi);
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
