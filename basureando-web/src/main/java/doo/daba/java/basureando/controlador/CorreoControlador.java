package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.ErrorBean;
import doo.daba.java.beans.SendMailBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
    public List<ErrorBean> consultaEntradas(@Valid SendMailBean sendMailBean, BindingResult result) {

        List<ErrorBean> errorList = new ArrayList<ErrorBean>();
        BeanPropertyBindingResult beanResult =
                (BeanPropertyBindingResult) result.getModel().get("org.springframework.validation.BindingResult.sendMailBean");

        for(FieldError error : beanResult.getFieldErrors()){
            errorList.add(new ErrorBean(error.getField(), error.getDefaultMessage()));
        }

        return errorList;
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
