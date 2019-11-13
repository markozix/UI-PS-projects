package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class VukicevicReport implements ActionListener {

	private JTextField unos;
	
	public VukicevicReport(JTextField unos) {
		this.unos = unos;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String text = unos.getText();
		String[] ps = text.split(",");
		Map<String, Object> Params = new HashMap<>();
		Params.put("polje1", ps[0]);
		Params.put("polje2", ps[1]);

		try {
			JasperDesign japerDesign = JRXmlLoader.load("MarkoReport.jrxml");

			JasperReport jasperReport = JasperCompileManager.compileReport(japerDesign);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, Params,
					MainFrame.getInstance().getConnection());

			String name = "MV.pdf";
			FileOutputStream stream = new FileOutputStream(name);
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

		} catch (JRException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
