package less1.Actor;

import less1.Product.Product;

import java.util.List;
import java.util.Map;

public interface MarketBehaviourt {

    void acceptToMarket(Human human);

    void releaseFromMarket(List<Actor> actors);

    void update();
}
