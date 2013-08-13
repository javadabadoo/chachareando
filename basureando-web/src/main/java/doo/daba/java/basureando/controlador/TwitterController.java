package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.TwitterSession;
import doo.daba.java.servicio.interfaces.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.portlet.ModelAndView;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 9/08/13
 */
@Controller
@SessionAttributes("twitterSession")
public class TwitterController {

    @Autowired
    private TwitterService twitterService;



//    @ResponseBody
    @RequestMapping(
            value="/json/twitter/autorizationURL",
            method = RequestMethod.GET
    )
    public String getAuthorizationURL(ModelMap modelMap) {
        TwitterSession twitterSession = new TwitterSession(this.twitterService.createRequestToken());
        modelMap.addAttribute("twitterSession", twitterSession);
        modelMap.addAttribute("twitterAuthenticationURL", twitterSession.getAuthorizationURL());

        return "twitter/twitter-authenticate";
    }



    @ResponseBody
    @RequestMapping(
            value="/json/twitter/confirmation",
            method = RequestMethod.POST
    )
    public User setPin(
            @RequestParam String pin,
            @ModelAttribute("twitterSession") TwitterSession twitterSession,
            ModelMap modelMap) {
        Twitter twitter = twitterService.getTwitterInstance();
        User user = null;

        try {
            twitterSession.setAccessToken(twitter.getOAuthAccessToken(
                    twitterSession.getRequestToken(),
                    pin));
            user = twitter.verifyCredentials();
        } catch (TwitterException e) {
//            throw new doo.daba.java.exceptions.twitter.TwitterException(
//                    e.getMessage(),
//                    e.getCause()
//            );
        }

        System.out.println("\t:: " + twitterSession.getAccessToken().getToken());
        System.out.println("\t:: " + twitterSession.getAccessToken().getTokenSecret());

        modelMap.put("twitterSession", twitterSession);

        return user;
    }
}
