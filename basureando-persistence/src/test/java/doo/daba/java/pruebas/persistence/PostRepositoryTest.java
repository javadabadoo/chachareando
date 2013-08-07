package doo.daba.java.pruebas.persistence;

import doo.daba.java.beans.User;
import doo.daba.java.beans.UserPost;
import doo.daba.java.persistence.UserPostDao;
import doo.daba.java.persistence.criteria.CriterionImpl;
import doo.daba.java.persistence.criteria.enums.EntradaSearchCriteriaEnum;
import doo.daba.java.persistence.paginator.Page;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 16/05/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:chachareando-context.xml"
})
@Transactional
public class PostRepositoryTest {

    @Autowired
    UserPostDao userPostDao;
    UserPost post;
	private SimpleDateFormat dateFormat;


    @Before
    public void init() {
        this.post = new UserPost();

        this.post.setTitle("Titulo de post de prueba");
        this.post.setPublicationDate(new Date());
        this.post.setContent("Este es el contenido de la post de prueba. Puede contener <strong>texto en HTML</strong>");
        this.post.setStatus("vigente");
        this.post.setUser(new User(2));

	    this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }



    @Test
    public void insertPostTest() {
        assert this.userPostDao.insert(this.post) > 0;
    }


    @Test
    public void selectPostTest() {
        this.insertPostTest();

        UserPost entrada = this.userPostDao.select(this.post.getId());

        assert entrada.getId() == this.post.getId();
        assert entrada.getPublicationDate().getTime() == this.post.getPublicationDate().getTime();
    }



    @Test
    public void selectUserPostTest() {
        this.insertPostTest();
        List<UserPost> posts = this.userPostDao.select(new CriterionImpl(EntradaSearchCriteriaEnum.USUARIO), false, 1);

        assert ! posts.isEmpty();
    }



    @Test
    public void selectPostByTitleTest() {
        this.insertPostTest();
        List<UserPost> posts = this.userPostDao.select(new CriterionImpl(EntradaSearchCriteriaEnum.TITLE), false, "%itulo%");

        assert ! posts.isEmpty();
    }



    @Test
    public void selectPostsTest() {
        this.insertPostTest();

        Page<UserPost> page = this.userPostDao.selectAll(1, true);

        assert ! page.getItems().isEmpty();
    }


	@Test
	public void testByDate() throws ParseException {

		Page<UserPost> posts = this.userPostDao.selectDayEntries(1, false, this.dateFormat.parse("2013-03-12"));

		assert posts != null;
		assert ! posts.isEmpty();

	}



    @Test
    public void testWhichDaysHasEntries() throws ParseException {
        Date date = this.dateFormat.parse("2013-05-12");
        List<Integer> days = this.userPostDao.selectWhichDaysHasEntries(date);

        assert days != null;
        assert ! days.isEmpty();
    }
}
