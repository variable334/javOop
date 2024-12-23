package less1.Person.comparable;

import less1.Person.Tree.ManagementTree;

import java.util.Comparator;

public class ComaparePersonByName<T extends ManagementTree> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }


}
