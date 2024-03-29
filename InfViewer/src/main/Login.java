package main;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

import org.json.JSONObject;
import org.json.JSONTokener;

import modeli.Atribut;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Paket;
import modeli.Relacija;

public class Login extends JDialog {
	private JLabel lServerName = new JLabel("Server Name:");
	private JLabel lLogin = new JLabel("Login:");
	private JLabel lPass = new JLabel("Password:");
	private JTextField tServerName = new JTextField("147.91.175.155");
	private JTextField tLogin = new JTextField("ui-2017-tim202.1");
	private JTextField tPass = new JTextField("tim202.1habc23");

	private JButton btConnect = new JButton("Connect");
	private JButton btCancel = new JButton("Cancel");

	public Login() {
		setLayout(new GridLayout(6, 1));
		JPanel pan1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pan1.add(lServerName);
		pan1.add(tServerName);
		add(pan1);

		JPanel pan2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pan2.add(lLogin);
		pan2.add(tLogin);
		add(pan2);

		JPanel pan3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pan3.add(lPass);
		pan3.add(tPass);
		add(pan3);

		btConnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				File fajl = new File("Baza.json");
				BufferedReader br;
				try {
					br = new BufferedReader(new InputStreamReader(new FileInputStream(fajl)));
					JSONTokener tokener = new JSONTokener(br);
					JSONObject inf = new JSONObject(tokener);
					br.close();
					InformacioniResurs resurs = new InformacioniResurs();
					resurs.setNaziv(inf.getString("name"));
					MainFrame.getInstance().getTree().addInformacioniResurs(resurs);
					if (inf.has("paketi")) {
						for (int k = 0; k < inf.getJSONArray("paketi").length(); k++) {
							JSONObject pak = inf.getJSONArray("paketi").getJSONObject(k);
							Paket paket = new Paket();
							paket.setNaziv(pak.getString("name"));
							if (pak.has("entities")) {
								for (int i = 0; i < pak.getJSONArray("entities").length(); i++) {
									JSONObject ent = pak.getJSONArray("entities").getJSONObject(i);
									Entitet entitet = new Entitet();
									entitet.setPath(ent.getString("path"));
									entitet.setName(ent.getString("name"));
									if (ent.has("atributes")) {
										for (int j = 0; j < ent.getJSONArray("atributes").length(); j++) {
											JSONObject atr = ent.getJSONArray("atributes").getJSONObject(j);
											Atribut atribut = new Atribut();
											atribut.setName(atr.getString("name"));
											atribut.setDuzina(atr.getInt("length"));
											atribut.setKey(atr.getBoolean("isKey"));
											atribut.setType(atr.getString("type"));
											atribut.setRequired(atr.getBoolean("required"));
											entitet.add(atribut);
										}
									}
									if (ent.has("relations")) {
										for (int j = 0; j < ent.getJSONArray("relations").length(); j++) {
											JSONObject rel = ent.getJSONArray("relations").getJSONObject(j);
											Relacija relacija = new Relacija();
											relacija.setAtribut1(rel.getString("atribut1"));
											relacija.setAtribut2(rel.getString("atribut2"));
											relacija.setEntitet(rel.getString("entitet"));
											entitet.getRelacije().add(relacija);
										}
									}
									paket.add(entitet);
								}
							}
							resurs.add(paket);
						}
					}
					Class.forName("net.sourceforge.jtds.jdbc.Driver");
					MainFrame.getInstance().setConnection(
							DriverManager.getConnection("jdbc:jtds:sqlserver://147.91.175.155/ui-2017-tim202.1",
									"ui-2017-tim202.1", "tim202.1habc23"));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setVisible(false);
			}
		});

		btCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		JPanel pan4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pan4.add(btConnect);
		pan4.add(btCancel);
		add(pan4);

		setModal(true);
		setSize(250, 250);
		setLocationRelativeTo(null);
		setTitle("Connect to Server");
		setVisible(true);
	}

}
