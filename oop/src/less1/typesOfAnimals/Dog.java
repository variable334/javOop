package less1.typesOfAnimals;

import less1.Animals.MovingAnimals;

public  class Dog extends MovingAnimals implements Movement {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void eat(){
        System.out.println(getType()+ " я кушаю с миски");
    }


    @Override
    public void move(double speed) {
        System.out.println(getType()+ " и хожу со скоростью: " + speed + " км/час");
    }
}
