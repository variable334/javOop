package less1;


import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;


import less1.Person.Service.FileOperations;
import less1.Person.Service.ShowTree;
import less1.Person.animals.Animals;
import less1.Person.persons.Person;
import less1.Person.Tree.Tree;
import less1.productsTechnic.Laptop;


import java.util.*;
import java.util.List;


public class Main {

    public static Map<String, Object> userScan() {

        Map<String, Object> request = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название модели: ");
        if (scanner.hasNext()) {
            String name = scanner.next();
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            request.put("nameModel", name);
            scanner.nextLine();
        } else {
            System.out.println("Введите название в виде строки.");
        }

        System.out.println("Введите цену на которую вы расчитывали: ");
        if (scanner.hasNextInt()) {
            int price = scanner.nextInt();
            request.put("price", price);
            scanner.nextLine();
        } else {
            System.out.println("Введите числовое значение");
        }
        System.out.println("Какой размер оперативной памяти вы бы хотели рассмотреть?: ");
        if (scanner.hasNextInt()) {
            int ram = scanner.nextInt();
            request.put("ram", ram);
            scanner.nextLine();
        } else {
            System.out.println("Введите числовое значение");
        }
        System.out.println("Какая операционная система должна быть на этом ноутбуке?: ");
        if (scanner.hasNext()) {
            String os = scanner.next();
            os = os.substring(0, 1).toUpperCase() + os.substring(1).toLowerCase();
            request.put("os", os);
            scanner.nextLine();

        }

        boolean flag = false; // для выхода из цикла

        while (true) {
            System.out.println("Хотели бы добавить что нибудь ещё,да/нет: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("нет")) {
                return request;
            }
            if (input.equalsIgnoreCase("да")) {

                if (flag) {
                    System.out.println("Все возможные критерии уже добавлены.");
                    return request;
                }

                System.out.println("Какой объём жёсткого диска вы бы хотели раcсмотреть?: ");
                if (scanner.hasNextInt()) {
                    int hdd = scanner.nextInt();
                    request.put("hdd", hdd);
                    scanner.nextLine();
                    flag = true;
                } else {
                    System.out.println("Введите числовое значение");
                    scanner.nextLine();
                }
            }
        }

    }


    public static List<Laptop> filters(Map<String, Object> userList, Map<String, List<Laptop>> laptopsByModel) {

        Scanner scanner = new Scanner(System.in);
        // получаем имя модели из пользовательского ввода
        String userModel = (String) userList.get("nameModel");
        //количество моделей в списке с именем введённого от пользователя
        int size = laptopsByModel.get(userModel).size();


        List<Laptop> requestMatch = new ArrayList<>();
        List<Laptop> list = laptopsByModel.get(userModel);


        // проходимся только по той модели которую ввёл пользователь
        for (Laptop laptop : laptopsByModel.get(userModel)) {


            Laptop bigger = list.get(0);
            Laptop smaller = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                Laptop current = list.get(i);

                if (current.getPrice() > bigger.getPrice()) {
                    bigger = current;
                }
                if (current.getPrice() < smaller.getPrice()) {
                    smaller = current;
                }
            }


            Laptop MaxRam = list.get(0);
            Laptop MinRam = list.get(0);

            for (int i = 1; i < list.size(); i++) {
                Laptop current = list.get(i);

                // Определяем ноутбук с максимальной RAM
                if (current.getRam() > MaxRam.getRam()) {
                    MaxRam = current;
                }

                // Определяем ноутбук с минимальной RAM
                if (current.getRam() < MinRam.getRam()) {
                    MinRam = current;
                }
            }


            Laptop MaxHdd = list.get(0);
            Laptop MinHdd = list.get(0);

            for (int i = 1; i < list.size(); i++) {
                Laptop current = list.get(i);

                // Определяем ноутбук с максимальным HDD
                if (current.getHdd() > MaxHdd.getHdd()) {
                    MaxHdd = current;
                }

                // Определяем ноутбук с минимальным HDD
                if (current.getHdd() < MinHdd.getHdd()) {
                    MinHdd = current;
                }
            }


            boolean matches = true;


            if (userList.containsKey("price")) {
                int userPrice = (int) userList.get("price");//цена от пользователя
                int laptopPrice = laptop.getPrice();// цена модели которую он хочет выбрать

                if (laptop.getPrice() > (int) userList.get("price")) {
                    int difference = laptopPrice - userPrice; // вычисляем разницу между ценой от пользователя и ценой самого ноутбука в катологе
                    System.out.println("Цена за ноутбук который вы хотели превышает на" + difference + ", хотели бы рассмотреть другую цену ноутбука этой модели да/нет?: ");
                    String userrequests = scanner.nextLine().trim().toLowerCase();
                    if (userrequests.equals("да")) {
                        System.out.println("Какой критерий цены вам подходит,относительно цены которой вы ввели ранее,больше/меньше?: ");
                        String userrequests1 = scanner.nextLine().trim().toLowerCase();

                        if (userrequests1.equals("больше")) {
                            System.out.println(bigger);

                        } else {
                            System.out.println(smaller);

                        }

                        matches = true;
                    } else {
                        matches = false;
                    }
                }
            }


            if (userList.containsKey("ram")) {
                int userRam = (int) userList.get("ram");//получаем параметр ram от пользователя
                int laptopsRam = laptop.getRam();// получаем параметр ram ноутбука в каталоге


                if (laptop.getRam() < (int) userList.get("ram")) {
                    int difference = userRam - laptopsRam;//вычисляем разность между параметрами от пользователя и ноутбука в каталоге0
                    System.out.println("Введённые вами параметры оперативной памяти превышают на " + difference + " gb" + ", хотели бы рассмотреть другой объём ram этого ноутбука да/нет?: ");
                    String userrequests1 = scanner.nextLine().trim().toLowerCase();
                    if (userrequests1.equals("да")) {

                        System.out.println("Какой параметр ram вам подходит,относительно параметра ram которой вы ввели ранее,больше/меньше?: ");
                        String userrequests5 = scanner.nextLine().trim().toLowerCase();

                        if (userrequests5.equals("больше")) {
                            System.out.println(MaxRam);
                        } else {
                            System.out.println(MinRam);
                        }

                        matches = true;
                    } else {
                        matches = false;
                    }

                }
            }

            if (userList.containsKey("os")) {
                String userOs = (String) userList.get("os");//получаем параметр os от пользователя
                String laptopOs = laptop.getOs();// получаем параметр os ноутбука в каталоге
                if (!laptop.getOs().equals(userList.get("os"))) {
                    System.out.println("Этот ноутбук работает на " + laptopOs + ", а не на " + userOs + ",хотели бы рассмотреть ноутбук с другой операционной системой? да/нет: ");
                    String userrequests2 = scanner.nextLine().trim().toLowerCase();
                    if (userrequests2.equals("да")) {

                        //если пользователь согласен выбрать другой параметр для этой модели
                        matches = true;
                    } else {
                        matches = false;

                    }
                }

                if (userList.containsKey("hdd")) {
                    int userHdd = (int) userList.get("hdd");//получаем параметр hdd от пользователя
                    int laptopHdd = laptop.getHdd();// получаем параметр hdd ноутбука в каталоге

                    if (laptop.getHdd() < (int) userList.get("hdd")) {
                        int difference = userHdd - laptopHdd;

                        System.out.println("Введённые вами параметры жёсткого диска превышают на " + difference + ", хотели бы рассмотреть другой объём hdd этого ноутбука да/нет?: ");

                        String userrequests3 = scanner.nextLine().trim().toLowerCase();
                        if ((userrequests3.equals("да"))) {

                            System.out.println("Какой параметр hdd вам подходит,относительно параметра hdd которой вы ввели ранее,больше/меньше?: ");
                            String userrequests6 = scanner.nextLine().trim().toLowerCase();

                            if (userrequests6.equals("больше")) {
                                System.out.println(MaxHdd);
                            } else {
                                System.out.println(MinHdd);
                            }

                            matches = true;
                        } else {
                            matches = false;
                        }

                    }
                }

                //  если значения совпали – то добавляем ноутбук
                if (matches) {
                    requestMatch.add(laptop);
                }

            }

            break;
        }


        return requestMatch;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

//
//        Completion completion = new Completion();
//
//        Market marketproduct = new Market(completion.getMp().getProductMap());
//
//        System.out.println(marketproduct.getProductMap());
//
//        PrintMarketProduct.printMarket(marketproduct.getProductMap());


//        UserScaner userScaner = new UserScaner();
//
//        while (true) {
//
//            Human human = new Human(userScaner.scanner());
//            marketproduct.acceptToMarket(human);
//            System.out.println(marketproduct.getActors());
//            if (!mp.getProductMap().isEmpty()) {
//                System.out.println("Здравствуйте " + human.getName() + " !" + " Вы вошли в Маркет,ознакомьтесь с нашим ассортиментом");
//                PrintMarketProduct.printMarket(mp.getProductMap());
//            } else {
//                System.out.println("Извините ,в данный момент сервис не работает,зайди в другой раз");
//            }
//            System.out.println();
//
//            Thread.sleep(2000);
//
//            if (userScaner.scanMakeOreder()) { // если человек готов сделать заказ
//                marketproduct.takeInQueue(human);// добавляем его в очередь
//
//                System.out.println(marketproduct.getQueue());// получить очередь
//                Map<Product, Integer> order = new HashMap<>();// создаём карту для заказов
//
//                while (true) {
//                    System.out.println("Вот список категорий продуктов: ");
//                    // показываем посетителю карту из имеющихся категорий продуктов
//                    System.out.println(mp.getProductMap().keySet());
//
//                    Thread.sleep(2000);
//
//                    UserScaner userScaner1 = new UserScaner(marketproduct);
//
//                    String category = userScaner1.selectedCategory();
//
//
//                    String subCategory = userScaner.scanSubCategory(); // получаем выбор продукта из этой категории
//
//                    //получаем список продуктов из категории и подкатегории выбранным посетителем
//                    List<Product> productss = mp.getProductMap().get(category).get(subCategory);
//
//                    int size = productss.size(); // количество данного продукта
//
//                    UserScaner countprod = new UserScaner(productss);
//
//                    int count = countprod.requestForQuantity();// запрос у посетителя о количестве, с повтором
//
//                    System.out.println(productss.size());
//
//                    Product product = productss.get(0);
//
//                    order.put(product, count);
//
//                    marketproduct.update();
//
//                    if (!userScaner.repeat()) {
//
//                        marketproduct.takeOrders(order);
//                        marketproduct.update();
//                        System.out.println(productss.size());
//
//                        if (userScaner.scanTakeOrder()) {
//                            marketproduct.giveOrders();
//                            System.out.println("Ваш заказ:");
//                            for (Map.Entry<Product, Integer> entry : order.entrySet()) {
//                                System.out.println("Продукт: " + entry.getKey().getName() + ", Количество: " + entry.getValue());
//                            }
//                        }
//
//                        System.out.println(marketproduct.getQueue());
//                        marketproduct.releaseFromMarket(marketproduct.getActors());
//                        System.out.println(marketproduct.getActors());
//                        marketproduct.getProductMap().size();
//                        break;
//                    }
//                }
//            } else {
//                System.out.println("Не торопитесь ,можете пока выбирать себе товар,мы пока что обслужим следующего, как будете готовы,мы обслужим вас ");
//            }
//            Thread.sleep(2000);
//        }
//    }


//

//
        Person john = new Person("John", 1963);
        Person sara = new Person("Sara", 1960);
        Person adel = new Person("Adel", 1990);
        Person mikhail = new Person("Mikhail", 1993);
        Person lama_su = new Person("Lama-su", 1970);
        Person dick = new Person("Dick", 1962);
        Person sam = new Person("Sam", 1963);
        Person eina = new Person("Eina", 1965);

        Animals wolwJack = new Animals("Jack", 1990);
        Animals wolwLuna = new Animals("Luna", 1992);
        Animals wolwMicael = new Animals("Micael", 2020);
        Animals wolwRin = new Animals("Rin", 2022);


        john.setSpouse(sara);

        adel.setMother(sara);
        adel.setFather(john);

        mikhail.setFather(john);
        mikhail.setMother(sara);


        john.addSiblings(dick);
        john.addSiblings(lama_su);
        sara.addSiblings(eina);
        sara.addSiblings(sam);

        adel.addSiblings(mikhail);


        Tree tree = new Tree();

        tree.addPerson(john);
        tree.addPerson(sara);
        tree.addPerson(adel);
        tree.addPerson(mikhail);
        tree.addPerson(dick);
        tree.addPerson(lama_su);
        tree.addPerson(eina);
        tree.addPerson(sam);


        wolwJack.setSpouse(wolwLuna);

        wolwMicael.setFather(wolwJack);
        wolwMicael.setMother(wolwLuna);

        wolwRin.setFather(wolwJack);
        wolwRin.setMother(wolwLuna);

        wolwMicael.addSiblings(wolwRin);

        Tree treeanimals = new Tree();

        treeanimals.addPerson(wolwJack);
        treeanimals.addPerson(wolwLuna);
        treeanimals.addPerson(wolwMicael);
        treeanimals.addPerson(wolwRin);

        ShowTree showAnimals = new ShowTree<>(treeanimals);

        ShowTree show = new ShowTree<>(tree);

//        System.out.println("Поиск Персоны ");
//        System.out.println();
//        show.findPerson(john.getName());
//        System.out.println();
//
//        System.out.println("Поиск Животного");
//        System.out.println();
//        showAnimals.findPerson(wolwMicael.getName());
        System.out.println();

//        tree.sortByName();
//        treeanimals.sortByName();

        System.out.println("Семейство людей: ");
        System.out.println();
        show.PrintTree();

        System.out.println("Семейство животных: ");
        System.out.println();
        showAnimals.PrintTree();


//        tree.sortByYearOfBirth();
//        treeanimals.sortByYearOfBirth();

        System.out.println();
        System.out.println("Сохранение проекта");
        System.out.println();

        FileOperations fileOperations = new FileOperations();

        try {
            fileOperations.saves(tree, "familyTree.doc");
            System.out.println("Файл сохранён");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Выгрузка проекта(Люди)");
        System.out.println();

//        Tree<Person> loadtree = null;
//
//        try {
//            loadtree = fileOperations.load("familyTree.doc");
//            System.out.println("Фамильное дерево загружено из файла");
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println();
//
//        if (loadtree != null) {
//            for (Person person : loadtree.getListOfRelatives()) {
//                System.out.println("Loaded person:" +
//                        person.getName() + " " + person.getYearOfBirth());
//            }
//        }
//
//        System.out.println();
//        System.out.println("Сохранение проекта(Животные)");
//        System.out.println();
//
//
//        try {
//            fileOperations.saves(treeanimals, "familyTree.dat");
//            System.out.println("Файл сохранён");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println();
//
//        System.out.println("Выгрузка проекта(Животные)");
//        System.out.println();
//
//        Tree<Animals> loadtree1 = null;
//
//        try {
//            loadtree1 = fileOperations.load("familyTree.dat");
//            System.out.println("Фамильное дерево загружено из файла");
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println();
//
//        if (loadtree1 != null) {
//            for (Animals person : loadtree1.getListOfRelatives()) {
//                System.out.println("Loaded person:" +
//                        person.getName() + " " + person.getYearOfBirth());
//            }
//        }
//
//
//        System.out.println();




//        FluingAnimal duck = new Duck("Donald");
//
//        MovingAnimals cat = new Cat("Tom");
//
//        MovingAnimals dog = new Dog("Rex");
//
////        ((FluingAnimal)duck).fly();
////        Duck duck1 = new Duck("ducks");
////        duck1.fly();
//
//        Swimmabl Duck = (Swimmabl) duck;
//        Movement Cat = (Movement) cat;
//        Movement Dog = (Movement) dog;
//
//        System.out.println();
//
//        duck.eat();
//        duck.fly();
//        Duck.swimm(12);
//        System.out.println();
//        cat.eat();
//        Cat.move(1);
//        System.out.println();
//        dog.eat();
//        Dog.move(2);
////
//        System.out.println();


//        Set<Laptop> laptops = new LinkedHashSet<>();
//
//        laptops.add(new Laptop("Dell", 50_000, 512, 12, "Linux"));
//        laptops.add(new Laptop("Dell", 60_000, 512, 16, "Windows"));
//        laptops.add(new Laptop("Xiomi", 150_000, 1024, 32, "Windows"));
//        laptops.add(new Laptop("Xiomi", 100_000, 512, 16, "Windows"));
//        laptops.add(new Laptop("Huawei", 170_000, 1024, 16, "Windows"));
//        laptops.add(new Laptop("Huawei", 120_000, 512, 12, "Windows"));
//        laptops.add(new Laptop("Asus", 100_000, 512, 16, "Windows"));
//        laptops.add(new Laptop("Asus", 80_000, 256, 8, "Windows"));
//        laptops.add(new Laptop("Acer", 90_000, 512, 16, "Windows"));
//        laptops.add(new Laptop("Acer", 60_000, 512, 8, "Windows"));
//        laptops.add(new Laptop("Samsung", 150_000, 1024, 32, "Windows"));
//        laptops.add(new Laptop("Msi", 80_000, 512, 8, "Linux"));
//
//
//        System.out.println(laptops);
//        //создаём Map имя модели + список
//        Map<String, List<Laptop>> modelLaptops = new HashMap<>();
//
//        for (Laptop laptop : laptops) {
//            //получаем имя
//            String nameModel = laptop.getNameModel();
//            // и добавляем в map на позицию String
//            modelLaptops.putIfAbsent(nameModel, new ArrayList<>());
//            // и добавляем список ноутбуков для модели которая находится на этом этапе итерации
//            modelLaptops.get(nameModel).add(laptop);
//        }
//
////        Map<String, List<Laptop>> laptopsByModel = modelLaptops;
//
//
//        boolean flag = true;
//        // этот цикл while не даёт закончить запрос пользователя до тех пор,
//        // пока пользователь не определится с критериями подходящими под описания ноутбуков имеющихся в каталоге
//        while (flag) {
//            Map<String, Object> searchingForItems = userScan();
//            List<Laptop> result = filters(searchingForItems, modelLaptops);
//            if (result.isEmpty()) {
//                System.out.println("Совпадения не найдены,попробуйте ввести другие критерии");
//            } else {
//                System.out.println("Совпадения найдены: " + result);
//                flag = false;
//                break;
//            }
//       }


// Первый урок ООП

//        Milk milk= new Milk(100,LocalDateTime.now(),"qwerty",15,"white");
//
//        String color = milk.color;
//        double price = milk.price;
//
//        Water water = new Water(150,LocalDateTime.now(),"EWQEWQ",1,true);
//
//        Product milk1= new Milk(120,LocalDateTime.now(),"asdzxc",15,"white");
//
//        String color1 = milk.color;
//
//        Set<Product>products = new HashSet<>();
//        products.add(milk);
//        products.add(milk1);
//        products.add(water);
//
//        milk.addgrops(111);
//        System.out.println(milk.getGrops());
//        System.out.println(water.getProductType());
//        milk.getGrops().clear();
//
//        System.out.println(milk.getGrops());
//
//        System.out.println(milk.getProductType());
//        System.out.println(products);
//
//        milk.setPrice(1000);//через вызов метода setPrice меняем цену у молока
//        products.add(milk);
//        System.out.println(products);


//        }
//
    }
}