package doo.daba.java.servicio;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/07/13
 */
public class UserEntriesEventListener implements CacheEventListener {

    private final static UserEntriesEventListener INSTANCE = new UserEntriesEventListener();

    public static UserEntriesEventListener getInstance() {
        return INSTANCE;
    }

    @Override
    public void notifyElementRemoved(Ehcache cache, Element element) throws CacheException {
        System.out.println("notifyElementRemoved");
    }

    @Override
    public void notifyElementPut(Ehcache cache, Element element) throws CacheException {
        System.out.println("notifyElementPut");
    }

    @Override
    public void notifyElementUpdated(Ehcache cache, Element element) throws CacheException {
        System.out.println("notifyElementUpdated");
    }

    @Override
    public void notifyElementExpired(Ehcache cache, Element element) {
        System.out.println("notifyElementExpired");
    }

    @Override
    public void notifyElementEvicted(Ehcache cache, Element element) {
        System.out.println("notifyElementEvicted");
    }

    @Override
    public void notifyRemoveAll(Ehcache cache) {
        System.out.println("notifyRemoveAll");
    }

    @Override
    public void dispose() {
        System.out.println("dispose");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton instance");
    }
}
