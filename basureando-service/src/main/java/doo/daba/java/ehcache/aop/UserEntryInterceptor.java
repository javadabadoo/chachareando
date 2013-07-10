package doo.daba.java.ehcache.aop;

import doo.daba.java.servicio.interfaces.UserEntryService;
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
public class UserEntryInterceptor {

    @Autowired
    CacheManager cacheManager;

    /**
     * Interceptando la ejecución del método {@code getUserEntry} del servicio {@code UserEntryService}
     *
     * @see UserEntryService#saveEntry(doo.daba.java.beans.UserEntry)
     */
    @Pointcut("execution(* doo.daba.java.servicio.interfaces.UserEntryService.saveEntry(..))")
    public void saveEntryPointcut() { }


    /**
     * Se ejecuta desdpues del método interceptado por {@link #saveEntryPointcut()}
     * para limpiar el caché
     */
    @After("saveEntryPointcut()")
    public void clearCache() {
        this.cacheManager.getCache("getAllUserEntries").clear();
    }

}
