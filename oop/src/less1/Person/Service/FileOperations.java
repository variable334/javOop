package less1.Person.Service;

import less1.Person.Tree.Tree;

import java.io.*;

public class FileOperations <T>implements actionsWithFiles<T>, Serializable{

    @Override
    public void saves(T tree, String name) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(name);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tree load(String name) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name))) {
            return (Tree) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
