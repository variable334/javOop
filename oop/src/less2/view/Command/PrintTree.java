package less2.view.Command;

import less2.view.ConsoleUI;

import java.io.IOException;

public class PrintTree extends Command{


    public PrintTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать имеющееся древо";
    }

    @Override
    public void execute(){
        consoleUI.viewsTree();
    }
}
