package less1.productsTechnic;

import java.util.Objects;

public class Laptop extends Technic{
    public int hdd;
    private int ram;
    private String os;


    public Laptop(String nameModel, int price,int hdd,int ram,String os){
        super(nameModel, price);
        this.hdd=hdd;
        this.ram=ram;
        this.os=os;
    }


    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public int getRam() {
        return ram;
    }

//  переопределение equals,hascode,toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return hdd == laptop.hdd && ram == laptop.ram && Objects.equals(os, laptop.os);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hdd, ram, os);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "nameModel = " + nameModel +
                ", price = '" + price + '\'' +
                ", ram = " + ram +
                ", os = '" + os + '\'' +
                ", hdd = " + hdd +
                '}';
    }








}


