package akcije;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;
import model.Dokument;
import view.DokumentView;
import view.ProjekatView;

public class PodeliDokumentAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		if(o instanceof Dokument) {
			MainFrame.getInstance().setDokumentZaDeljenje((Dokument)o);
			for(Component c : MainFrame.getInstance().getDesniDesktop().getComponents()) {
				if (c instanceof ProjekatView) {
					ProjekatView tmp = (ProjekatView) c;
					for(DokumentView dview : tmp.getLista()) {
						if(dview.getDokument().equals((Dokument)o)) {
							MainFrame.getInstance().setViewZaDeljenje(dview);
							return;
						}
					}
				}
			}
//			MainFrame.getInstance().setViewZaDeljenje(view);
		}
	}

}
