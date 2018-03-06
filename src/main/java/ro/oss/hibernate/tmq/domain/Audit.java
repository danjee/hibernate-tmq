package ro.oss.hibernate.tmq.domain;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * Created by daniel on 25.11.2017.
 */
@Embeddable
public class Audit {

    @Column(name = "CREATED_BY")
    @Convert(converter = PlatformUserConverter.class)
    private PlatformUser createdBy;

    @Column(name = "CREATED_AT")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_BY")
    @Convert(converter = PlatformUserConverter.class)
    private PlatformUser updatedBy;

    @Column(name = "UPDATED_AT")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime updatedAt;

    public PlatformUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(PlatformUser createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public PlatformUser getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(PlatformUser updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    public static final class AuditBuilder {
        private PlatformUser createdBy;
        private LocalDateTime createdAt;
        private PlatformUser updatedBy;
        private LocalDateTime updatedAt;

        private AuditBuilder() {
        }

        public static AuditBuilder builder() {
            return new AuditBuilder();
        }

        public AuditBuilder withCreatedBy(PlatformUser createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AuditBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AuditBuilder withUpdatedBy(PlatformUser updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public AuditBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Audit build() {
            Audit audit = new Audit();
            audit.setCreatedBy(createdBy);
            audit.setCreatedAt(createdAt);
            audit.setUpdatedBy(updatedBy);
            audit.setUpdatedAt(updatedAt);
            return audit;
        }
    }
}
