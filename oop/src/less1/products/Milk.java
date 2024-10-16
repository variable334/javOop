package less1.products;

import less1.Product;

import java.time.LocalDateTime;

public class Milk extends Product {
    public String color;

    public Milk(double price,LocalDateTime createData, String vendorcode, int warranty,String color) {
        super(price,createData, vendorcode, warranty);
        this.color=color;
    }

    @Override
    public String getProductType() {
        return getClass().getSimpleName();
    }
}
