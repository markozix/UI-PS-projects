package akcije;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;
import model.Dokument;
import model.Projekat;
import view.ProjekatView;

public class UkloniProjekatAction implements ActionListener{
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		if(o instanceof Projekat) {
			MainFrame.getInstance().getTree().removeProjekat((Projekat)o);
			Projekat p = (Projekat)o;
			for(Dokument d : p.getDokumenti()) {
				MainFrame.getInstance().getPTree().addDokument(d);
			}
			for(Component pv: MainFrame.getInstance().getDesniDesktop().getComponents()){
				if(pv instanceof ProjekatView){
					if(((ProjekatView) pv).getProjekat().equals(o)){
						MainFrame.getInstance().getDesniDesktop().remove(pv);
						MainFrame.getInstance().getDesniDesktop().repaint();
						MainFrame.getInstance().getDesniDesktop().revalidate();
					}
				}
			}
		}
	}

}
