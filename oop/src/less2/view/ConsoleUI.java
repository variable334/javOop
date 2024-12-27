package less2.view;

import less1.Person.Service.FileOperations;
import less1.Person.Tree.Tree;
import less1.Person.persons.Person;
import less2.presenter.Presenter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Presenter presenter;
    private Scanner scanner;
    private boolean exit;
    private Menu menu;


    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        exit = true;
        menu = new Menu(this);

    }


    @Override
    public void start() throws IOException, ClassNotFoundException {

        while (exit) {
            System.out.println("Здравствуйте,что бы вы хотели сделать?");
            System.out.println();

            printAnswer(menu.Menu());
            String choice = scanner.nextLine();
            int answ = Integer.parseInt(choice);
            menu.execute(answ);
        }
    }


    public void sortByAge() {
        presenter.sortByAges();
    }

    public void sortByName() {
        presenter.sortByNames();
    }

    public void loadTree() throws IOException, ClassNotFoundException {
        System.out.println();
        System.out.println("Введите имя файла которое сохранили");
        String names = scanner.nextLine();
        presenter.loads(names);
        System.out.println();
    }

    public void saveTree() {
        System.out.println();
        System.out.println("Введите имя файла: ");
        System.out.println();
        String names = scanner.nextLine();

        try {
            presenter.saves(names);
            System.out.println("Файл сохранён");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void findEntity() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println();
        presenter.find(name);
    }

    public void viewsTree() {
        presenter.printTree();
    }

    public void createTree() {

        System.out.println("Древо какого вида особи вы хотите создать?");
        System.out.println("1.Человек.");
        System.out.println("2.Животное.");

        String choice2 = scanner.nextLine();


        switch (choice2) {
            case "1": {
                System.out.println("Вы выбрали вид особи 'человек'.");

                System.out.println("Введите имя: ");
                String name = scanner.nextLine();
                System.out.println("Введите год рождения: ");
                int yearOfBirth = scanner.nextInt();

                scanner.nextLine();
                presenter.createPerson(name, yearOfBirth);
                while (true) {
                    System.out.println("Введите следующего члена семьи или break(если ввели всех нужных вам членов семьи)");
                    System.out.println();
                    System.out.println("Введите имя: ");
                    String name1 = scanner.nextLine();
                    if (!name1.equals("break")) {
                        System.out.println("Введите год рождения: ");
                        int yearOfBirth1 = scanner.nextInt();
                        scanner.nextLine();
                        presenter.createPerson(name1, yearOfBirth1);
                    } else {
                        sets();
                        break;
                    }
                }
            }
            break;


            case "2": {
                System.out.println("Вы выбрали вид особи 'животное'.");
                System.out.println("Введите имя: ");
                String name = scanner.nextLine();
                System.out.println("Введите год рождения: ");
                int yearOfBirth = scanner.nextInt();

                scanner.nextLine();
                presenter.createAnimals(name, yearOfBirth);

                while (true) {
                    System.out.println("Введите следующего члена стаи или break(если ввели всех нужных вам членов стаи)");
                    System.out.println();
                    System.out.println("Введите имя: ");
                    String name1 = scanner.nextLine();
                    if (!name1.equals("break")) {
                        System.out.println("Введите год рождения: ");
                        int yearOfBirth1 = scanner.nextInt();
                        scanner.nextLine();
                        presenter.createPerson(name1, yearOfBirth1);
                    } else {
                        sets();
                        break;
                    }
                }
            }

            default: {
                System.out.println("Вы ввели неверную цифру.");
            }
            break;
        }
    }

    public void sets() {

        System.out.println();
        System.out.println("Давайте теперь определим связи между добавленными в древо людьми");
        System.out.println();

        System.out.println("Введите имя отца: ");
        String men = scanner.nextLine();
        System.out.println("Введите имя супруг(а)");
        String spouse = scanner.nextLine();
        presenter.setSpouses(men, spouse);

        System.out.println();
        System.out.println("Введите имя ребенка или break если детей нету: ");
        String namechild = scanner.nextLine();
        if (!namechild.equals("break")) {
            presenter.setFathers(men, namechild);
            presenter.setMothers(spouse,namechild);
            while (true) {
                System.out.println();
                System.out.println("Введите имя ребенка или break если ввели всех детей: ");
                String nameChild1 = scanner.nextLine();
                if (!nameChild1.equals("break")) {
                    presenter.setFathers(men, nameChild1);
                    presenter.setMothers(spouse,nameChild1);
                    presenter.setSiblings(namechild,nameChild1);
                } else {
                    break;
                }
            }
        }
    }

    public void Exit(){
        exit = false;

    }
    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }


}



