package doo.daba.java.servicio.interfaces;

import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.auth.RequestToken;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 9/08/13
 */
@Service
public interface TwitterService {

    RequestToken createRequestToken();

    Twitter getTwitterInstance();

}
