package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.TagsJsonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 4/08/13
 */
@Controller
public class TagsController {



    @ResponseBody
    @RequestMapping(
            value="/tags/list",
            method = RequestMethod.GET
    )
    public TagsJsonResponse[] displayAllPosts(ModelMap model) {
        TagsJsonResponse[] tags = new TagsJsonResponse[5];

        tags[0] = new TagsJsonResponse("0", "Java", "Java");
        tags[1] = new TagsJsonResponse("1", "Groovy", "Groovy");
        tags[2] = new TagsJsonResponse("2", "Scala", "Scala");
        tags[3] = new TagsJsonResponse("3", "Spring", "Spring");
        tags[4] = new TagsJsonResponse("4", "Hibernate", "Hibernate");

        return tags;
    }

}
