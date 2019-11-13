package akcije;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import main.MainFrame;
import model.Dokument;
import model.DokumentSelection;
import model.Projekat;
import model.Stranica;
import model.StranicaSelection;
import view.DokumentView;
import view.DokumentViewSelection;
import view.ProjekatView;
import view.SlotView;
import view.SlotViewSelection;
import view.StranicaView;
import view.StranicaViewSelection;
import model.Slot;
import model.SlotSelection;

public class CopyAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		Object o2 = MainFrame.getInstance().getPTree().getLastSelectedPathComponent();
		if (o instanceof Dokument) {
			Dokument d = (Dokument) o;
			ArrayList<Dokument> tmp = new ArrayList<>();
			tmp.add(d);
			DokumentSelection content = new DokumentSelection(tmp);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);
			return;
		}
		if (o instanceof Stranica) {
			Stranica s = (Stranica) o;
			ArrayList<Stranica> tmp = new ArrayList<>();
			tmp.add(s);
			StranicaSelection content = new StranicaSelection(tmp);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);
			return;
		}
		if (o instanceof Slot) {
			Slot s = (Slot) o;
			ArrayList<Slot> tmp = new ArrayList<>();
			tmp.add(s);
			SlotSelection content = new SlotSelection(tmp);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);
			return;
		}
		if(o2 instanceof Dokument) {
			Dokument d = (Dokument) o2;
			ArrayList<Dokument> tmp = new ArrayList<>();
			tmp.add(d);
			DokumentSelection content = new DokumentSelection(tmp);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);
			return;
		}
		if(o2 instanceof Stranica) {
			Stranica s = (Stranica) o2;
			ArrayList<Stranica> tmp = new ArrayList<>();
			tmp.add(s);
			StranicaSelection content = new StranicaSelection(tmp);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);
			return;
		}
		if(o2 instanceof Slot) {
			Slot s = (Slot) o2;
			ArrayList<Slot> tmp = new ArrayList<>();
			tmp.add(s);
			SlotSelection content = new SlotSelection(tmp);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);
			return;
		}
	}

}
