package less1.products;

import less1.Product;

import java.time.LocalDateTime;

public class Water extends Product {
    public boolean isParkling;

    public Water(double price,LocalDateTime createData, String vendorcode, int warranty,boolean isParkling) {
        super(price,createData,vendorcode, warranty);
        this.isParkling = isParkling;
    }

    @Override
    public String getProductType() {
        return getClass().getSimpleName();
    }
}
