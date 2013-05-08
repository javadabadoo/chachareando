package doo.daba.java.basureando.doo.daba.java.basureando.config.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 8/05/13
 * To change this template use File | Settings | File Templates.
 */
public class ObjectMapperFactoryBean implements FactoryBean<ObjectMapper> {

    @Override
    public ObjectMapper getObject() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        return mapper;
    }

    @Override
    public Class<?> getObjectType() {
        return ObjectMapper.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
