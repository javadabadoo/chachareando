package doo.daba.java.test.servicio;

import doo.daba.java.servicio.interfaces.JavaMexicoCrawlerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 3/07/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:chachareando-context.xml"
})
public class JavaMexicoCrawlerTest {

    @Autowired
    private JavaMexicoCrawlerService crawler;
    private String content;



    @Before
    public void init() throws IOException {
//        this.content = this.crawler.crawl("http://www.javamexico.org/tracker");
    }



    @Test
    public void testCrawler() throws Exception {
//        assert this.content != null;
//        assert ! this.content.isEmpty();

        this.crawler.getObjects();
    }

}
