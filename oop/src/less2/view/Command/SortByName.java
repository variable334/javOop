package less2.view.Command;

import less2.view.ConsoleUI;

import java.io.IOException;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировать по имени";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.sortByName();
    }
}
