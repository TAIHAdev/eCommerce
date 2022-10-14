import java.util.Arrays;

public class User {
    private final String userName;
    private final String password;
    ShoppingCart shoppingCart;
    String address;
    Payment payment;
    static User[] users;
    public User(String userName, String password, String address) {
        this.userName = userName;
        this.password = password;
        shoppingCart = new ShoppingCart();
        this.address = address;
        addUser();
    }

    public double getTotal() {
        double total = 0;
        for (Product product : shoppingCart.chosenProducts) {
            total += product.getPrice();
        }
        return total + getShippingPrice();
    }

    public void addUser() {
        if (users == null) {
            users = new User[]{this};
            return;
        }
        User[] newArray = new User[users.length + 1];
        for (int i = 0; i < users.length; i++) {
            if (users[i].userName.equals(userName)) return;
            newArray[i] = users[i];
        }
        newArray[users.length] = this;
        users = newArray;
    }
    public static User getUser(String userName, String password) {
        for (User u : users) {
            if (u.userName.equals(userName) && u.password.equals(password)) return u;
        }
        return null;
    }

    public double getShippingPrice() {
        //simple price calculator
        if (address.contains("Australia")) return 5;
        else if (address.contains("USA")) return 20;
        else if (address.contains("Vietnam")) return 10;
        else return 100;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", shoppingCart=" + shoppingCart +
                ", address='" + address + '\'' +
                ", payment=" + payment +
                '}';
    }
}
