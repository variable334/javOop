package less1.Actor;

public class Human extends Actor{


    public Human(String name) {
        super(name);
        this.name = name;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean setMakeOrder(boolean flag) {
        return this.isMakeOrder = flag;
    }

    @Override
    public boolean setTakeOrder(boolean flag) {
        return this.isTakeOrder = flag;

    }

//    @Override
//    public boolean isMakeOrder(boolean flag) {
//        return isMakeOrder;
//    }
//
//    @Override
//    public boolean isTakeOrder() {
//        return isTakeOrder;
//    }

}
