import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {
    String title;
    String author;
    String ISBN;
    String price;
    int quantity;
    Book(String title, String author, String ISBN, String price) throws InvalidBook {
        Pattern titlePattern = Pattern.compile("[a-zA-Z0-9\\s]+");
        Pattern authorPattern = Pattern.compile("[a-zA-Z0-9\\s]+");
        Pattern isbnPattern = Pattern.compile("[0-9]{3}-[0-9]{2}-[0-9]{5}-[0-9]{2}-[0-9]");
        Pattern pricePattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        Matcher titleMatcher = titlePattern.matcher(title);
        if(titleMatcher.matches()){
            this.title = title;
        }
        else{
            throw new InvalidBook("Title");
        }
        Matcher authorMatcher = authorPattern.matcher(author);
        if(authorMatcher.matches()){
            this.author = author;
        }
        else{
            throw new InvalidBook("Author");
        }
        Matcher isbnMatcher = isbnPattern.matcher(ISBN);
        if(isbnMatcher.matches()){
            this.ISBN = ISBN;
        }
        else{
            throw new InvalidBook("ISBN");
        }
        Matcher priceMatcher = pricePattern.matcher(price);
        if(priceMatcher.matches()){
            this.price = price;
        }
        else{
            throw new InvalidBook("Price");
        }
        this.quantity = 0;
    }

}
