package ro.oss.hibernate.tmq.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by daniel on 29.10.2017.
 */
@Entity
@Table(name = "user_attributes")
@DynamicInsert
@DynamicUpdate
@EntityListeners({AuditListener.class, PersistentListener.class})
public class UserAttribute extends DefaultAttribute<UserAttributeType, User, Integer> implements Persistable, Auditable{

    public static final String USERNAME_CREDENTIAL = "ro.oss.platform.attributes.user.credential.username";
    public static final String USERNAME_FACEBOOK = "ro.oss.platform.attributes.user.facebook.username";
    public static final String USERNAME_GOOGLE = "ro.oss.platform.attributes.user.google.username";
    public static final String USERNAME_LINKEDIN = "ro.oss.platform.attributes.user.linkedin.username";
    public static final String USERNAME_MICROSOFT = "ro.oss.platform.attributes.user.microsoft.username";
    public static final String USERNAME_TWITTER = "ro.oss.platform.attributes.user.twitter.username";
    public static final String USERNAME_YAHOO = "ro.oss.platform.attributes.user.yahoo.username";

    public static final String FULL_NAME = "ro.oss.platform.attributes.user.name";
    public static final String AVATAR_URL = "ro.oss.platform.attributes.user.avatarUrl";
    public static final String JWT_REMEMBER_ME = "ro.oss.platform.attributes.user.jwt.rememberMe";

    public static final String ACTIVATE_SIGNUP = "ro.oss.platform.attributes.user.signup.activate";

    @Id
    @Column(name = "USER_ATTRIBUTE_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer userAttributeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "ATTR_TYPE")
    private UserAttributeType type;

    @Embedded
    private Audit audit;

    @Embedded
    private Persistent persistent;

    public Integer getUserAttributeId() {
        return userAttributeId;
    }

    public void setUserAttributeId(Integer userAttributeId) {
        this.userAttributeId = userAttributeId;
    }

    @Override
    public Integer getId() {
        return userAttributeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getEntity() {
        return getUser();
    }

    @Override
    public void setEntity(User entity) {
        setUser(entity);
    }

    @Override
    public UserAttributeType getType() {
        return type;
    }

    @Override
    public void setType(UserAttributeType type) {
        this.type = type;
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
        UserAttribute that = (UserAttribute) o;
        return Objects.equals(userAttributeId, that.userAttributeId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userAttributeId);
    }

    public static final class UserAttributeBuilder {
        private String key;
        private String name;
        private String value;
        private AttributeScope scope;
        private Integer userAttributeId;
        private User user;
        private UserAttributeType type;
        private Audit audit;
        private Persistent persistent;

        private UserAttributeBuilder() {
        }

        public static UserAttributeBuilder builder() {
            return new UserAttributeBuilder();
        }

        public UserAttributeBuilder withKey(String key) {
            this.key = key;
            return this;
        }

        public UserAttributeBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserAttributeBuilder withValue(String value) {
            this.value = value;
            return this;
        }

        public UserAttributeBuilder withScope(AttributeScope scope) {
            this.scope = scope;
            return this;
        }

        public UserAttributeBuilder withUserAttributeId(Integer userAttributeId) {
            this.userAttributeId = userAttributeId;
            return this;
        }

        public UserAttributeBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public UserAttributeBuilder withType(UserAttributeType type) {
            this.type = type;
            return this;
        }

        public UserAttributeBuilder withAudit(Audit audit) {
            this.audit = audit;
            return this;
        }

        public UserAttributeBuilder withPersistent(Persistent persistent) {
            this.persistent = persistent;
            return this;
        }

        public UserAttribute build() {
            UserAttribute userAttribute = new UserAttribute();
            userAttribute.setKey(key);
            userAttribute.setName(name);
            userAttribute.setValue(value);
            userAttribute.setScope(scope);
            userAttribute.setUserAttributeId(userAttributeId);
            userAttribute.setUser(user);
            userAttribute.setType(type);
            userAttribute.setAudit(audit);
            userAttribute.setPersistent(persistent);
            return userAttribute;
        }
    }
}
