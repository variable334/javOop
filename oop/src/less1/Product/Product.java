package less1.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public abstract class Product {

    protected String name;
    protected double price;
    protected LocalDate createData;
    protected int warranty;



    public Product(String name, double price, LocalDate createData,int warranty) {
        this.name = name;
        this.price = price;
        this.createData = createData;
        this.warranty = warranty;

    }

    public Product(String name) {
        this.name = name;
    }


// getter

    public abstract String getName();

    public abstract LocalDate getCreateData();

    public abstract double getPrice();

    public abstract int getWarranty();







}
