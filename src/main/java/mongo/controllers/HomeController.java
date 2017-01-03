package mongo.controllers;

import mongo.beans.Account;
import mongo.beans.Address;
import mongo.beans.Person;
import mongo.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/1/4.
 */
@RestController
public class HomeController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "person/{age}/{name}", method = RequestMethod.POST)
    public void save(@PathVariable int age, @PathVariable String name) {
        Person person = new Person(name, age);

        Account icbc = new Account("ICBC", age);
        Address address = new Address("ICBC");
        icbc.addRefrence(address);
        Account cbc = new Account("CBC", age);
        Address address2 = new Address("CBC");
        cbc.addRefrence(address2);
        person.addRefrence(icbc);
        person.addRefrence(cbc);

        personRepository.save(person);
    }
}
