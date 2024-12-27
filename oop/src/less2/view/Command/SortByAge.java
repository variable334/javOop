package less2.view.Command;

import less2.view.ConsoleUI;

import java.io.IOException;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировать по дате рождения";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.sortByAge();
    }
}
