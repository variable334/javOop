package less2.view.Command;

import less2.view.ConsoleUI;

import java.io.IOException;

public class LoadTree extends Command {


    public LoadTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выгрузить древо.";
    }


    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.loadTree();
    }




}
