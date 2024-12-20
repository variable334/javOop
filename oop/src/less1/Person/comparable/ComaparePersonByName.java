package less1.Person.comparable;

import less1.Person.persons.Person;

import java.util.Comparator;

public class ComaparePersonByName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }


}
