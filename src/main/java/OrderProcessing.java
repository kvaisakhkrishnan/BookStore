import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderProcessing {
    ArrayList<Order> orders;
    OrderProcessing(){
        orders = new ArrayList<>();
    }
    void orderBook(BookListing books, UserRegistration users, String username, String ISBN, String tempQuantity) throws InvalidInput, InvalidBook, OutOfStock {
        int quantity;
        Scanner scanner = new Scanner(System.in);
        Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9_]+");
        Pattern isbnPattern = Pattern.compile("[0-9]{3}-[0-9]{2}-[0-9]{5}-[0-9]{2}-[0-9]");
        Pattern quantityPattern = Pattern.compile("[0-9]+");
        Matcher usernameMatcher = usernamePattern.matcher(username);
        if(usernameMatcher.matches()){
            boolean checkUser = false;
            for(Users user : users.registeredUsers){
                checkUser = true;
                Matcher isbnMatcher = isbnPattern.matcher(ISBN);
                boolean flag = false;
                if(isbnMatcher.matches()){
                    for(Book book : books.books){
                        if(book.ISBN.equals(ISBN)){
                            flag = true;
                            Matcher quantityMatcher = quantityPattern.matcher(tempQuantity);
                            if(quantityMatcher.matches()){
                                quantity = Integer.parseInt(tempQuantity);
                                if(quantity > book.quantity){
                                    throw new OutOfStock();
                                }
                                else{
                                    Order order = new Order(username, ISBN, quantity);
                                    this.orders.add(order);
                                    book.quantity -= quantity;
                                }
                            }
                            else{
                                System.out.println("Invalid Quantity");
                            }
                        }
                    }
                    if(!flag){
                        System.out.println("Book Not Found");
                    }
                }
                else{
                    throw new InvalidBook("ISBN");
                }
            }
            if(checkUser == false){
                System.out.println("User Not Found");
            }
        }
        else{
            throw new InvalidInput("Username");
        }

    }
}
