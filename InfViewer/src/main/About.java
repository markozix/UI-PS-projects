package main;

import java.awt.FlowLayout; 
import java.awt.Frame;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class About extends JDialog {
	ImageIcon image1, image2, image3, image4;
	
	public About(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		setSize(500, 500);
		setLocationRelativeTo(null);
//		setVisible(true);
		
		
		JPanel panel = new JPanel();
		JScrollPane sp = new JScrollPane(panel);							
		BoxLayout bl = new BoxLayout(panel, BoxLayout.Y_AXIS);		
		panel.setLayout(bl);
		JLabel lb1 = new JLabel("Nina Colic RN 41/16");
		JLabel lb2 = new JLabel("Bogdan Bakarec RN 20/16");
		JLabel lb3 = new JLabel("Marko Matovic RN 8/16");
		JLabel lb4 = new JLabel("Marko Vukicevic RN 29/16");
		
		image1 = new ImageIcon(getClass().getResource("444.jpg"));  
		Image img1 = image1.getImage();
		Image nimg1 = img1.getScaledInstance(190, 290, Image.SCALE_SMOOTH);
		image1 = new ImageIcon(nimg1);
		JLabel labela1 = new JLabel(image1);						
		labela1.setSize(400, 400);
			
		image2 = new ImageIcon(getClass().getResource("33.jpg"));
		Image img2 = image2.getImage();
		Image nimg2 = img2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		image2 = new ImageIcon(nimg2);
		JLabel labela2 = new JLabel(image2);
		labela2.setSize(400, 400);
			
		image3 = new ImageIcon(getClass().getResource("111.jpg"));
		Image img3 = image3.getImage();
		Image nimg3 = img3.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		image3 = new ImageIcon(nimg3);
		JLabel labela3 = new JLabel(image3);
		labela3.setSize(400, 400);
			
		image4 = new ImageIcon(getClass().getResource("222.jpg"));
		Image img4 = image4.getImage();
		Image nimg4 = img4.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		image4 = new ImageIcon(nimg4);
		JLabel labela4 = new JLabel(image4);
		labela4.setSize(400, 400);
			
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);			
		JPanel p1 = new JPanel();
		p1.setLayout(fl);
		p1.add(labela1);
		p1.add(lb1);
		
		JPanel p2 = new JPanel();
		p2.setLayout(fl);
		p2.add(labela2);
		p2.add(lb2);
		
		JPanel p3 = new JPanel();
		p3.setLayout(fl);
		p3.add(labela3);
		p3.add(lb3);
		
		JPanel p4 = new JPanel();
		p4.setLayout(fl);
		p4.add(labela4);
		p4.add(lb4);
		
		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
		panel.add(p4);
		
		this.add(sp);
	}


	



	
}


	
	