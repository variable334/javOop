package less2.model.Service;

import less2.model.Tree.Tree;

import java.io.IOException;

public interface actionsWithFiles <T> {

    void saves(T tree,String name) throws IOException;

    Tree load(String name) throws IOException,ClassNotFoundException;

}
