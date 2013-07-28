package doo.daba.java.beans;

import doo.daba.java.beans.util.JsonFechaSerializador;
import lombok.Getter;
import lombok.Setter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import lombok.AccessLevel;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 4/6/13
 */
public class UserPost {

    @Getter @Setter
    private int
		    id;

    @Getter @Setter(AccessLevel.PUBLIC)
    private String
            status,
            content,
		    title;

	@JsonSerialize(using=JsonFechaSerializador.class)
    @Getter @Setter
	private Date
            publicationDate,
			modificacionDate;

	@Getter @Setter
	private char publicationType;

    @Getter @Setter
    private User user;


    public String getEncodedTitle() {
        String encodedTitle = null;
        try {
            encodedTitle = URLEncoder.encode(this.title, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encodedTitle;
    }

}
