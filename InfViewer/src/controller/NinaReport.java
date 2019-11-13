package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;

import main.MainFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class NinaReport implements ActionListener {

	private JTextField unos;

	public NinaReport(JTextField unos) {
		this.unos = unos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String tekst = unos.getText();
		String[] regioni = tekst.split(",");
		Map<String, Object> Parametar = new HashMap<>();
		Parametar.put("nina1", regioni[0]);
		Parametar.put("nina2", Integer.parseInt(regioni[1]));

		try {
			JasperDesign japerDesign = JRXmlLoader.load("nina.jrxml");

			JasperReport jasperReport = JasperCompileManager.compileReport(japerDesign);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, Parametar,
					MainFrame.getInstance().getConnection());

			String name = "Nina.pdf";
			FileOutputStream stream = new FileOutputStream(name);
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "Nina.pdf");
		} catch (JRException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
