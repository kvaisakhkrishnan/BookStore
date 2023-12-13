public class Order {
    String username;
    String ISBN;
    int quantity;
    Order(String username, String ISBN, int quantity){
        this.username = username;
        this.ISBN = ISBN;
        this.quantity = quantity;
        System.out.println("Book Lent Successfully");
    }
}
