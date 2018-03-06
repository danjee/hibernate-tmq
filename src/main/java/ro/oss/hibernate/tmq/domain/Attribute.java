package ro.oss.hibernate.tmq.domain;

import java.io.Serializable;

/**
 * Created by daniel on 29.10.2017.
 */
public interface Attribute<A extends AttributeType, E extends PlatformEntity, AID extends Serializable> extends Identifiable<AID> {

    E getEntity();

    void setEntity(E platformEntity);

    String getKey();

    void setKey(String key);

    String getName();

    void setName(String name);

    String getValue();

    void setValue(String value);

    AttributeScope getScope();

    void setScope(AttributeScope scope);

    A getType();

    void setType(A type);

}
