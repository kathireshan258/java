package sortedCollections.challenge;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityInStock;
    private int reserved = 0;
    private CountryCurrency currency;

    enum CountryCurrency {
        POUNDS("\u20ac"),
        EURO("\u20AC");

        final String currencyRegEx;
        CountryCurrency(String regEx) {
            this.currencyRegEx  = regEx;
        }
    }

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;
    }

    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int availableQuantity() {
        return this.quantityInStock - this.reserved;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void adjustStock(int quantity) {
        if((this.quantityInStock + quantity) > 0) {
            this.quantityInStock += quantity;
        }
    }

    public int reserveStock(int quantity) {
        if (quantity <= availableQuantity()) {
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unReserveStock(int quantity) {
        if (quantity <= reserved) {
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public int finalizeStock(int quantity) {
            if (quantity <= reserved) {
                quantityInStock -= quantity;
                reserved -= quantity;
                return quantity;
            }
            return 0;
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
        return this.name + " : price " + CountryCurrency.POUNDS.currencyRegEx.translateEscapes() +" " + this.price
                + ". Reserved: " + this.reserved;
    }
}
