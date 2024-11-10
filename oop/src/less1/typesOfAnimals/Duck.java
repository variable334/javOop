package less1.typesOfAnimals;

import less1.Animals.FluingAnimal;

public class Duck extends FluingAnimal implements Swimmabl, Movement {
    public Duck(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void eat() {
        System.out.println(getType()+ " щипаю травку");
    }

    @Override
    public void fly() {
        System.out.println(getType()+ " летаю");
    }

    @Override
    public void swimm(double speed) {
        System.out.println(getType() +" " + "и плаваю со скоростью " + speed + " узлов");
    }


    @Override
    public void move(double speed) {
        System.out.println(getType() + " я хожу со скоростью: " + speed);
    }



    @Override
    public String toString() {
        return getType() +
                "name='" + name + '\'' +
                '}';
    }
}
