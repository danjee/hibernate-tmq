package ro.oss.hibernate.tmq.domain;

/**
 * Created by daniel on 29.10.2017.
 */

/**
 *  Attribute scopes defines the level of which it can be used
 */
public enum AttributeScope {

    /**
     *  Attributes with this scope will be persisted in the database and also are public accessible through APIs
     */
    DEFAULT(0),

    /**
     *  Attributes with this scop will be persisted in the database but are not public accessible through APIs
     */
    INTERNAL(1<<0),

    /**
     *  Attributes with this scope are not persisted in the database but are public accessible through APIs
     */
    TRANSIENT(1<<1),

    /**
     *  Attributes with this scope are not persisted in the database and are not public accessible through APIs
     */
    VOLATILE(1<<2);

    private int value;

    AttributeScope(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
