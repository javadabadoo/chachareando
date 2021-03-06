package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.FormResponse;
import doo.daba.java.beans.SendMailBean;
import doo.daba.java.beans.ValidationError;
import doo.daba.java.util.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/06/13
 */
@Controller
public class MailController {

    @Autowired
    ApplicationContext applicationContext;



    @ResponseBody
    @RequestMapping(
            value="/mail/send",
            method = RequestMethod.POST
    )
    public FormResponse sendMail(@Valid SendMailBean sendMailBean, BindingResult result) {

        List<ValidationError> errorList = new ArrayList<ValidationError>();
	    FormResponse response = new FormResponse(result.hasErrors(), null, errorList);

        BeanPropertyBindingResult beanResult =
                (BeanPropertyBindingResult) result.getModel().get("org.springframework.validation.BindingResult.sendMailBean");

        for(FieldError error : beanResult.getFieldErrors()){
            errorList.add(new ValidationError(error.getField(), error.getDefaultMessage()));
        }

	    if(! result.hasErrors()) {

//		    Session session = null;

//		    try {
//			    Context context  = new InitialContext();
//			    session = (Session) context.lookup("mail/basureando");
//		    } catch (NamingException e) {
//			    e.printStackTrace();
//			    response.setHasError(true);
//			    response.setResponseMessage(e.getMessage());
//			    return response;
//		    }

            Properties mailProperties = new Properties();
            InputStream placeHolcerInputStream = null;

            try {
                placeHolcerInputStream = applicationContext.getResource("classpath:correo.properties").getInputStream();
                mailProperties.load(placeHolcerInputStream);
            } catch (IOException e) {
                response.setHasError(true);
                response.setResponseMessage(e.getMessage());
            }

            MailSender mailSender = new MailSender(mailProperties);
		    mailSender.addRecipient(sendMailBean.getSentFrom(), MailSender.RECIPIENT);
		    mailSender.setBodyMessage("Correo de prueba enviado desde basureando-web: " + new Date());
		    mailSender.setTitle(sendMailBean.getTitle());

		    try {
			    mailSender.send();
		    } catch (Exception e) {
			    response.setHasError(true);
			    response.setResponseMessage(e.getMessage());
		    }
	    }

        return response;
    }


    @RequestMapping(
            value="/mail/form",
            method = RequestMethod.GET
    )
    public String mailFormView(ModelMap model) {
        model.addAttribute("sendMailBean", new SendMailBean());
        return "lv";
    }

}
