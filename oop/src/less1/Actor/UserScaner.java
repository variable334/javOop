package less1.Actor;

import java.util.Scanner;

public class UserScaner {

    public Scanner scanner;


    public UserScaner() {
        this.scanner = new Scanner(System.in);
    }

    public String scanner() {
        System.out.println("Как вас зовут: ");
        String name = scanner.nextLine();
        return name;
    }

    public String scanCategory(){
        System.out.println("Введите выбранную вами категорию продукта: ");
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

