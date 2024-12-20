package less1.Actor;


import less1.Product.Fruits.Fruits;
import less1.Product.MarketForProducts.MarketProducts;
import less1.Product.Product;
import less1.Product.Vegetables.Vegetables;

import java.time.LocalDate;
import java.util.List;

public class Create {

    public Create() {
    }

    public MarketProducts createFruitMarketProducts() {
        MarketProducts mpFruits = new MarketProducts();

        Product apple = new Fruits("apple", 140.5, LocalDate.of(2024, 11, 13), 12, 1.0);
        Product banana = new Fruits("banana", 152.4, LocalDate.of(2024, 11, 3), 9, 1.0);
        Product grape = new Fruits("grape", 100, LocalDate.of(2024, 11, 1), 7, 1.0);

        mpFruits.addProduct(List.of(apple, apple, apple, apple, apple, apple));
        mpFruits.addProduct(List.of(banana, banana, banana, banana, banana, banana));
        mpFruits.addProduct(List.of(grape, grape, grape, grape, grape, grape, grape));

        return mpFruits;
    }



    public MarketProducts createVegetableMarketProducts() {
        MarketProducts mpVegetables = new MarketProducts();

        Product cabbage = new Vegetables("cabbage", 70, LocalDate.of(2024, 11, 12), 12, 1.0);
        Product radish = new Vegetables("radish", 60, LocalDate.of(2024, 11, 1), 19, 1.0);
        Product eggplant = new Vegetables("eggplant", 40, LocalDate.of(2024, 11, 3), 13, 1.0);

        mpVegetables.addProduct(List.of(cabbage, cabbage, cabbage, cabbage, cabbage, cabbage));
        mpVegetables.addProduct(List.of(radish, radish, radish, radish, radish, radish));
        mpVegetables.addProduct(List.of(eggplant, eggplant, eggplant, eggplant, eggplant, eggplant));

        return mpVegetables;
    }



}
