package ro.oss.hibernate.tmq.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by daniel on 29.10.2017.
 */
public interface PlatformEntity<T extends Attribute<?, ?, ?>, ID extends Serializable> extends Identifiable<ID> {

    Collection<T> getAttributes();

    void setAttributes(Collection<T> attributes);

}
