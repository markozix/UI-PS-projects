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
import main.MatovicWindow;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class MatkeReport implements ActionListener {

	private JTextField unos;

	public MatkeReport(JTextField unos) {
		this.unos = unos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = unos.getText();
		String[] drzave = text.split(",");
		Map<String, Object> Params = new HashMap<>();
		Params.put("markoParam1", drzave[0]);
		Params.put("markoParam2", drzave[1]);
		Params.put("markoParam3", drzave[2]);
		try {
			JasperDesign japerDesign = JRXmlLoader.load("markom.jrxml");

			JasperReport jasperReport = JasperCompileManager.compileReport(japerDesign);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, Params,
					MainFrame.getInstance().getConnection());

			String name = "Matke.pdf";
			FileOutputStream stream = new FileOutputStream(name);
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "Matke.pdf");
		} catch (JRException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
