import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BookListing books = new BookListing();
        UserRegistration users = new UserRegistration();
        OrderProcessing orders = new OrderProcessing();
        while (true){
            System.out.println("Welcome To Book Lending System");
            System.out.println("==============================");
            System.out.println("[1] Register User");
            System.out.println("[2] Add Book");
            System.out.println("[3] Add Book Quantity");
            System.out.println("[4] Lend Book");
            System.out.println("[5] Exit");
            System.out.println("Your Choice: ");
            int choice = scanner.nextInt();
            if(choice == 1){
                try{
                    System.out.println("Enter Username : ");
                    String userName = scanner.next();
                    System.out.println("Enter Password : ");
                    String password = scanner.next();
                    System.out.println("Enter Email : ");
                    String email = scanner.next();
                    System.out.println("Enter Phonenumber : ");
                    String phonenumber = scanner.next();
                    users.addUser(userName, password, email, phonenumber);
                } catch (DuplicateUser e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(choice == 2){
                try{
                    System.out.println("Enter Title: ");
                    String tempTitle = scanner.next();
                    System.out.println("Enter Author: ");
                    String tempAuthor = scanner.next();
                    System.out.println("Enter ISBN: ");
                    String tempISBN = scanner.next();
                    System.out.println("Enter Price: ");
                    String tempPrice = scanner.next();
                    books.addBook(tempTitle, tempAuthor, tempISBN, tempPrice);
                } catch (DuplicateBook e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(choice == 3){
                System.out.println("Enter ISBN: ");
                String isbn = scanner.next();
                System.out.println("Enter Quantity: ");
                String quantity = scanner.next();
                books.addQuantity(isbn, quantity);
            }
            else if(choice == 4){
                try{
                    System.out.println("Enter Username");
                    String username = scanner.next();
                    System.out.println("Enter ISBN");
                    String ISBN = scanner.next();
                    System.out.println("Enter Quantity");
                    String tempQuantity = scanner.next();
                    orders.orderBook(books, users, username, ISBN, tempQuantity);

                } catch (InvalidBook | OutOfStock | InvalidInput e) {
                    System.out.println(e.getMessage());
                }
            }
            else{
                break;
            }
        }
    }
}
