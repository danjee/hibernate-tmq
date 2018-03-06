package ro.oss.hibernate.tmq.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by daniel on 09.11.2017.
 */
@Entity
@Table(name = "credential")
@DynamicInsert
@DynamicUpdate
@EntityListeners({AuditListener.class, PersistentListener.class})
public class Credential implements Persistable, Auditable, Identifiable<Integer> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CREDENTIAL_ID")
    private Integer credentialId;

    @Column(name = "PASSWORD")
    private String password;

    @Embedded
    private Audit audit;

    @Embedded
    private Persistent persistent;

    public Integer getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Integer getId() {
        return credentialId;
    }

    @Override
    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @Override
    public Persistent getPersistent() {
        return persistent;
    }

    @Override
    public void setPersistent(Persistent persistent) {
        this.persistent = persistent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credential that = (Credential) o;
        return Objects.equals(credentialId, that.credentialId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(credentialId);
    }

    public static final class CredentialBuilder {
        private Integer credentialId;
        private String password;
        private Audit audit;
        private Persistent persistent;

        private CredentialBuilder() {
        }

        public static CredentialBuilder builder() {
            return new CredentialBuilder();
        }

        public CredentialBuilder withCredentialId(Integer credentialId) {
            this.credentialId = credentialId;
            return this;
        }

        public CredentialBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public CredentialBuilder withAudit(Audit audit) {
            this.audit = audit;
            return this;
        }

        public CredentialBuilder withPersistent(Persistent persistent) {
            this.persistent = persistent;
            return this;
        }

        public Credential build() {
            Credential credential = new Credential();
            credential.setCredentialId(credentialId);
            credential.setPassword(password);
            credential.setAudit(audit);
            credential.setPersistent(persistent);
            return credential;
        }
    }
}
