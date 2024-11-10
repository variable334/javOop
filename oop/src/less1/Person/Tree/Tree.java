package less1.Person.Tree;


import less1.Person.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tree implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Person> listOfRelatives;

    public Tree() {
        this.listOfRelatives = new ArrayList<>();
    }

    public List<Person> getListOfRelatives() {
        return listOfRelatives;
    }

    public void addPerson(Person person) {
        listOfRelatives.add(person);
    }

    public Person findPerson(String name) {
        for (Person person : listOfRelatives) {
            if (person.getName().equals(name)) {
                System.out.println(person.getName());
                return person;
            }
            else {
                System.out.println(name + " - не найден");
                break;
            }

        }
        return null;
    }

    public void showRelatives() {
        for (Person person : listOfRelatives) {
            person.abraCadabra();
        }
    }
}
