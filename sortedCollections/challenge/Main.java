package sortedCollections.challenge;

public class Main {

/* Modify the program so that adding items to the shopping basket doesn't actually reduce the shopping count
   but, instead, reserve the requested number of items.

   You will need to add a "reserved" field to the StockItem class to store the number of items reserved.

   Items can continue to be added to the basket, but it should not be possible to reserve more than the available
   stock of any item. An item's available stock is the stock count less the reserved amount.

   The stock count for each item is reduced when a basket is checked out, at which point all reserved items
   in the basket have their actual stock count reduced.

   Once checkout is complete, the contents are cleared.

   It should also be possible to "unreserved" items that were added to the basket by mistake.
 */

    private static final StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem stockItem = new StockItem("bread", 0.86, 100);
        stockList.addStock(stockItem);

        stockItem = new StockItem("cheese", 0.89, 50);
        stockList.addStock(stockItem);

        stockItem = new StockItem("cake", 2, 5);
        stockList.addStock(stockItem);

        stockItem = new StockItem("cookies", 0.8, 20);
        stockList.addStock(stockItem);

        System.out.println(stockList);
        System.out.println("\nItems in Basket");
        stockList.Items().keySet().forEach(item -> System.out.println("\t" + item));

        Basket userBasket = new Basket("User1");
        sellItem(userBasket, "bread", 2);
        removeItem(userBasket, "bread", 1);
        System.out.println(userBasket);

        userBasket = new Basket("User2");
        sellItem(userBasket, "cake", 10);
        System.out.println(userBasket);

        userBasket = new Basket("User3");
        sellItem(userBasket, "bread", 4);
        System.out.println(userBasket);

        sellItem(userBasket, "books", 2);
        System.out.println(userBasket);

        userBasket = new Basket("User2");
        sellItem(userBasket, "cake", 4);
        System.out.println(userBasket);

        userBasket = new Basket("User3");
        sellItem(userBasket, "bread", 2);
        sellItem(userBasket, "cheese", 2);
        sellItem(userBasket, "bread", 2);
        sellItem(userBasket, "cookies", 2);
        removeItem(userBasket, "bread", 2);
        System.out.println(userBasket);

        System.out.println(stockList);

        System.out.println("\nPriceList for Items");
        stockList.priceList().forEach((key, price) ->
                System.out.println("\t" + key + " costs " +
                        StockItem.CountryCurrency.POUNDS.currencyRegEx.translateEscapes()
                        + String.format("%.2f",price)));

//        Below commented code is for demo purpose, this code proves only the list by itself is unmodifiable
//        and the items in it are modifiable

//        stockList.Items().forEach((key, item) -> {
//            item.setPrice(200000);
//            System.out.println("9999999999999999999");
//            System.out.println(item);
//        });


        System.out.println("\nDisplaying stock list before checkout\n");
        System.out.println(userBasket);
        System.out.println(stockList);
        checkout(userBasket);
        System.out.println("\nDisplaying stock list after checkout\n");
        System.out.println(userBasket);
        System.out.println(stockList);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("\nWe don't sell " + item);
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // retrieve item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unReserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkout(Basket basket) {
        basket.Items().forEach((item, quantity) ->
                stockList.sellStock(item.getName(), quantity));
        basket.clearBasket();
    }
}
