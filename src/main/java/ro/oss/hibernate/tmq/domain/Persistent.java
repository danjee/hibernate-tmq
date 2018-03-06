package ro.oss.hibernate.tmq.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by daniel on 25.11.2017.
 */
@Embeddable
public class Persistent  {

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private EntityStatus status;

    @Column(name = "DELETED")
    private Boolean deleted;

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


    public static final class PersistentBuilder {
        private EntityStatus status;
        private Boolean deleted;

        private PersistentBuilder() {
        }

        public static PersistentBuilder builder() {
            return new PersistentBuilder();
        }

        public PersistentBuilder withStatus(EntityStatus status) {
            this.status = status;
            return this;
        }

        public PersistentBuilder withDeleted(Boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public Persistent build() {
            Persistent persistent = new Persistent();
            persistent.setStatus(status);
            persistent.setDeleted(deleted);
            return persistent;
        }
    }
}
