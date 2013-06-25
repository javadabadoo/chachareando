package doo.daba.java.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;



/**
 * Esta clase se encarga de reemplazar el placeholder configurer de Spring
 * para interceptar el metodo de carga de propiedades cargadas via archivo
 * properties.
 * 
 * @author Gerardo Aquino
 * @since 09/03/2011
 * @version 1.0
 */
public class PropertiesContainer extends PropertyPlaceholderConfigurer {


    static {
        propertiesMap = new HashMap<String, String> ();
    }


	/**
	 * Propiedad que almacena las propiedades leidas del archivo properties
	 */
	private static Map<String, String> propertiesMap;



    /**
     * Metodo encargado de realizar la carga del archivo de propiedades.
     * 
     * Este metodo esta sobreescrito para reemplazarlo de su clase padre
     * {@code PropertyPlaceholderConfigurer} y garantizar la carga de 
     * propiedades en la propiedad {@link #propertiesMap}
     * 
     * @see PropertyPlaceholderConfigurer
     */
	@Override
	@SuppressWarnings("deprecation")
    protected void processProperties (ConfigurableListableBeanFactory beanFactory, Properties props) {
		super.processProperties (beanFactory, props);

		for (Object key : props.keySet ()) {
			String keyStr = key.toString ();
			propertiesMap.put(
                    keyStr,
                    parseStringValue(
                            props.getProperty(keyStr),
                            props, new HashSet<String>()));
		}
	}



	public static String get(String name, Object... params) {

        return (params == null || params.length == 0) ?
                propertiesMap.get(name).toString()
                :
                String.format(propertiesMap.get(name).toString(), params);

    }
	
}
