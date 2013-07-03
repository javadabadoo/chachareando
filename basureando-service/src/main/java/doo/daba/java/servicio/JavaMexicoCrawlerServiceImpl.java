package doo.daba.java.servicio;

import doo.daba.java.servicio.interfaces.JavaMexicoCrawlerService;
import doo.daba.java.util.io.HttpContentReader;
import doo.daba.java.util.io.XmlReader;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 3/07/13
 */
@Service
@Scope("prototype")
public class JavaMexicoCrawlerServiceImpl implements JavaMexicoCrawlerService {


    HttpContentReader httpReader = new HttpContentReader();


    @Override
    public String crawl(String url) throws IOException {
        this.httpReader.setUrlLocation(url);
        return this.httpReader.getTextContent();

    }



    @Override
    public void getObjects() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
        builderfactory.setNamespaceAware(true);

        DocumentBuilder builder = builderfactory.newDocumentBuilder();
//        XmlReader xmlReader = new XmlReader(new File("C:\\Users\\xm060ef\\Desktop\\tracker-lite.htm"));
        Document xmlDocument = builder.parse(new File("C:\\Users\\xm060ef\\Desktop\\tracker-lite.htm"));

        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();

        XPathExpression xPathExpression = xPath.compile("//html//body//div//div//div//div//div//div[@id='tracker']//table//tbody//tr");
        NodeList nodeElements =  (NodeList) xPathExpression.evaluate(xmlDocument,XPathConstants.NODESET);

        for(int nodeIndex = 0; nodeIndex < nodeElements.getLength(); nodeIndex++) {
            System.out.println(nodeElements.item(nodeIndex).getBaseURI());
        }
    }


}
