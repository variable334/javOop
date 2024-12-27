package less2.model.Service;

import less2.model.Tree.ManagementTree;
import less2.model.Tree.Tree;

import java.util.List;


public class ShowTree<T extends ManagementTree<T>> {

    private Tree<T> tree;

    public ShowTree(Tree<T> tree) {
        this.tree = tree;
    }



    public void findPerson(String name) {

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

    public void PrintTree(){

       List<T>treeListOfRelatives = tree.getListOfRelatives();

       for (T e:treeListOfRelatives){
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
