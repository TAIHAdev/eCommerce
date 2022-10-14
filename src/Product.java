import java.util.Arrays;
import java.util.Objects;

public class Product {
    static long nextId = 0;
    final long id = nextId++;
    Size size;
    String color;
    String manufacturer; // can make another manufacturer class containing name, contract, and promotion
    String productName;
    Review[] reviews;
    double price;
    static Product[] stocks;

    public Product(String manufacturer, String productName, double price, Size size, String color) {
        this.manufacturer = manufacturer;
        this.productName = productName;
        this.price = price;
        this.size = size;
        this.color = color;
        addToStock();
    }

    public void addReview(Review review) {
        if (reviews == null) reviews = new Review[]{review};
        else {
            int newLength = reviews.length + 1;
            Review[] newArray = Arrays.copyOf(reviews, newLength);
            newArray[newLength - 1] = review;
            reviews = newArray;
        }
    }
    public void addToStock() {
        if (stocks == null) {
            stocks = new Product[]{this};
            return;
        }
        Product[] products = new Product[stocks.length + 1];
        for (int i = 0; i < stocks.length; i++) {
            products[i] = stocks[i];
        }
        products[stocks.length] = this;
        stocks = products;
    }



    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", productName='" + productName + '\'' +
                ", reviews=" + Arrays.toString(reviews) +
                ", price=" + price +
                '}';
    }


}
