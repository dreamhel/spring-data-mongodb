package mongo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.*;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2016/12/29.
 */
@Component
public class CascadeSaveMongoEventListener  extends AbstractMongoEventListener<Object> {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private AbstractApplicationContext context;

    @PostConstruct
    private void registerEvent()
    {
        context.addApplicationListener(this);
    }



    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        ReflectionUtils.doWithFields(event.getSource().getClass(), new CascadeSaveCallback(event.getSource(), mongoTemplate));
            }

    @Override
    public void onBeforeDelete(BeforeDeleteEvent<Object> event) {
           //  ReflectionUtils.doWithFields(event.getType(), new CascadeDeleteCallBack(event.getSource(), mongoTemplate, event.getCollectionName()) );

    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<Object> event) {
        int a = 1;
    }
}
