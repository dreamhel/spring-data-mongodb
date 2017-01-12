package mongo.beans;


import mongo.events.DBCascade;
import mongo.events.RefrencesHolder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */
@Document(collection = "person")
public class Person implements Reference {
    private String name;
    @Id
    private int age;
    @DBRef
    @DBCascade
    private ArrayList<Reference> references;

    public void addRefrence(Reference reference)
    {
        if(references == null)
        {
            references = new ArrayList<>();
        }
        references.add(reference);
    }

    public ArrayList<Reference> getReferences() {
        return references;
    }

    public void setReferences(ArrayList<Reference> references) {
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


    @Override
    public Class<? extends Annotation> annotationType() {
        return Person.class;
    }
}


