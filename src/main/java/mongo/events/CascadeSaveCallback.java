package mongo.events;

import org.springframework.data.annotation.Reference;
import org.springframework.data.mapping.model.MappingException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */
public class CascadeSaveCallback implements ReflectionUtils.FieldCallback {
    private Object source;
    private MongoTemplate mongoTemplate;

    public CascadeSaveCallback(Object source, MongoTemplate mongoTemplate) {
        super();
        this.source = source;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {

        ReflectionUtils.makeAccessible(field);

        if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(DBCascade.class)) {
            Class<?> sourceClass = field.get(source).getClass();
            Object fieldValue = field.get(source);
            if (List.class.isAssignableFrom(sourceClass)) {
                for (Object obj : (List<?>) fieldValue) {
                    if (obj.getClass().isAnnotationPresent(Document.class)) {
                        mongoTemplate.save(obj);
                    }
                }

            } else {
                mongoTemplate.save(field);
            }
        }
    }
}