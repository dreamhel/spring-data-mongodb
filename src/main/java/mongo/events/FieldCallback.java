package mongo.events;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;

/**
 * Created by Administrator on 2016/12/29.
 */
public class FieldCallback  implements ReflectionUtils.FieldCallback {
    private boolean idFound;

    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
        ReflectionUtils.makeAccessible(field);
        AnnotatedType t = field.getAnnotatedType();        ;
        if (field.isAnnotationPresent(DBRef.class)) {
            idFound = true;
        }
    }

    public boolean isIdFound() {
        return idFound;
    }
}
