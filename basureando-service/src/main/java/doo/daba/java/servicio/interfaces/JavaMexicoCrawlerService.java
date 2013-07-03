package doo.daba.java.servicio.interfaces;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 3/07/13
 */
public interface JavaMexicoCrawlerService {

    String crawl(String url) throws IOException;

    void getObjects() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException;

}
