package less2.view.Command;

import less2.view.ConsoleUI;

import java.io.IOException;

public abstract class Command {

    ConsoleUI consoleUI;
    String description;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute() throws IOException, ClassNotFoundException;

}
