package less1.Actor;

import less1.Product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintMarketProduct {

    public static void printMarket(Map<String, Map<String, List<Product>>> market) {

        for (String category : market.keySet()) {
            System.out.println("\n===" + category + "===");
            System.out.println();
            Map<String, List<Product>> products = market.get(category);
            for (String product : products.keySet()) {
                List<Product> elem = products.get(product);
                if (!elem.isEmpty()) {
                    Product sample = elem.get(0);
                    System.out.println("- " + product + ":");
                    System.out.println("  Цена: " + sample.getPrice() + " руб.");
                    System.out.println("  Дата изготовления: " + sample.getCreateData());
                }
            }
        }
    }



}
