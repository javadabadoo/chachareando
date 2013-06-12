package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.FormResponse;
import doo.daba.java.beans.ValidationError;
import doo.daba.java.beans.SendMailBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/06/13
 */
@Controller
public class CorreoControlador {





    @ResponseBody
    @RequestMapping(
            value="/mail/send",
            method = RequestMethod.GET
    )
    public FormResponse sendMail(@Valid SendMailBean sendMailBean, BindingResult result) {

        List<ValidationError> errorList = new ArrayList<ValidationError>();

        BeanPropertyBindingResult beanResult =
                (BeanPropertyBindingResult) result.getModel().get("org.springframework.validation.BindingResult.sendMailBean");

        for(FieldError error : beanResult.getFieldErrors()){
            errorList.add(new ValidationError(error.getField(), error.getDefaultMessage()));
        }

        return new FormResponse(result.hasErrors(), null, errorList);
    }


    @RequestMapping(
            value="/mail/form",
            method = RequestMethod.GET
    )
    public String formulario(ModelMap model) {
        model.addAttribute("sendMailBean", new SendMailBean());
        return ("lv");
    }

}
