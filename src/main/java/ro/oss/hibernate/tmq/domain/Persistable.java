package ro.oss.hibernate.tmq.domain;

import javax.persistence.EntityListeners;

/**
 * Created by daniel on 25.11.2017.
 */
@EntityListeners(PersistentListener.class)
public interface Persistable {

    Persistent getPersistent();

    void setPersistent(Persistent persistent);
}
