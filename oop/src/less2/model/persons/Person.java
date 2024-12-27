package less2.model.persons;


import less2.model.Tree.ManagementTree;

import java.io.Serializable;
import java.util.ArrayList;


public class Person implements Serializable, ManagementTree<Person> {

    private static final long serialVersionUID = 1L;
    protected String name;
    private int yearOfBirth;
    private String face_type;
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
        this.face_type = "Человек";

    }
    public Person(){
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.children = new ArrayList<>();
        this.siblings = new ArrayList<>();
        this.face_type = "Человек";

    }

    public String getclasName() {
        return getClass().getSimpleName();
    }

    public String getFace_type() {
        return face_type;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public void addSiblings(Person sibling) {
        this.siblings.add(sibling);
        sibling.siblings.add(this);
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

    public void setSpouse(Person partner) {
        this.spouse = partner;
        if (partner.spouse != this)// если партнер еще не является супругом
            partner.setSpouse(this);//то партнер становится супругом этого объекта this
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

}
