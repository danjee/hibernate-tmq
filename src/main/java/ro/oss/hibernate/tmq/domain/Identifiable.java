package ro.oss.hibernate.tmq.domain;

import java.io.Serializable;

/**
 * Created by daniel on 29.10.2017.
 */
public interface Identifiable<ID extends Serializable> extends Serializable {

    ID getId();

}
