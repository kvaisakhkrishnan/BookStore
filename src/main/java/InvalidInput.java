public class InvalidInput extends Throwable{
    InvalidInput(String type){
        super("Invalid " + type);
    }
}
