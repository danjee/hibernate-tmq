package ro.oss.hibernate.tmq.domain;

/**
 * Created by daniel on 29.10.2017.
 */
public enum EntityStatus {
    NA,
    UNKNOWN,
    ACTIVATING,
    ACTIVATED,
    DEACTIVATING,
    DEACTIVATED,
    SUSPENDING,
    SUSPENDED
}
