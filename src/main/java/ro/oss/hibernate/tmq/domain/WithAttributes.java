package ro.oss.hibernate.tmq.domain;

import java.util.Collection;

/**
 * Created by daniel on 29.10.2017.
 */
public interface WithAttributes<T> {

    Collection<T> getAttributes();

    void setAttributes(Collection<T> attributes);
}
