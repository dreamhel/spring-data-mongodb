package mongo.events;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by g00216500 on 2017/1/12.
 */
public class CascadeDeleteCallBack implements ReflectionUtils.FieldCallback{
    private Object source;
    private MongoTemplate mongoTemplate;
    private String collectionName;

    @Override
    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
        ReflectionUtils.makeAccessible(field);
        if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(DBCascade.class)) {

            if (List.class.isAssignableFrom(field.getDeclaringClass())) {
//                for (Object obj : (List<?>) fieldValue) {
//                    if (obj.getClass().isAnnotationPresent(Document.class)) {
//                        mongoTemplate.remove(obj);
//                    }
                }

             else {
                mongoTemplate.remove(field);
            }
        }
    }

    public CascadeDeleteCallBack(Object source, MongoTemplate mongoTemplate, String collectionName) {
        super();
        this.source = source;
        this.mongoTemplate = mongoTemplate;
        this.collectionName = collectionName;
    }
}
