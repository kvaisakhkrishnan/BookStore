import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    ArrayList<Users> registeredUsers;
    UserRegistration(){
        registeredUsers = new ArrayList<>();
    }
    void addUser(String userName, String password, String email, String phonenumber) throws DuplicateUser{
        try{
            Users user = new Users(userName, password, email, phonenumber);
            for(Users tempUser : this.registeredUsers){
                if(tempUser.username.equals(user.username) || tempUser.phonenumber.equals(user.phonenumber)){
                    throw new DuplicateUser();
                }
            }
            this.registeredUsers.add(user);
            System.out.println("User Registered Succesfully");
        }
        catch(InvalidInput error){
            System.out.println(error.getMessage());
        }

    }
}
