package ro.oss.hibernate.tmq.domain;

import javax.persistence.PrePersist;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by daniel on 17.11.2017.
 */
public class AttributeListener {

    @PrePersist
    public void beforeSave(Attribute attribute){
        if (attribute.getKey() == null){
            attribute.setKey(UUID.randomUUID().toString());
        }
        if (Objects.isNull(attribute.getScope())){
            attribute.setScope(AttributeScope.DEFAULT);
        }
    }
}
