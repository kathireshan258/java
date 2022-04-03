package sortedCollections.shopingBasket;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // check if already have quantities of this item, if not take the passed item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // If there are already stock on this item, adjust this item, adjust the quantity
            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> priceList() {
        Map<String, Double> priceList = new LinkedHashMap<>();
        list.forEach((key, price) -> {
            priceList.put(key, price.getPrice());
        });
        return Collections.unmodifiableMap(priceList);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        final String[] s = {"\nStock List\n"};
        final double[] totalCost = {0.0};
        list.entrySet().forEach(item -> {   // here instead of .entrySet() we can directly use .forEach()
                    StockItem stockItem = item.getValue();
                    double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

                    s[0] = s[0] + stockItem + ". There are " + stockItem.quantityInStock() + " in stock.";
                    s[0] = s[0] + " Value of items: " + String.format("%.2f",itemValue) + "\n";
                    totalCost[0] += itemValue;
                }
                );
        return s[0] + "Total stock value " + totalCost[0];
    }
}
