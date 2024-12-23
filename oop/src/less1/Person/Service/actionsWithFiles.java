package less1.Person.Service;

import less1.Person.Tree.Tree;

import java.io.IOException;

public interface actionsWithFiles <T> {

    void saves(T tree,String name) throws IOException;

    Tree load(String name) throws IOException,ClassNotFoundException;

}
