package workspace;

import java.awt.Component;
import java.io.File;
import java.io.Serializable;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import event.UpdateEvent;
import event.UpdateListener;
import main.MainFrame;
import model.Projekat;
import view.ProjekatView;

public class WorkspaceTree extends JTree implements Serializable, TreeSelectionListener{
	
	
	
	public WorkspaceTree() {
		setEditable(true);
		addTreeSelectionListener(this);
		setCellEditor(new WorkspaceTreeEditor(this, new WorkspaceTreeCellRenderer()));
		setCellRenderer(new WorkspaceTreeCellRenderer());
	}

	public void addProjekat(Projekat projekat) {
		((WorkspaceModel)getModel()).add(projekat);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void removeProjekat(Projekat projekat) {
		((WorkspaceModel)getModel()).remove(projekat);
		SwingUtilities.updateComponentTreeUI(this);
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		if(MainFrame.getInstance().getTree().getLastSelectedPathComponent() instanceof Projekat) {
			Projekat p = (Projekat)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
			Component[] components = MainFrame.getInstance().getDesniDesktop().getComponents();
			for(Component c : components) {
				ProjekatView projectView = (ProjekatView)c;
				if(projectView.getProjekat().equals(p)) {
					projectView.setVisible(true);
				}
			}
		}
	}
	
	
	
}
