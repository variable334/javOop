package less1.Animals;

public abstract class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType(){
        return getClass().getSimpleName();
    }

    public abstract void eat();




}
