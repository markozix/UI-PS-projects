package main;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.BogdanReport;
import controller.ConnectSQL;
import controller.Export;
import controller.GenerateScheme;
import controller.Import;
import controller.MarkoMReport;
import controller.NinaReport;
import controller.NinaaReport;
import controller.OtvoriEditor;
import controller.VukicevicccReport;

public class MyToolBar extends JToolBar {

	public MyToolBar() {
		JButton editor = new JButton("Editor");
		JButton export = new JButton("Export");
		JButton importovanje = new JButton("Import");
		JButton konekt = new JButton("Connect");
		JButton genSema = new JButton("Generisi");
		JButton Bogdan = new JButton("Bogdan");
		JButton MarkoM = new JButton("MarkoM");
		JButton Nina = new JButton("Nina");
		JButton MarkoV = new JButton("MarkoV");

		editor.addActionListener(new OtvoriEditor());
		export.addActionListener(new Export());
		importovanje.addActionListener(new Import());
		konekt.addActionListener(new ConnectSQL());
		genSema.addActionListener(new GenerateScheme());
		
		Bogdan.addActionListener(new BogdanReport());
		MarkoM.addActionListener(new MarkoMReport());
		Nina.addActionListener(new NinaaReport());
		MarkoV.addActionListener(new VukicevicccReport());
		add(editor);
		addSeparator(new Dimension(5, 5));
		add(export);
		add(importovanje);
		add(konekt);
		add(genSema);
		add(Bogdan);
		add(MarkoM);
		add(Nina);
		add(MarkoV);
		setFloatable(false);
	}
}
