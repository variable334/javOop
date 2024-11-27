package less1.Product.Fruits;

import less1.Product.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;



public class Fruits extends Product {

    protected double weight;

    public Fruits(String name, double price, LocalDate createData, int warranty, double weight) {
        super(name, price, createData, warranty);
        this.weight = weight;
        this.name = name;
        this.price = price;
        this.createData = createData;
        this.warranty = warranty;
    }

    public Fruits(String name) {
        super(name);
    }

    public double getWeight() {
        return weight;
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


    @Override
    public String toString() {
        return "name'" + name + '\'' +
                ", price=" + price +
                ", createData=" + createData +
                ", warranty=" + warranty +
                ", weight=" + weight +
                '}';
    }



}
