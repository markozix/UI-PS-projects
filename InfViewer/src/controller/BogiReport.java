package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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

public class BogiReport implements ActionListener {

	private JTextField unos;

	public BogiReport(JTextField unos) {
		this.unos = unos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String idFirme = unos.getText();
		Map<String, Object> mpParams = new HashMap<>();
		mpParams.put("BakiParam", Integer.parseInt(idFirme));

		try {
			JasperDesign japerDesign = JRXmlLoader.load("Bogdan.jrxml");

			JasperReport jasperReport = JasperCompileManager.compileReport(japerDesign);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mpParams,
					MainFrame.getInstance().getConnection());

			String name = "Bogi.pdf";
			FileOutputStream stream = new FileOutputStream(name);
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			// JasperViewer.viewReport(jasperPrint);

//			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "Bogi.pdf");
		} catch (JRException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
