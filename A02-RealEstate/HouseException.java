/**
 * Catches exceptions in the House class and prints an unique exception message
 * @author    David Pavlicek
 */
public class HouseException extends Exception{
    String message = "An exception has occurred"; //Stores unique exception message

    HouseException(){

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
