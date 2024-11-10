package less1.typesOfAnimals;

import less1.Animals.MovingAnimals;

public class Cat extends MovingAnimals implements Movement {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void eat(){
        System.out.println(getType() + " я пью молочко из блюдца");
    }


    @Override
    public void move(double speed) {
        System.out.println(getType() + " и хожу со скоростью: " + speed + " км/час");
    }
}
