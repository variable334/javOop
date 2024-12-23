package less1.Person.Tree.iterators;

import less1.Person.persons.Person;

import java.util.Iterator;
import java.util.List;

public class Iterators<T> implements Iterator<T> {
    private int index;
    private List<T>list;

    public Iterators(List<T> listOfRelatives) {
        this.list= listOfRelatives;
    }

    @Override
    public boolean hasNext() {
        return index<list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }
}
