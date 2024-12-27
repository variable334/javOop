package less2.view;

import java.io.IOException;

public interface View {

    void start() throws IOException, ClassNotFoundException;

    void printAnswer(String answer);
}
