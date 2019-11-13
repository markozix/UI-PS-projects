package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.DefaultEditorKit.CopyAction;
import javax.swing.text.DefaultEditorKit.PasteAction;

import event.UpdateEvent;
import event.UpdateListener;
import model.Slot;
import akcije.TekstOkAction;;

public class EditorTView extends JInternalFrame {

	static int openFrameCount = 0;

	static final int xOffset = 30, yOffset = 30;

	private Slot slot;

	private JPanel framework;

	private JTextPane editor;
	private JTextPane parent;

	public EditorTView(JTextPane otac) {
		super("Teksutalni editor", true, true, true, true);
		this.editor = new JTextPane();
		this.editor.setDocument(otac.getDocument());
		++openFrameCount;
		setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
		setSize(new Dimension(500, 500));
		JButton btCopy = new JButton("Copy");
		btCopy.addActionListener(new CopyAction());
		JButton btPaste = new JButton("Paste");
		btPaste.addActionListener(new PasteAction());
		JButton btBold = new JButton("Bold");
		btBold.addActionListener(new StyledEditorKit.BoldAction());
		JButton btItalic = new JButton("Italic");
		btItalic.addActionListener(new StyledEditorKit.ItalicAction());
		JButton btUnderline = new JButton("Underline");
		btUnderline.addActionListener(new StyledEditorKit.UnderlineAction());

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(btCopy);
		panel.add(btPaste);
		panel.add(btBold);
		panel.add(btItalic);
		panel.add(btUnderline);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.add(panel);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new TekstOkAction(otac, this.editor, this));

		this.add(panel2, BorderLayout.NORTH);
		this.add(this.editor, BorderLayout.CENTER);
		this.add(btOk, BorderLayout.SOUTH);

		setVisible(true);
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

}
