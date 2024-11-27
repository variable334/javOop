package less1.Product.Vegetables;

import less1.Product.Product;

import java.time.LocalDate;

public class Vegetables extends Product {
    private double weight;

    public Vegetables(String name, double price, LocalDate createData, int warranty,double weight) {
        super(name, price, createData, warranty);
        this.name = name;
        this.price = price;
        this.createData = createData;
        this.warranty = warranty;
        this.weight = weight;
    }

    public Vegetables(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getCreateData() {
        return createData;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getWarranty() {
        return warranty;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", price=" + price +
                ", createData=" + createData +
                ", warranty=" + warranty +
                ", weight=" + weight +
                '}';
    }
}
