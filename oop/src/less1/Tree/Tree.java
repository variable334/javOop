package less1.Tree;


import less1.Person;

import java.util.ArrayList;
import java.util.List;

 public class Tree {


    private List<Person>listOfRelatives;


    public Tree() {
        this.listOfRelatives = new ArrayList<>();
    }

    public List<Person> getListOfRelatives() {
        return listOfRelatives;
    }

    public void addPerson(Person person){
        listOfRelatives.add(person);
    }

     public List<Person> getChildren(Person parent) {
         return parent.getChildren();
     }

}
