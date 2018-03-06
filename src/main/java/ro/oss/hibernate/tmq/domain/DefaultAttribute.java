package ro.oss.hibernate.tmq.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by daniel on 29.10.2017.
 */
@EntityListeners(AttributeListener.class)
@MappedSuperclass
public abstract class DefaultAttribute<A extends AttributeType, E extends PlatformEntity, AID extends Serializable> implements Attribute<A, E, AID> {

    @Column(name = "ATTR_KEY")
    private String key;

    @Column(name = "ATTR_NAME")
    private String name;

    @Column(name = "ATTR_VALUE")
    private String value;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ATTR_SCOPE")
    private AttributeScope scope;

    public abstract E getEntity();

    @Override
    public abstract void setEntity(E platformEntity);

    @Override
    public abstract A getType();

    @Override
    public abstract void setType(A type);

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public AttributeScope getScope() {
        return scope;
    }

    @Override
    public void setScope(AttributeScope scope) {
        this.scope = scope;
    }
}
