package doo.daba.java.servicio;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/07/13
 */
public class UserEntriesEventListenerFactory extends CacheEventListenerFactory {
    @Override
    public CacheEventListener createCacheEventListener(Properties properties) {
        return EhcacheEventListener.getInstance();
    }
}
