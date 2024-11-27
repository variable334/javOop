package less1.Actor;

public abstract class Actor implements ActorBehaviour {


    protected String name;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;

    public Actor(String name){
        this.name = name;
    }

    public abstract String getName();

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                '}';
    }
}
