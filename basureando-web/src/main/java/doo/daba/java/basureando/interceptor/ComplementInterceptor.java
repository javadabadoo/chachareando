package doo.daba.java.basureando.interceptor;

import doo.daba.java.servicio.interfaces.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 8/08/13
 */
@Component
public class ComplementInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserPostService userPostService;


    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) {

        modelAndView.getModelMap().addAttribute(
                "recentEntries",
                this.userPostService.getRecentEntries());

        modelAndView.getModelMap().addAttribute(
                "recentComments",
                this.userPostService.getRecentComments());

    }

}
