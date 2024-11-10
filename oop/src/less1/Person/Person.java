package less1.Person;


import less1.Person.Tree.Tree;

import java.io.Serializable;
import java.util.ArrayList;


public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String name;
    private int yearOfBirth;
    private Person mother;
    private Person father;
    private Person spouse;
    private ArrayList<Person> siblings;
    private ArrayList<Person> children;


    public Person(String name, int yearOfBirth) {

        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.children = new ArrayList<>();
        this.siblings = new ArrayList<>();

    }

    public String getclasName() {
        return getClass().getSimpleName();
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public void addSiblings(Person sibling) {
        this.siblings.add(sibling);
        sibling.siblings.add(this);
    }

    public void setChildren(ArrayList<Person> children) {
        this.children = children;
    }

    public void setFather(Person father) {
        this.father = father; // mikhail.setFather(Person father)
        if (!father.children.contains(this)) // есть ли this(сын или дочь)в списке детей отца.
            father.addChild(this);// если нет, то добавляем this(сын или дочь)в список детей отца.
    }

    public void setMother(Person mother) {
        this.mother = mother;
        if (!mother.children.contains(this))
            mother.addChild(this);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSiblings(ArrayList<Person> siblings) {
        this.siblings = siblings;
    }

    public void setSpouse(Person partner) {
        this.spouse = partner;
        if (partner.spouse != this)// если партнер еще не является супругом
            partner.setSpouse(this);//то партнер становится супругом этого объекта this
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Person> getSiblings() {
        return siblings;
    }

    public Person getSpouse() {
        return spouse;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void abraCadabra() {

        System.out.println("Имя: " + name);
        System.out.println("Год рождения: " + yearOfBirth);

        if (father != null) System.out.println("Отец: " + father.getName());
        if (mother != null) System.out.println("Мать: " + mother.getName());
        if (spouse != null) System.out.println("Супруг(а): " + spouse.getName());

        if (!children.isEmpty()) {
            System.out.print("Дети: ");
            for (Person child : children) {
                System.out.print(child.getName()+ " ");
            }
            System.out.println();
        }
        if (!siblings.isEmpty()) {
            System.out.print("Братья/Сёстры: ");
            for (Person sibling:siblings) {
                System.out.print(sibling.getName()+ " ");
            }
            System.out.println();
        }
        System.out.println();

    }


}
