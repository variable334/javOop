package less1.Product.MarketForProducts;

import less1.Product.Product;

import java.util.List;

public interface addProduct {

    void addProduct(List<Product> product);

    void addProducts(String category,String subcategory, List<Product> products);

}
