package less1.Person;

import less1.Person.Tree.Tree;

import java.io.IOException;

public interface actionsWithFiles {

    void saves(Tree tree,String name) throws IOException;

    Tree load(String name) throws IOException,ClassNotFoundException;

}
