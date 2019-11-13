package komande;

import java.util.ArrayList;

import main.MainFrame;

public class CommandManager {

	private ArrayList<AbstractCommand> commands = new ArrayList<>();
	private int currentCommand = 0;
	
	public void addCommand(AbstractCommand command) {
		while(currentCommand < commands.size()) 
			commands.remove(currentCommand);
		commands.add(command);
		doCommand();
	}
	
	public void doCommand() {
		if(currentCommand < commands.size()) {
			commands.get(currentCommand++).doCommand();
		}
	}
	
	public void undoCommand() {
		if(currentCommand > 0) {
			commands.get(--currentCommand).undoCommand();
		}
	}
}
