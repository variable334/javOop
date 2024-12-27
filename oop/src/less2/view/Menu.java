package less2.view;

import less2.view.Command.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    List<Command>commandList;

    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new CreateTree(consoleUI));
        commandList.add(new PrintTree(consoleUI));
        commandList.add(new FindEntity(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SaveTree(consoleUI));
        commandList.add(new LoadTree(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    String Menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }






}
