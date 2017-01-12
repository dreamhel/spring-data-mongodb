package mongo.beans;

import mongo.events.DBCascade;
import mongo.events.RefrencesHolder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/4.
 */
@Document
public class Account  implements Reference {
    @Id
    private String bank;


    @Override
    public Class<? extends Annotation> annotationType() {
        return Account.class;
    }

    @DBRef
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

    public Account() {
    }


    private int number;

    public Account(String bank, int number) {
        this.bank = bank;
        this.number = number;
    }



    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
