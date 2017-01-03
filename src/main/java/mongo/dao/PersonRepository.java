package mongo.dao;

import mongo.beans.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */
public interface PersonRepository  extends MongoRepository<Person,Integer> {
    @Override
    public Person findOne(Integer integer);

    List<Person> getPersonByAge();

}
