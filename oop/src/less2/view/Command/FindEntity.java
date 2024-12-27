package less2.view.Command;

import less2.view.ConsoleUI;

import java.io.IOException;

public class FindEntity extends Command {


    public FindEntity(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Поиск сущности";
    }

    @Override
    public void execute() {
        consoleUI.findEntity();
    }
}
