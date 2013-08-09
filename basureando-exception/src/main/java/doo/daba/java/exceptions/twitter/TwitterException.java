package doo.daba.java.exceptions.twitter;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 9/08/13
 */
public class TwitterException extends RuntimeException {


    public TwitterException() {
        super();
    }


    public TwitterException(String message, Throwable cause) {
        super(message, cause);
    }


    public TwitterException(String message) {
        super(message);
    }


    public TwitterException(Throwable cause) {
        super(cause);
    }
}
