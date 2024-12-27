package less2.view.Command;

import less2.view.ConsoleUI;

import java.io.IOException;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выход";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.Exit();
    }
}
