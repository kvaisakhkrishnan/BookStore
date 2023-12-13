public class InvalidBook extends Throwable{
    InvalidBook(String type){
        super("Inavlid " + type);
    }
}
