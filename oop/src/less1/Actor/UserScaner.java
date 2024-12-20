package less1.Actor;

import less1.Product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserScaner {

    public Scanner scanner;

    private List<Product>list;

    private Market market;

//    private Map<String, List<Product>> products;

    public UserScaner(List<Product>list){

        this.list = list;
        this.scanner = new Scanner(System.in);
    }

    public UserScaner(Map<String, List<Product>> products) {
//        this.products = products;
        this.scanner = new Scanner(System.in);
    }

    public UserScaner(Market market) {

        this.scanner = new Scanner(System.in);
        this.market = market;


    }

    public UserScaner() {
        this.scanner = new Scanner(System.in);


    }

    public String scanner() {
        System.out.println("Как вас зовут: ");
        String name = scanner.nextLine();
        return name;
    }

    public String scanCategory(){
        System.out.println("Введите категорию продукта: ");
        String category = scanner.nextLine();
        return category;
    }

    public String scanSubCategory(){
        System.out.println("Введите выбранный вами сорт категории продукта: ");
        String subCategory = scanner.nextLine();
        return subCategory;
    }
    public int scanCountProduct(){
        System.out.println("Какое количество вас интересует? ");
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;

    }

    public int requestForQuantity(){
        int count = scanCountProduct();
        int size = list.size();
        if (count > size) {
            System.out.println("запрашиваемого вами количества продукта,недоступно,введите меньшее количество");
            requestForQuantity();
        }

        return count;
    }


    public String selectedSubCategory(){

        // получаем выбор продукта из этой категории
        String subCategory = scanSubCategory();

        //получаем список продуктов из категории и подкатегории выбранным посетителем
        System.out.println(list);
        return subCategory;
    }


    public String selectedCategory() {

        String category = scanCategory();// получаем от посетителя категорию

        Map<String, List<Product>> products = market.getProductMap().get(category);

        if (!products.values().isEmpty()) {
            System.out.println("Вот продукты этой категории: ");
            // показываем посетителю продукты из этой категории
            System.out.println(products.keySet());
        }
        else {
            System.out.println("Извините ,эти продукты закончились мы уже решаем проблему,выберете другую категорию продуктов");
            selectedCategory();
        }
        return category;
    }


    public boolean repeat(){
        System.out.println("Хотите заказать еще что то? (да?нет)");
        boolean repeat = getBooleanInput(scanner);
        return repeat;
    }




    public boolean scanMakeOreder() {

        System.out.println("Готовы сделать заказ? (Да/Нет): ");
        boolean userResponse = getBooleanInput(scanner);
        return userResponse;

    }

    public boolean scanTakeOrder(){
        System.out.println("Готовы забрать заказ?(да/нет): ");
        boolean userResponce = getBooleanInput(scanner);
        return  userResponce;
    }

    private  boolean getBooleanInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("да")) {
                return true;
            } else if (input.equals("нет")) {
                return false;
            } else {
                System.out.println("Неверный ввод! Пожалуйста, введите 'да' или 'нет': ");

            }
        }
    }
}

