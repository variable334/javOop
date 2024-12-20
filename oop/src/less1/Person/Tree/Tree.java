package less1.Person.Tree;


import less1.Person.Tree.iterators.Iterators;
import less1.Person.comparable.ComaparePersonByName;
import less1.Person.comparable.ComaparePersonByYearOfBirth;
import less1.Person.persons.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree implements Serializable, Iterable<Person> {
    private static final long serialVersionUID = 1L;

    private List<Person> listOfRelatives;

    private Person man;

    public Tree() {
        this.listOfRelatives = new ArrayList<>();

    }

    public void addPerson(Person person) {
        listOfRelatives.add(person);
    }

    public List<Person> getListOfRelatives() {
        return listOfRelatives;
    }


    public void findPerson(String name) {
        for (Person person : listOfRelatives) {
            if (person.getName().equals(name)) {
                System.out.println("Имя: " + person.getName());
                System.out.println("Год рождения: " + person.getYearOfBirth());
                if (!person.getChildren().isEmpty()) {
                    System.out.print("Дети: ");
                    for (Person child : person.getChildren()) {
                        System.out.print(child.getName() + " ");
                    }
                    System.out.println();
                }
                if (!person.getSiblings().isEmpty()) {
                    System.out.print("Братья/Сёстры: ");
                    for (Person sibling : person.getSiblings()) {
                        System.out.print(sibling.getName() + " ");
                    }
                    System.out.println();
                }
                if (person.getFather() != null) System.out.println("Отец: " + person.getFather().getName());
                if (person.getMother() != null) System.out.println("Мать: " + person.getMother().getName());
                if (person.getSpouse() != null) System.out.println("Супруг(а): " + person.getSpouse().getName());
            }
        }
    }

    public void showRelatives() {
        for (Person person : listOfRelatives) {
            person.abraCadabra();
        }
    }

    @Override
    public Iterator<Person> iterator() {
        return new Iterators(listOfRelatives);
    }

    public void sortByName() {
        listOfRelatives.sort(new ComaparePersonByName());
    }

    public void sortByYearOfBirth() {
        listOfRelatives.sort(new ComaparePersonByYearOfBirth());
    }


}
