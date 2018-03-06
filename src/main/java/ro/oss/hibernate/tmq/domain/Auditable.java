package ro.oss.hibernate.tmq.domain;

/**
 * Created by daniel on 25.11.2017.
 */
public interface Auditable {

    Audit getAudit();

    void setAudit(Audit audit);
}
