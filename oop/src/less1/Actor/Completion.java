package less1.Actor;

import less1.Product.MarketForProducts.MarketProducts;

public class Completion {

    private MarketProducts mp;
    private Create create;


    public Completion() {
        this.create = new Create();
        this.mp = completion();
    }

    private MarketProducts completion() {
        MarketProducts mp = new MarketProducts();

        mp.addProducts("fruits", "banana", create.createFruitMarketProducts().getProducts());
        mp.addProducts("fruits", "apple", create.createFruitMarketProducts().getProducts());

        mp.addProducts("vegetables", "radish", create.createVegetableMarketProducts().getProducts());
        mp.addProducts("vegetables", "eggplant", create.createVegetableMarketProducts().getProducts());

        return mp;
    }

    public MarketProducts getMp() {
        return mp;
    }



}
