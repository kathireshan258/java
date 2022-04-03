package sortedCollections.shopingBasket;

public class Main {
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

        System.out.println(stockList);

        System.out.println("\nPriceList for Items");
        stockList.priceList().forEach((key, price) ->
                System.out.println("\t" + key + " costs " + String.format("%.2f",price)));

//        Below commented code is for demo purpose, this code proves only the list by itself is unmodifiable
//        and the items in it are modifiable

//        stockList.Items().forEach((key, item) -> {
//            item.setPrice(200000);
//            System.out.println("9999999999999999999");
//            System.out.println(item);
//        });
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("\nWe don't sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
