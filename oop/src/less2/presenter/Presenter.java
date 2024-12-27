package less2.presenter;

import less1.Person.Tree.Tree;
import less2.model.Service.Service;
import less2.view.View;

import java.io.IOException;
import java.util.List;

public class Presenter {

    private View view;
    private Service service;


    public Presenter(View views) {
        this.service = new Service<>();
        this.view = views;

    }

    public Tree get(){
        return service.gets();
    }

    public void createPerson(String name, int yearOfBirth) {
        service.createPerson(name, yearOfBirth);
        System.out.println();
        view.printAnswer("Член семьи добавлен в древо");
    }

    public void createAnimals(String name, int yearOfBirth) {
        service.createAnimls(name, yearOfBirth);
        System.out.println();
        view.printAnswer("Член стаи добавлен в древо");

    }

    public void find(String person){
        System.out.println();
        service.findEntity(person);
        System.out.println();
        System.out.println("Сущность найдена.");
        System.out.println();
    }


    public void saves(String name) throws IOException {
        service.save(name);
        System.out.println("Файл сохранён.");
    }

    public void loads(String name) throws IOException, ClassNotFoundException {
       service.load(name);
       System.out.println("Файл выгружен.");

    }





    public void setSpouses(String name,String spouse){
        System.out.println();
        service.setSpouse(name,spouse);
        System.out.println();
        System.out.println("пара связана.");
        System.out.println();
        service.PrintTree();
        System.out.println();

    }

    public void setFathers(String namefather,String nameChild){
        System.out.println();
        service.setFather(namefather,nameChild);
        System.out.println();
        System.out.println("Ребёнок привязан к отцу.");
    }


    public void setMothers(String nameMother,String nameChild){
        System.out.println();
        service.setMother(nameMother,nameChild);
        System.out.println();
        System.out.println("Ребёнок привязан к матери.");
    }


    public void printTree() {
        System.out.println("Древо:  \n");
        System.out.println();
        service.PrintTree();
    }

    public void setSiblings(String name1,String name2){
        service.setSibling(name1,name2);
    }

    public void sortByNames(){
        service.sortByName();
        service.PrintTree();
    }

    public void sortByAges(){
        service.sortByAge();
        service.PrintTree();
    }

}
