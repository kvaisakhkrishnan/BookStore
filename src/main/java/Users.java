import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Users {
    String username;
    String password;
    String useremail;
    String phonenumber;
    Users(String username, String password, String useremail, String phonenumber) throws InvalidInput {
        Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9_]+");
        Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        Pattern useremailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Pattern phoneNumberPattern = Pattern.compile("^[0-9]{10}$");
        Matcher usernameMatcher = usernamePattern.matcher(username);
        if(usernameMatcher.matches()){
            this.username = username;
        }
        else{
            throw new InvalidInput("Username");
        }
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if(passwordMatcher.matches()){
            this.password = password;
        }
        else{
            throw new InvalidInput("Password");
        }
        Matcher emailMatcher = useremailPattern.matcher(useremail);
        if(emailMatcher.matches()){
            this.useremail = useremail;
        }
        else{
            throw new InvalidInput("Email");
        } Matcher phoneMatcher = phoneNumberPattern.matcher(phonenumber);
        if(phoneMatcher.matches()){
            this.phonenumber = phonenumber;
        }
        else{
            throw new InvalidInput("Phonenumber");
        }
    }
}
