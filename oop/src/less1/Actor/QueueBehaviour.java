package less1.Actor;

import less1.Product.Product;

import java.util.List;
import java.util.Map;

public interface QueueBehaviour  {


    void takeInQueue(Actor actor);

    Map<Product, Integer> takeOrders(Map<Product, Integer> orders);

    void giveOrders();

    void releaseFromQueue();


}
