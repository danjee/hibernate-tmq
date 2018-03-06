package ro.oss.hibernate.tmq.domain;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by daniel on 12.11.2017.
 */
public class AuditListener {

    @PrePersist
    public void beforeSave(Auditable auditable){
        Audit audit = auditable.getAudit();
        if (Objects.isNull(audit)){
            audit = new Audit();
            auditable.setAudit(audit);
        }
        audit.setCreatedAt(LocalDateTime.now());
        audit.setCreatedBy(() -> 1);
        audit.setUpdatedAt(LocalDateTime.now());
        audit.setUpdatedBy(() -> 1);
    }

    @PreUpdate
    public void beforeUpdate(Auditable auditable){
        Audit audit = auditable.getAudit();
        audit.setUpdatedAt(LocalDateTime.now());
        audit.setUpdatedBy(() -> 1);
    }
}
