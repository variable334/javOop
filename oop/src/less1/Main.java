package less1;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


import less1.Actor.*;
import less1.Product.Fruits.Fruits;
import less1.Product.MarketForProducts.MarketProducts;
import less1.Product.Product;
import less1.Product.Vegetables.Vegetables;
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

        Product apple = new Fruits("apple", 140.5, LocalDate.of(2024, 11, 13), 12, 1.0);
        Product banana = new Fruits("banana", 152.4, LocalDate.of(2024, 11, 3), 9, 1.0);
        Product grape = new Fruits("grape", 100, LocalDate.of(2024, 11, 1), 7, 1.0);

        Product cabbage = new Vegetables("cabbage", 70, LocalDate.of(2024, 11, 12), 12, 1.0);
        Product radish = new Vegetables("radish", 60, LocalDate.of(2024, 11, 1), 19, 1.0);
        Product eggplant = new Vegetables("eggplant", 40, LocalDate.of(2024, 11, 3), 13, 1.0);

        MarketProducts mpFruitsApple = new MarketProducts();
        MarketProducts mpFruitsBanana = new MarketProducts();
        MarketProducts mpFruitsGrape = new MarketProducts();

        MarketProducts mpVegetablesCabbage = new MarketProducts();
        MarketProducts mpVegetablesEggplant = new MarketProducts();
        MarketProducts mpVegetablesRadish = new MarketProducts();

        mpFruitsApple.addProduct(List.of(apple, apple, apple, apple, apple, apple));
        mpFruitsBanana.addProduct(List.of(banana, banana, banana, banana, banana, banana));
        mpFruitsGrape.addProduct(List.of(grape, grape, grape, grape, grape, grape, grape));

        mpVegetablesCabbage.addProduct(List.of(cabbage, cabbage, cabbage, cabbage, cabbage, cabbage));
        mpVegetablesEggplant.addProduct(List.of(eggplant, eggplant, eggplant, eggplant, eggplant, eggplant));
        mpVegetablesRadish.addProduct(List.of(radish, radish, radish, radish, radish, radish));

        MarketProducts mp = new MarketProducts();

        mp.addProducts("fruits", "banana", mpFruitsBanana.getProducts());
        mp.addProducts("fruits", "apple", mpFruitsApple.getProducts());
        mp.addProducts("vegetables", "radish", mpVegetablesRadish.getProducts());
        mp.addProducts("vegetables", "eggplant", mpVegetablesEggplant.getProducts());


        Market marketproduct = new Market(mp.getProductMap());

        System.out.println(marketproduct.getProductMap());

        UserScaner userScaner = new UserScaner();


        while (true) {

            Human human = new Human(userScaner.scanner());
            marketproduct.acceptToMarket(human);
            System.out.println("Здравствуйте " + human.getName() + " !" + " Вы вошли в Маркет,ознакомьтесь с нашим ассортиментом");
            PrintMarketProduct.printMarket(mp.getProductMap());
            System.out.println();

            Thread.sleep(1000);

            if (userScaner.scanMakeOreder()) {
                marketproduct.takeInQueue(human);
                System.out.println(marketproduct.getQueue());
                Map<Product, Integer> order = new HashMap<>();
                System.out.println("Вот список категорий продуктов: ");
                System.out.println(mp.getProductMap().keySet());
                Thread.sleep(1000);
                String category = userScaner.scanCategory();
                System.out.println("Выберите сорт категории: ");
                PrintMarketProduct.printSubCategory(mp.getProductMap(), category);
                String subCategory = userScaner.scanSubCategory();


                List<Product> products = mp.getProductMap().get(category).get(subCategory);
                if (products == null || products.isEmpty()) {
                    System.out.println("Подкатегория не найдена или пуста. Попробуйте снова.");
                    return;
                }

                int count = userScaner.scanCountProduct();
                if (count <= 0) {
                    System.out.println("Количество должно быть положительным. Попробуйте снова.");
                    return;
                }

                Product selectedProduct = products.get(0);

                order.put(selectedProduct, count);

                marketproduct.takeOrders(order);

                if (userScaner.scanTakeOrder()) {

                    marketproduct.giveOrders();


                    System.out.println("Ваш заказ:");
                    for (Map.Entry<Product, Integer> entry : order.entrySet()) {
                        System.out.println("Продукт: " + entry.getKey().getName() + ", Количество: " + entry.getValue());
                    }
                }
                System.out.println(marketproduct.getQueue());


            }
            else {
                System.out.println("Не торопитесь ,можете пока выбирать себе товар,как будете готовы,мы вас обслужим ");
            }
            Thread.sleep(2000);

        }
    }
//
//        System.out.println(marketproduct.getOrders());


//        System.out.println(market.getProductMap());


//        Person john = new Person("John", 1963);
//        Person sara = new Person("Sara", 1960);
//        Person adel = new Person("Adel", 1990);
//        Person mikhail = new Person("Mikhail", 1993);
//        Person lama_su = new Person("Lama-su", 1970);
//        Person dick = new Person("Dick", 1962);
//        Person sam = new Person("Sam", 1963);
//        Person eina = new Person("Eina", 1965);
//
//
//        john.setSpouse(sara);
//
//        adel.setMother(sara);
//        adel.setFather(john);
//
//        mikhail.setFather(john);
//        mikhail.setMother(sara);
//
//
//        john.addSiblings(dick);
//        john.addSiblings(lama_su);
//        sara.addSiblings(eina);
//        sara.addSiblings(sam);
//
//        Tree tree = new Tree();
//
//        tree.addPerson(john);
//        tree.addPerson(sara);
//        tree.addPerson(adel);
//        tree.addPerson(mikhail);
//        tree.addPerson(dick);
//        tree.addPerson(lama_su);
//        tree.addPerson(eina);
//        tree.addPerson(sam);
//
//        tree.showRelatives();
//
//
//        Person foundPerson = tree.findPerson("Jonh");
//
//
//        System.out.println();
//
//        FileOperations fileOperations = new FileOperations();
//
//        try {
//            fileOperations.saves(tree, "familyTree.dat");
//            System.out.println("Файл сохранён");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println();
//
//        Tree loadtree = null;
//
//        try {
//            loadtree = fileOperations.load("familyTree.dat");
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
