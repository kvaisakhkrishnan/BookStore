import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookListing {
    ArrayList<Book> books;
    BookListing(){
        books = new ArrayList<>();
    }
    void addBook(String tempTitle, String tempAuthor, String tempISBN, String tempPrice) throws DuplicateBook{
        try{
            Book book = new Book(tempTitle, tempAuthor, tempISBN, tempPrice);
            for(Book tempBook : books){
                if(tempBook.ISBN.equals(book.ISBN)){
                    throw new DuplicateBook();
                }
            }
            books.add(book);
            System.out.println("Book Added Succesfully");
        }
        catch(InvalidBook err){
            System.out.println(err.getMessage());
        }
    }

    void addQuantity(String isbn, String quantity){
        Pattern quantityPattern = Pattern.compile("[0-9]+");
        Matcher quantityMatcher = quantityPattern.matcher(quantity);
        boolean flag = false;
        if(quantityMatcher.matches()){
            for(Book book : this.books){
                if(book.ISBN.equals(isbn)){
                    flag = true;
                    book.quantity += Integer.parseInt(quantity);
                    System.out.println("Quantity Updated");
                }
            }
            if(!flag){
                System.out.println("ISBN not found");
            }
        }
        else{
            System.out.println("Invalid Quantity");
        }
    }
}
