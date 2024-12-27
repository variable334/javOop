package less2.model.Service;

import less1.Person.Tree.ManagementTree;
import less1.Person.Tree.Tree;
import less1.Person.animals.Animals;
import less1.Person.persons.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service <T extends ManagementTree<T>> {

    private Tree<T> tree;
    private List<T> list;
    private FileOperations fileOperations;


    public Service() {
        this.tree = new Tree<>();
        list = new ArrayList<>();
        this.fileOperations = new FileOperations();
    }

    public void save(String name) throws IOException {
        fileOperations.saves(tree,name);
    }

    public void load(String path) throws IOException, ClassNotFoundException {
       fileOperations.load(path);

    }

    public void setSpouse(String nameMen, String nameSpouse) {

        T entity = tree.findByName(nameMen);
        for (T person : tree.getListOfRelatives()) {
            if (person.getName().equals(nameSpouse)) {
                person.setSpouse(entity);

            }
        }
    }

    public void setFather(String nameMen,String nameChild) {

        T entity = tree.findByName(nameMen);

        for (T person : tree.getListOfRelatives()) {
            if(person.getName().equals(nameChild))
                person.setFather(entity);
        }

    }

    public void setMother(String nameMother,String nameChild) {

        T entity = tree.findByName(nameMother);

        for (T person : tree.getListOfRelatives()) {
            if(person.getName().equals(nameChild))
                person.setMother(entity);
        }

    }

    public void setSibling(String name1,String namechild1){{

        T entity = tree.findByName(namechild1);
        for (T person : tree.getListOfRelatives()) {
            if(person.getName().equals(name1))
                person.addSiblings(entity);
        }

    }


    }

    public List<T> getTree(){
        return tree.getListOfRelatives();
    }

    public Tree gets(){
      return tree;
    }


    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByYearOfBirth();
    }


    public void createPerson(String name, int yearOfBirth) {
        Person person = new Person(name, yearOfBirth);
        tree.addPerson((T) person);
    }

    public void createAnimls(String name, int yearOfBirth) {
        Animals animals = new Animals(name, yearOfBirth);
        tree.addPerson((T) animals);
    }

    public void findEntity(String name) {

        T entity = tree.findByName(name);
        if (entity != null) {
            printPerson(entity);
        }
    }

    public void printPerson(T e) {

        System.out.println("Имя: " + e.getName());
        System.out.println("Год рождения: " + e.getYearOfBirth());
        System.out.println("Тип особи: " + e.getFace_type());

        if (e.getFather() != null) {
            System.out.println("Отец: " + e.getFather().getName());
        }
        if (e.getMother() != null) {
            System.out.println("Мать: " + e.getMother().getName());
        }
        if (e.getSpouse() != null) {
            System.out.println("Супруг(а): " + e.getSpouse().getName());
        }
        if (!e.getChildren().isEmpty()) {
            System.out.print("Дети: ");
            for (T child : e.getChildren()) {
                System.out.print(child.getName() + " ");
            }
            System.out.println();
        }
        if (!e.getSiblings().isEmpty()) {
            System.out.print("Братья/Сёстры: ");
            for (T s : e.getSiblings()) {
                System.out.print(s.getName() + " ");
            }
            System.out.println();
        }
    }

    public void PrintTree() {

        List<T> treeListOfRelatives = tree.getListOfRelatives();

        for (T e : treeListOfRelatives) {
            System.out.println("Имя: " + e.getName());
            System.out.println("Год рождения: " + e.getYearOfBirth());
            System.out.println("Тип особи: " + e.getFace_type());
            if (e.getFather() != null) {
                System.out.println("Отец: " + e.getFather().getName());
            }
            if (e.getMother() != null) {
                System.out.println("Мать: " + e.getMother().getName());
            }
            if (e.getSpouse() != null) {
                System.out.println("Супруг(а): " + e.getSpouse().getName());
            }

            if (!e.getChildren().isEmpty()) {
                System.out.print("Дети: ");
                for (T child : e.getChildren()) {
                    System.out.print(child.getName() + " ");
                }
                System.out.println();
            }
            if (!e.getSiblings().isEmpty()) {
                System.out.print("Братья/Сёстры: ");
                for (T s : e.getSiblings()) {
                    System.out.print(s.getName() + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }


}
