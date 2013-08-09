package doo.daba.java.beans;

import lombok.Getter;
import lombok.Setter;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 9/08/13
 */
public class TwitterSession {

    @Getter @Setter
    private AccessToken accessToken;

    @Getter @Setter
    private RequestToken requestToken;


    public TwitterSession(RequestToken requestToken) {
        this.requestToken = requestToken;
    }


    public TwitterSession(String accessToken, String accessTokenSecret) {
        this.setCredentials(accessToken, accessTokenSecret);
    }

    public void setCredentials(String accessToken, String accessTokenSecret) {
        this.accessToken = new AccessToken(accessToken, accessTokenSecret);
    }

    public String getAuthorizationURL() {
        return this.requestToken.getAuthorizationURL();
    }
}
