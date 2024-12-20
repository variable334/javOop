package less1.productsTechnic;

import java.util.Objects;

public class Technic {

    protected String nameModel;
    protected int price;


    public Technic(String nameModel, int price) {
        this.nameModel = nameModel;
        this.price = price;
    }


    public String getTechnicType() {
        return getClass().getSimpleName();
    }


    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNameModel() {
        return nameModel;
    }

    public int getPrice() {
        return price;
    }

    /* переопределение euquals, hashCode, toString */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technic technic = (Technic) o;
        return price == technic.price && Objects.equals(nameModel, technic.nameModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameModel, price);
    }


    @Override
    public String toString() {
        return getTechnicType() + "{" +
                " nameModel = '" + nameModel + '\'' +
                ", price = " + price +
                '}';
    }
}
