package doo.daba.java.ehcache.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/07/13
 *
 * El objetivo de este interceptor es moitorear los métodos que alteren los registros
 * de las entradas para limpiar el caché.
 */
@Aspect
@Component
public class UserPostInterceptor {

    @Autowired
    CacheManager cacheManager;

    /**
     * Interceptando la ejecución del método {@code UserPostService#savePost} del servicio {@code UserPostService}
     *
     * @see doo.daba.java.servicio.interfaces.UserPostService#savePost(doo.daba.java.beans.UserPost)
     */
    @Pointcut("execution(* doo.daba.java.servicio.interfaces.UserPostService.savePost(..))")
    public void savePostPointcut() { }


    /**
     * Se ejecuta desdpues del método interceptado por {@link #savePostPointcut()}
     * para limpiar el caché
     */
    @After("savePostPointcut()")
    public void clearCache() {
        this.cacheManager.getCache("getAllUserPosts").clear();
        this.cacheManager.getCache("getRecentEntries").clear();
        this.cacheManager.getCache("getRecentComments").clear();
    }

}
