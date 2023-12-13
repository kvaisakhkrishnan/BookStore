import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestCases {
    @Test
    public void TestHappyUserInputValidation(){
        try{
            Users user = new Users("Vaisakh", "Password@1", "kvaisakhkrishnan@gmail.com", "8129348583");
            assertEquals(user.username, "Vaisakh");
            assertEquals(user.password, "Password@1");
            assertEquals(user.useremail, "kvaisakhkrishnan@gmail.com");
            assertEquals(user.phonenumber, "8129348583");
            UserRegistration users = new UserRegistration();
            users.addUser("Vaisakh", "Password@1", "kvaisakhkrishnan@gmail.com", "8129348583");
            users.addUser("Vaisakh", "Password@1", "kvaisakhkrishnan@gmail.com", "8129348583");
            fail("User Registered Twice");
        }
        catch(InvalidInput | DuplicateUser err){
            System.out.println(err.getMessage());
        }
    }

    @Test
    public void TestSadUserInputValidation() {
        try{
            Users user = new Users("Vaisakh", "Password", "kvaisakhkrishnan@gmail.com", "8129348583");
            fail("Invalid Password");
        }
        catch(InvalidInput err){
            System.out.println(err.getMessage());
        }
        try{
            Users user = new Users("Vaisakh", "Password@1", "gmail.com", "8129348583");
            fail("Invalid Email");
        }
        catch(InvalidInput err){
            System.out.println(err.getMessage());
        }
        try{
            Users user = new Users("Vaisakh", "Password@1", "kvaisakhkrishnan@gmail.com", "812934853");
            fail("Invalid Password");
        }
        catch(InvalidInput err){
            System.out.println(err.getMessage());
        }
    }

    @Test
    public void TestHappyMoodInputValidator(){
        try{
            Book book = new Book("Introduction", "Some", "111-11-11111-11-1", "100");
            BookListing books = new BookListing();
            books.addBook("Introduction", "Author","211-11-11111-11-1","100");
            books.addBook("Introduction", "Author","211-11-11111-11-1","100");
            fail("Book Already Exists");
        } catch (InvalidBook | DuplicateBook e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void TestSadMoodInputValidator(){
        try{
            Book book = new Book("Introduction", "Some", "111-11-11111-11", "100");
            fail("Invalid ISBN");
        } catch (InvalidBook e) {
            System.out.println(e.getMessage());
        }
    }



    @Test
    public void TestHappyOrderTest(){
        UserRegistration users = new UserRegistration();
        BookListing books = new BookListing();
        OrderProcessing orders = new OrderProcessing();
        try{
            users.addUser("Vaisakh", "Password@1", "kvaisakhkrishnan@gmail.com", "8129348583");
            books.addBook("Introduction", "Some","211-11-11111-11-1","100");
            books.addQuantity("211-11-11111-11-1", "10");
            orders.orderBook(books, users, "Vaisakh", "211-11-11111-11-1", "10");
            orders.orderBook(books, users, "Vaisakh", "211-11-11111-11-1", "10");
            fail("Not Enough Stock");
        } catch (DuplicateUser | DuplicateBook | InvalidBook | OutOfStock | InvalidInput e) {
            System.out.println(e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"211-11-11111-11-1", "111-11-11111-11-1"})
    public void TestOrderCases(String ISBN){
        UserRegistration users = new UserRegistration();
        BookListing books = new BookListing();
        OrderProcessing orders = new OrderProcessing();
        try{
            users.addUser("Vaisakh", "Password@1", "kvaisakhkrishnan@gmail.com", "8129348583");
            books.addBook("Introduction", "Some","211-11-11111-11-1","100");
            books.addQuantity("211-11-11111-11-1", "10");
            orders.orderBook(books, users, "Vaisakh", ISBN, "10");
            orders.orderBook(books, users, "Vaisakh", ISBN, "10");
        } catch (InvalidBook | DuplicateUser | OutOfStock | InvalidInput | DuplicateBook e) {
            System.out.println(e.getMessage());
        }
    }




}
