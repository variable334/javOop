package less1;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public abstract class Product {

    protected double price;
    public String vendorcode;
    protected LocalDateTime createData;
    int warranty; // package-privat;
    private List<Integer> grops;


    public Product(double price, LocalDateTime createData, String vendorcode, int warranty) {
        this.price = price;
        this.createData = createData;
        this.vendorcode = vendorcode;
        this.warranty = warranty;
        this.grops = new ArrayList<>();

    }

    public List<Integer> getGrops() {
        return new ArrayList<>(grops);
    }

    public void addgrops(int grop){
        this.grops.add(grop);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductType() {
        return getClass().getSimpleName();
    }




//  переопределения equals,hashcode,toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && warranty == product.warranty && Objects.equals(vendorcode, product.vendorcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, vendorcode, warranty);
    }

    @Override
    public String toString() {
        return getProductType() + "{" +
                "price=" + price +
                ", createData=" + createData +
                ", vendorcode='" + vendorcode + '\'' +
                ", warranty=" + warranty +
                '}';
    }


}
