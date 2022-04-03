package sortedCollections.shopingBasket;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityStock;
    private CountryCurrency currency;

    private enum CountryCurrency {
        POUNDS("\u20ac"),
        EURO("\u20AC");

        private String currencyRegEx;
        CountryCurrency(String regEx) {
            this.currencyRegEx  = regEx;
        }
    }

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int quantityInStock() {
        return this.quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public void adjustStock(int quantity) {
        if((this.quantityStock + quantity) > 0) {
            this.quantityStock+= quantity;
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if (obj == this) {
            return true;
        }

        if ((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        }

        return this.name.equals(((StockItem) obj).getName());
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering stockItem.compareTo");
        if (this == o) {
            return 0;
        }

        if (o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + CountryCurrency.POUNDS.currencyRegEx.translateEscapes() +" " + this.price;
    }
}
