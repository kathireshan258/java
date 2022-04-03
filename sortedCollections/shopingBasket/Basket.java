package sortedCollections.shopingBasket;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        final String[] s = {"\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n"};
        final double[] totalCost = {0.0};
        list.forEach((item, quantity) -> {
            s[0] = s[0] + item + ". " + quantity + " purchased\n";
            totalCost[0] += item.getPrice() * quantity;
        });
        return s[0] + "Total cost " + totalCost[0];
    }
}
