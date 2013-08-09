package doo.daba.java.servicio;

import doo.daba.java.servicio.interfaces.TwitterService;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 9/08/13
 */
@Service
public class TwitterServiceImpl implements TwitterService {


    @Override
    public RequestToken createRequestToken() {
        Twitter twitter = TwitterFactory.getSingleton();
        RequestToken requestToken = null;

        try {
            requestToken = twitter.getOAuthRequestToken();
        } catch (TwitterException ex) {
            throw new doo.daba.java.exceptions.twitter.TwitterException(
                    ex.getMessage(),
                    ex.getCause());
        }

        return requestToken;
    }
}
