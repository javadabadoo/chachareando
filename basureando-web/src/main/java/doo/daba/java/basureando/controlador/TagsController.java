package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.TagsJsonResponse;
import doo.daba.java.servicio.interfaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 4/08/13
 */
@Controller
public class TagsController {

    @Autowired
    private TagService tagService;



    @ResponseBody
    @RequestMapping(
            value="/tags/list",
            method = RequestMethod.GET
    )
    public List<TagsJsonResponse> displayAllPosts(@RequestParam("term") String tag) {
        return this.tagService.findRelatedTags(tag);
    }

}
