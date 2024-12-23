package less1.Person.animals;

import less1.Person.Tree.ManagementTree;

import java.io.Serializable;
import java.util.ArrayList;


public class Animals implements Serializable, ManagementTree<Animals> {

    private static final long serialVersionUID = 1L;

    protected String name;
    private int yearOfBirth;
    private String face_type;

    private Animals mother;
    private Animals father;
    private Animals spouse;
    private ArrayList<Animals> siblings;
    private ArrayList<Animals> children;


    public Animals(String name, int yearOfBirth) {

        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.children = new ArrayList<>();
        this.siblings = new ArrayList<>();
        this.face_type = "Animal";
    }
    public Animals(){
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.children = new ArrayList<>();
        this.siblings = new ArrayList<>();
        this.face_type = "Animal";
    }

    public String getclasName() {
        return getClass().getSimpleName();
    }

    @Override
    public String getFace_type() {
        return face_type;
    }

    public void addChild(Animals child) {
        this.children.add(child);
    }

    public void addSiblings(Animals sibling) {
        this.siblings.add(sibling);
        sibling.siblings.add(this);
    }

    public void setFather(Animals father) {
        this.father = father; // mikhail.setFather(Person father)
        if (!father.children.contains(this)) // есть ли this(сын или дочь)в списке детей отца.
            father.addChild(this);// если нет, то добавляем this(сын или дочь)в список детей отца.
    }

    public void setMother(Animals mother) {
        this.mother = mother;
        if (!mother.children.contains(this))
            mother.addChild(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpouse(Animals partner) {
        this.spouse = partner;
        if (partner.spouse != this)// если партнер еще не является супругом
            partner.setSpouse(this);//то партнер становится супругом этого объекта this
    }


    public ArrayList<Animals> getChildren() {
        return children;
    }

    @Override
    public ArrayList<Animals> getSiblings() {
        return siblings;
    }

    public Animals getFather() {
        return father;
    }

    public Animals getMother() {
        return mother;
    }

    public String getName() {
        return name;
    }

    public Animals getSpouse() {
        return spouse;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }




}
