import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingCart {
    Product[] chosenProducts;

    public void clearCart() {
        chosenProducts = null;
    }
    public void addItem(Product product) {
        if (chosenProducts == null) chosenProducts = new Product[]{product};
        else {
            Product[] newArray = Arrays.copyOf(chosenProducts, chosenProducts.length + 1);
            newArray[chosenProducts.length] = product;
            chosenProducts = newArray;
        }
    }
    public void removeItem(Product product) {
        if (chosenProducts == null || product == null) return;
        Found : {
            for (var p : chosenProducts) {
                if (p.equals(product)) break Found;
            }
            return;
        }
        Product[] newArray = new Product[chosenProducts.length - 1];
        for (int i = 0, j = 0; i < chosenProducts.length; i++) {
            if (chosenProducts[i].equals(product)) continue;
            newArray[j++] = chosenProducts[i];
        }
        chosenProducts = newArray;
    }
}
