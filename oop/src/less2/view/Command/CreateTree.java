package less2.view.Command;

import less2.view.ConsoleUI;

public class CreateTree extends Command{

    public CreateTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Создать древо.";
    }


    @Override
    public void execute() {
        consoleUI.createTree();
    }



}
