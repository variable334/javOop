package less1;


import java.util.ArrayList;


public class Person {

    protected String name;
    private int yearOfBirth;
    private String mother;
    private String father;
    private ArrayList<Person> children;


    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();


    }

    public void addChild(Person child){
        children.add(child);

    }

    public String getName() {
        return name;
    }

    public String getFather() {
        return father;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public String getMother() {
        return mother;
    }

    public void setChildren(ArrayList<Person> children) {
        this.children = children;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }



}
