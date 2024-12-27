package less2.model.comparable;

import less2.model.Tree.ManagementTree;

import java.util.Comparator;

public class ComaparePersonByYearOfBirth<T extends ManagementTree> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getYearOfBirth()-o2.getYearOfBirth();
    }
}
