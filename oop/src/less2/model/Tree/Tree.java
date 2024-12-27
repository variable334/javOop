package less2.model.Tree;


import less2.model.Tree.iterators.Iterators;
import less2.model.comparable.ComaparePersonByName;
import less2.model.comparable.ComaparePersonByYearOfBirth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Tree <T extends ManagementTree<T>> implements Serializable, Iterable<T> {

    private static final long serialVersionUID = 1L;

    private List<T> listOfRelatives;


    public Tree() {
        this.listOfRelatives = new ArrayList<>();

    }

    public void addPerson(T person) {
        listOfRelatives.add(person);
    }

    public List<T> getListOfRelatives() {
        return listOfRelatives;
    }

    public T findByName(String name) {
        for (T e : listOfRelatives) {
            if (e.getName().equals(name)) return e;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterators(listOfRelatives);
    }

    public void sortByName() {
        listOfRelatives.sort(new ComaparePersonByName());
    }

    public void sortByYearOfBirth() {
        listOfRelatives.sort(new ComaparePersonByYearOfBirth());
    }


}
