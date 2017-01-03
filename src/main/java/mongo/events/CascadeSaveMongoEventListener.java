package mongo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
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
        ReflectionUtils.doWithFields(event.getSource().getClass(), new CascadeCallback(event.getSource(), mongoTemplate));
    }
}
