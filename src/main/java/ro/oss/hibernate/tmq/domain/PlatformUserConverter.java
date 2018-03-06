package ro.oss.hibernate.tmq.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by daniel on 03.11.2017.
 */
@Converter
public class PlatformUserConverter implements AttributeConverter<PlatformUser, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PlatformUser attribute) {
        if (attribute == null){
            return null;
        }
        return attribute.getId();
    }

    @Override
    public PlatformUser convertToEntityAttribute(Integer dbData) {
        if (dbData == null){
            return null;
        }
        return () -> dbData;
    }
}