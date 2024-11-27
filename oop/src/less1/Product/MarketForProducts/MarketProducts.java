package less1.Product.MarketForProducts;

import less1.Product.Fruits.Fruits;
import less1.Product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketProducts implements addProduct {

    private Map<String, Map<String, List<Product>>> productMap;

    private List<Product> products;

    public MarketProducts() {

        this.productMap = new HashMap<>();
        this.products = new ArrayList<>();

    }

    @Override
    public void addProduct(List<Product> products) {
        List<Product> list = new ArrayList<>(products);
        this.products.addAll(list);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Map<String, Map<String, List<Product>>> getProductMap() {
        return productMap;
    }

    @Override
    public void addProducts(String category, String subcategory, List<Product> product) {

        productMap.computeIfAbsent(category, k -> new HashMap<>())
                  .computeIfAbsent(subcategory, k -> new ArrayList<>())
                  .addAll(product);

    }

    public void removeProduct(String category, String subcategory, Product product, int count) {
        if (!productMap.isEmpty()) {

            Map<String, List<Product>> subcategories = productMap.get(category);

            if (subcategories != null) {

                List<Product> productList = subcategories.get(subcategory);

                if (productList != null) {
                    for (int i = 0; i < count; i++) {

                        productList.remove(product);
                    }
                }
            }
        }
    }
}
