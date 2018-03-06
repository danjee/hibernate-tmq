package ro.oss.hibernate.tmq.domain;

import javax.persistence.PrePersist;
import java.util.Objects;

/**
 * Created by daniel on 13.11.2017.
 */
public class PersistentListener {

    @PrePersist
    public void beforeSave(Persistable persistable){
        Persistent persistent = persistable.getPersistent();
        if (Objects.isNull(persistent)){
            persistent = new Persistent();
            persistable.setPersistent(persistent);
        }
        persistent.setDeleted(Boolean.FALSE);
        if (persistent.getStatus() == null){
            persistent.setStatus(EntityStatus.NA);
        }
    }
}
