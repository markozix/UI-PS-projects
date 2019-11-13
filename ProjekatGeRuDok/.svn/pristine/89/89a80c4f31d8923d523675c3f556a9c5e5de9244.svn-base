package akcije;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class SlotFileFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || f.getName().toLowerCase().endsWith(".gpf"));
	}

	@Override
	public String getDescription() {
		return "GeRuDok Project Files (*.gpf)"; 
	}

}
