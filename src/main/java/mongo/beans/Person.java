package mongo.beans;

import mongo.events.CascadeSave;
import mongo.events.RefrencesHolder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */
@Document
public class Person {
    private String name;
    @Id
    private int age;


    @RefrencesHolder
    @CascadeSave
    @DBRef
    private ArrayList<DBReference> references;

    public void addRefrence(DBReference dbReference)
    {
        if(references == null)
        {
            references = new ArrayList<>();
        }
        references.add(dbReference);
    }

    public List<DBReference> getReferences() {
        return references;
    }

    public void setReferences(ArrayList<DBReference> references) {
        this.references = references;
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}


