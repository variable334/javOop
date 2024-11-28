package less1.Actor;

import java.util.HashMap;
import java.util.Map;

public class AddOrders {

   private Map<String,Integer>order;


    public AddOrders() {
        this.order = new HashMap<>();
    }

    public void orderAddProd(String name,int count){

        order.put(name,count);

    }

    public Map<String, Integer> getOrder() {
        return order;
    }
}
