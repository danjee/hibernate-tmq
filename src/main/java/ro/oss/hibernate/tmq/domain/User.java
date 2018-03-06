package ro.oss.hibernate.tmq.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by daniel on 29.10.2017.
 */
@Entity
@Table(name = "user")
@DynamicInsert
@DynamicUpdate
@EntityListeners({AuditListener.class, PersistentListener.class})
public class User implements PlatformEntity<UserAttribute, Integer>, Persistable, Auditable, Identifiable<Integer>, PlatformUser {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ENTITY_ID")
    private Integer userId;

    @Column(name = "USERNAME")
    private String username;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name="CREDENTIAL_ID")
    private Credential credential;

    @OneToMany(targetEntity = UserAttribute.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "user")
    private Collection<UserAttribute> attributes;

    @Embedded
    private Audit audit;

    @Embedded
    private Persistent persistent;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public Collection<UserAttribute> getAttributes() {
        return attributes;
    }

    @Override
    public void setAttributes(Collection<UserAttribute> attributes) {
        this.attributes = attributes;
    }


    @Override
    public Audit getAudit() {
        return audit;
    }

    @Override
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
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId);
    }

    @Override
    public Integer getId() {
        return userId;
    }

    public static final class UserBuilder {
        private Integer userId;
        private String username;
        private Credential credential;
        private Audit audit;
        private Persistent persistent;

        private UserBuilder() {
        }

        public static UserBuilder builder() {
            return new UserBuilder();
        }

        public UserBuilder withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder withCredential(Credential credential) {
            this.credential = credential;
            return this;
        }

        public UserBuilder withAudit(Audit audit) {
            this.audit = audit;
            return this;
        }

        public UserBuilder withPersistent(Persistent persistent) {
            this.persistent = persistent;
            return this;
        }

        public User build() {
            User user = new User();
            user.setUserId(userId);
            user.setUsername(username);
            user.setCredential(credential);
            user.setAudit(audit);
            user.setPersistent(persistent);
            return user;
        }
    }
}
