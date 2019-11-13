package state;

import main.MainFrame;

public class DetailState extends State {

	@Override
	public void selectedField() {
		int row = MainFrame.getInstance().getTrenutnaTabela().getSelectedRow();
		for (int i = 0; i < MainFrame.getInstance().getTrenutniEntitet().getChildCount(); i++) {
			if (MainFrame.getInstance().getTrenutnaTabela().getValueAt(row, i) != null)
				MainFrame.getInstance().getLista().get(i)
						.setText(((String) MainFrame.getInstance().getTrenutnaTabela().getValueAt(row, i)).trim());
			else {
				MainFrame.getInstance().getLista().get(i).setText("");
			}
		}
	}

	@Override
	public String toString() {
		return "Detail";
	}

}
