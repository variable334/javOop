package less1.Actor;

import less1.Product.Product;

import javax.xml.namespace.QName;
import java.util.*;

public class Market implements QueueBehaviour, MarketBehaviourt {

    private List<Actor> actors = new ArrayList<>();

    private ArrayDeque<Actor> queue;

    private Map<Product, Integer> orders;

    private Map<String, Map<String, List<Product>>> productMap;

    protected Human human;

    private UserScaner userScaner;


    public Market(Map<String, Map<String, List<Product>>> productMap) {
        this.productMap = productMap;
        this.orders = new HashMap<>();
        this.queue = new ArrayDeque<>();
    }

    public Market() {
        this.actors = new ArrayList<>();
        this.queue = new ArrayDeque<>();
        this.orders = new HashMap<>();
        this.userScaner = new UserScaner();

    }


    public Map<String, Map<String, List<Product>>> getProductMap() {
        return productMap;
    }



    public List<Actor> getActors() {
        return actors;
    }

    public ArrayDeque<Actor> getQueue() {
        return queue;
    }

    @Override
    public void acceptToMarket(Human human) {

        actors.add(human);

    }



    @Override
    public void releaseFromMarket(List<Actor> actors) {
        if (actors.size() > 0) {
            actors.remove(0);
        }
    }

    @Override
    public void update() {

        Map<Product, Integer> orders = getOrders();
        for (Product product : orders.keySet()) {

            if (!productMap.isEmpty()) {
                String findCategory = findCategory(product);
                Map<String, List<Product>> subcategories = productMap.get(findCategory);

                if (subcategories != null) {
                    String subcategory = findSubcategory(findCategory, product);

                    List<Product> productList = subcategories.get(subcategory);

                    if (productList != null) {

                        for (int i = 0; i < orders.get(product); i++) {
                            productList.remove(product);
                        }
                    }
                }
            } else {
                System.out.println("Список пуст");
            }
        }

    }

    public String findCategory(Product product) {
        for (String category : productMap.keySet()) {
            Map<String, List<Product>> subcategories = productMap.get(category);
            if (subcategories != null) {
                for (List<Product> productList : subcategories.values()) {
                    if (productList.contains(product)) {
                        return category;
                    }
                }
            }
        }
        return null;
    }


    public String findSubcategory(String category, Product product) {
        if (category != null && productMap.containsKey(category)) {
            Map<String, List<Product>> subcategories = productMap.get(category);
            if (subcategories != null) {
                for (Map.Entry<String, List<Product>> entry : subcategories.entrySet()) {
                    if (entry.getValue().contains(product)) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void takeInQueue(Actor actor) {
        this.queue.addFirst(actor);
    }

    @Override
    public Map<Product, Integer> takeOrders(Map<Product, Integer> order) {

            order.forEach((product, count) -> {
                orders.put(product, count);
            });
            return orders;

    }


    public Map<Product, Integer> getOrders() {
        return orders;
    }

    @Override
    public void giveOrders() {

            getOrders();
//            update();
            orders.clear();
            releaseFromQueue();
        }





    @Override
    public void releaseFromQueue() {
        queue.poll();
    }



}
