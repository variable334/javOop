package less1.Person.Tree.iterators;

import less1.Person.persons.Person;

import java.util.Iterator;
import java.util.List;

public class Iterators implements Iterator<Person> {
    private int index;
    private List<Person>list;

    public Iterators(List<Person> listOfRelatives) {
        this.list= listOfRelatives;
    }

    @Override
    public boolean hasNext() {
        return index<list.size();
    }

    @Override
    public Person next() {
        return list.get(index++);
    }
}
