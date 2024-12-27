package less2.view.Command;

import less2.view.ConsoleUI;

import java.io.IOException;

public class SaveTree extends Command{
    public SaveTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить древо";
    }

    @Override
    public void execute(){
        consoleUI.saveTree();
    }
}
