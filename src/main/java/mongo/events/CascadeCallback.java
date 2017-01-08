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
public class CascadeCallback implements ReflectionUtils.FieldCallback {
    private Object source;
    private MongoTemplate mongoTemplate;

    public CascadeCallback(Object source, MongoTemplate mongoTemplate) {
        super();
        this.source = source;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
        ReflectionUtils.makeAccessible(field);

        if(field.isAnnotationPresent(DBRef.class))
        {
        //    Reference.class.isAssignableFrom((Class)((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0]);
            Reference.class.isAssignableFrom((Class)((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0]);
            Class<?> sourceClass = field.get(source).getClass();
           if( List.class.isAssignableFrom(sourceClass) )
            {

            }
//             for(int i = 0; i< fieldValue.size();++i)
//             {
//                 DBReference s = fieldValue.get(i);
//                 boolean b =  s.getClass().isAnnotationPresent(Document.class);
//                 mongoTemplate.save(s);
//             }
             return;
        }
        if (field.isAnnotationPresent(DBRef.class));

//                field.isAnnotationPresent(CascadeSave.class)) {
//            Object fieldValue =    field.get(source);
//            if (fieldValue != null) {
//                FieldCallback callback = new FieldCallback();
//                ReflectionUtils.doWithFields(fieldValue.getClass(), callback);
//                if (!callback.isIdFound()) {
//                    throw new MappingException("Cannot perform cascade save on child object without id set");
//                }
//
//                mongoTemplate.save(fieldValue);
//            }
        //}
//        if(field.isAnnotationPresent(RefrencesHolder.class) &&
//                field.isAnnotationPresent(CascadeSave.class))
//        {
//            Object fieldValues =  field.get(source);
//            int a = 1;
//
//        }
    }




}
